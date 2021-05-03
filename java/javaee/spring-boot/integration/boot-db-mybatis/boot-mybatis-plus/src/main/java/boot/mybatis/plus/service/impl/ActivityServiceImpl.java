package boot.mybatis.plus.service.impl;

import boot.mybatis.common.model.entity.Activity;
import boot.mybatis.common.model.vo.ActivityVO;
import boot.mybatis.plus.mapper.ActivityMapper;
import boot.mybatis.plus.service.ActivityService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
