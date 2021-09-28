package boot.mybatis.plus.service;

import boot.mybatis.common.model.dto.PhaseDTO;
import boot.mybatis.common.model.entity.Phase;
import boot.mybatis.common.model.vo.PhaseVO;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface PhaseService extends IBaseService<Phase> {

    /**
     * 获取指定的阶段信息
     *
     * @param id 指定的阶段标识
     * @param type 标识具体活动
     * @return
     */
    PhaseVO getPhase(Long id, String type);

    /**
     * 更新指定的阶段信息
     *
     * @param phase 阶段信息
     * @return
     */
    Boolean updatePhase(@NotNull PhaseDTO phase);

    /**
     * 删除指定的阶段信息
     *
     * @param id 指定的阶段标识
     * @return
     */
    Boolean deletePhase(Long id);

    /**
     * 创建阶段信息
     *
     * @param phase
     * @return
     */
    Boolean createPhase(PhaseDTO phase);

    /**
     * 获取所有阶段信息
     *
     * @param type 标识具体活动
     * @return
     */
    List<PhaseVO> listPhases(String type);
}
