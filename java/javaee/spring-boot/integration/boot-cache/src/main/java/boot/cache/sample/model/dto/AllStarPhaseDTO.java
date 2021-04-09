package boot.cache.sample.model.dto;

import boot.cache.sample.constants.enums.AllStarPhaseStatusEnum;
import boot.cache.sample.util.Add;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zack <br>
 * @create 2021-04-09 10:21 <br>
 * @project integration <br>
 */
@Data
@NoArgsConstructor
public class AllStarPhaseDTO implements Serializable {

  @ApiModelProperty(hidden = true)
  private Long id;

  @ApiModelProperty("阶段Code")
  @NotNull(
      groups = {Add.class},
      message = "phaseCode 不能为空")
  private String phaseCode;

  @ApiModelProperty("阶段名称")
  @NotNull(
      groups = {Add.class},
      message = "phaseName 不能为空")
  private String phaseName;

  @ApiModelProperty("阶段开始时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @NotNull(
      groups = {Add.class},
      message = "startTime 不能为空")
  private LocalDateTime startTime;

  @ApiModelProperty("阶段结束时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @NotNull(
      groups = {Add.class},
      message = "endTime 不能为空")
  private LocalDateTime endTime;

  @ApiModelProperty(hidden = true)
  private String type;

  @ApiModelProperty(hidden = true)
  private AllStarPhaseStatusEnum status;

  public AllStarPhaseDTO(Long id, String type) {
    this.id = id;
    this.type = type;
  }
}
