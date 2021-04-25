package boot.mybatis.async.service;

import boot.mybatis.common.model.dto.PhaseDTO;
import boot.mybatis.common.model.entity.Phase;
import boot.mybatis.common.model.vo.PhaseVO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.validation.annotation.Validated;

import java.util.concurrent.Future;

@Validated
public interface PhaseService extends IService<Phase> {

  /**
   * 创建阶段信息: 无返回值
   *
   * @param phase
   * @return
   */
  void createPhase(PhaseDTO phase);

  /**
   * 有返回值
   *
   * @param id
   * @return
   */
  Future<PhaseVO> getPhase(Long id);

  /**
   * 异步调用 + 无返回值 + 事务测试.
   *
   * <pre>
   *     1. transaction and async will work together.
   *     2. the query and insert operation will be executed by two thread.
   * </pre>
   *
   * @param dto
   * @param exFlag
   */
  void asyncTask4Transaction(PhaseDTO dto, Boolean exFlag);
}
