package boot.cache.sample.model.vo;

import boot.cache.sample.constants.enums.AllStarPhaseStatusEnum;
import boot.cache.sample.model.entity.AllStarPhase;
import cn.hutool.core.bean.BeanUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zack <br>
 * @create 2021-04-09 10:15 <br>
 * @project integration <br>
 */
@Data
@NoArgsConstructor
public class AllStarPhaseVO implements Serializable {
  private Long id;

  @ApiModelProperty("阶段 Code")
  private String phaseCode;

  @ApiModelProperty("阶段名称")
  private String phaseName;

  private LocalDateTime startTime;

  private LocalDateTime endTime;

  private String type;

  private AllStarPhaseStatusEnum status;

  private Boolean isDeleted;

  private LocalDateTime insertedTime;

  private LocalDateTime updatedTime;

  private Long insertedBy;

  private Long updatedBy;

  @JsonProperty("allStarActivities")
  private List<AllStarActivityVO> allStarActivityVO;

  public AllStarPhaseVO(String phaseCode, String phaseName) {
    this.phaseCode = phaseCode;
    this.phaseName = phaseName;
  }

  public AllStarPhaseVO(AllStarPhase po) {
    BeanUtil.copyProperties(po, this, "status");
  }
}
