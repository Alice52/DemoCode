package boot.mybatis.common.model.dto;

import boot.mybatis.common.constants.enums.PhaseStatusEnum;
import boot.mybatis.common.utils.ValidationUtil;
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
public class PhaseDTO implements Serializable {

    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty("阶段Code")
    @NotNull(
            groups = {ValidationUtil.Add.class},
            message = "phaseCode 不能为空")
    private String phaseCode;

    @ApiModelProperty("阶段名称")
    @NotNull(
            groups = {ValidationUtil.Add.class},
            message = "phaseName 不能为空")
    private String phaseName;

    @ApiModelProperty("阶段开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(
            groups = {ValidationUtil.Add.class},
            message = "startTime 不能为空")
    private LocalDateTime startTime;

    @ApiModelProperty("阶段结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(
            groups = {ValidationUtil.Add.class},
            message = "endTime 不能为空")
    private LocalDateTime endTime;

    @ApiModelProperty(hidden = true)
    private String type;

    @ApiModelProperty(hidden = true)
    private PhaseStatusEnum status;

    public PhaseDTO(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public PhaseDTO(Long id) {
        this.id = id;
    }
}
