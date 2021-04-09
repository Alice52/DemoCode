package boot.cache.sample.service;

import boot.cache.sample.model.dto.AllStarPhaseDTO;
import boot.cache.sample.model.entity.AllStarPhase;
import boot.cache.sample.model.vo.AllStarPhaseVO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface AllStarPhaseService extends IService<AllStarPhase> {

  /**
   * 获取当前活动的阶段信息
   *
   * @param type 标识具体活动
   * @return
   */
  AllStarPhaseVO currentStage(String type);

  /**
   * 获取指定的阶段信息
   *
   * @param id 指定的阶段标识
   * @param type 标识具体活动
   * @return
   */
  AllStarPhaseVO getPhase(Long id, String type);

  /**
   * 更新指定的阶段信息
   *
   * @param phase 阶段信息
   * @return
   */
  Boolean updatePhase(@NotNull AllStarPhaseDTO phase);

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
  Boolean createPhase(AllStarPhaseDTO phase);

  /**
   * 获取所有阶段信息
   *
   * @param type 标识具体活动
   * @return
   */
  List<AllStarPhaseVO> listPhases(String type);

  /**
   * 获取所有阶段信息, 包含每个阶段的活动信息
   *
   * @param type
   * @return
   */
  List<AllStarPhaseVO> listWithActivities(String type);
}
