package boot.cache.sample.service.impl;

import boot.cache.sample.mapper.AllStarActivityMapper;
import boot.cache.sample.model.entity.AllStarActivity;
import boot.cache.sample.service.AllStarActivityService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zack <br/>
 * @create 2021-04-09 10:24 <br/>
 * @project integration <br/>
 */
@Service
public class AllStarActivityServiceImpl extends ServiceImpl<AllStarActivityMapper, AllStarActivity>
        implements AllStarActivityService {

    @Override
    public List<AllStarActivity> queryByPhaseIds(List<Long> phaseIds) {

        LambdaQueryWrapper<AllStarActivity> queryWrapper =
                buildQueryWrapper().in(AllStarActivity::getPhaseId, phaseIds);

        return this.list(queryWrapper);
    }

    private static LambdaQueryWrapper<AllStarActivity> buildQueryWrapper() {
        return Wrappers.<AllStarActivity>query().lambda()
                .eq(AllStarActivity::getIsDeleted, 0);
    }
}
