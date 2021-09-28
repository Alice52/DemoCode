package boot.mybatis.plus.service.impl;

import boot.mybatis.common.model.entity.Activity;
import boot.mybatis.common.model.vo.ActivityVO;
import boot.mybatis.plus.mapper.ActivityMapper;
import boot.mybatis.plus.service.ActivityService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zack <br>
 * @create 2021-04-09 10:24 <br>
 * @project integration <br>
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity>
        implements ActivityService {

    @Override
    public List<ActivityVO> queryByPhaseIds(List<Long> phaseIds) {

        return this.list(Wrappers.<Activity>query().lambda().in(Activity::getPhaseId, phaseIds))
                .stream()
                .map(ActivityVO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<Map<String, Object>> selectMaps() {

        val wrapper =
                buildQueryWrapper()
                        .select(
                                Activity::getId,
                                Activity::getActivityCode,
                                Activity::getActivityName);

        List<Map<String, Object>> maps = baseMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);

        return maps;
    }

    /**
     *
     *
     * <pre>
     *   select
     *       avg(id) avg_id,
     *       min(id) min_id,
     *       max(id) max_id
     *   from activity
     *   group by id
     *   having sum(id) < 500;
     * </pre>
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> summarySelectMaps() {
        QueryWrapper<Activity> wrapper = new QueryWrapper<>();
        wrapper.select("id", "avg(id) avg_id", "min(id) id", "max(id) max_id")
                .groupBy("id")
                .having("sum(id) < {0}", 500);
        List<Map<String, Object>> maps = baseMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);

        return maps;
    }

    @Override
    public List<Object> selectObjs() {

        LambdaQueryWrapper<Activity> wrapper =
                buildQueryWrapper().select(Activity::getId, Activity::getActivityCode);

        wrapper.like(StringUtils.hasText(""), Activity::getActivityCode, "--");

        List<Object> objects = baseMapper.selectObjs(wrapper);
        objects.forEach(System.out::println);
        return objects;
    }

    @Override
    public List<Activity> wrapperEntity() {

        LambdaQueryWrapper<Activity> wrapper =
                buildQueryWrapper().setEntity(Activity.builder().phaseId(1L).build());

        List<Activity> activities = baseMapper.selectList(wrapper);
        activities.forEach(System.out::println);
        return activities;
    }
}
