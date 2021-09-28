package boot.mybatis.plus.service;

import boot.mybatis.common.model.entity.Activity;
import boot.mybatis.common.model.vo.ActivityVO;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * @author zack <br>
 * @create 2021-04-09 10:24 <br>
 * @project integration <br>
 */
@Validated
public interface ActivityService extends IBaseService<Activity> {

    /**
     * 获取某些阶段对应的活动
     *
     * @param phaseIds
     * @return
     */
    List<ActivityVO> queryByPhaseIds(@NotNull(message = "阶段Id不能为空") List<Long> phaseIds);

    /**
     * Usage sample 4 selectMaps.
     *
     * @return
     */
    List<Map<String, Object>> selectMaps();

    /**
     * Usage sample 4 selectMaps.
     *
     * @return
     */
    List<Map<String, Object>> summarySelectMaps();

    /**
     * Usage sample 4 selectObjs.
     *
     * @return
     */
    List<Object> selectObjs();

    /**
     * Usage sample 4 wrapper entity.
     *
     * @return
     */
    List<Activity> wrapperEntity();
}
