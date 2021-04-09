package boot.cache.sample.model.vo;

import boot.cache.sample.constants.enums.AllStarActivityStatusEnum;
import boot.cache.sample.model.entity.AllStarActivity;
import cn.hutool.core.bean.BeanUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zack <br/>
 * @create 2021-04-09 10:19 <br/>
 * @project integration <br/>
 */
@Data
@NoArgsConstructor
public class AllStarActivityVO implements Serializable {
    private Long id;

    private Long phaseId;

    private String activityCode;

    private String activityName;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private AllStarActivityStatusEnum status;

    public AllStarActivityVO(AllStarActivity allStarActivity) {
        BeanUtil.copyProperties(allStarActivity, this, "status");
    }
}