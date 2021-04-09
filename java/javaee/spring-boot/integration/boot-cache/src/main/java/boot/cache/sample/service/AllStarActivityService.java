package boot.cache.sample.service;

import boot.cache.sample.model.entity.AllStarActivity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author zack <br/>
 * @create 2021-04-09 10:24 <br/>
 * @project integration <br/>
 */
@Validated
public interface AllStarActivityService extends IService<AllStarActivity> {

    /**
     * 获取某些阶段对应的活动
     *
     * @param phaseIds
     * @return
     */
    List<AllStarActivity> queryByPhaseIds(@NotNull(message = "阶段Id不能为空") List<Long> phaseIds);
}

