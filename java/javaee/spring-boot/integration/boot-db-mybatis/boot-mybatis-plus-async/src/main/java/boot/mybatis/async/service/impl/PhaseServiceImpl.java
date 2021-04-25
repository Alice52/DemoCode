package boot.mybatis.async.service.impl;

import boot.mybatis.async.mapper.PhaseMapper;
import boot.mybatis.async.service.PhaseService;
import boot.mybatis.common.constants.enums.ActivityPhaseEnum;
import boot.mybatis.common.model.dto.PhaseDTO;
import boot.mybatis.common.model.entity.Phase;
import boot.mybatis.common.model.vo.PhaseVO;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.SneakyThrows;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author zack <br>
 * @create 2021-04-09 10:22 <br>
 * @project integration <br>
 */
@Service
public class PhaseServiceImpl extends ServiceImpl<PhaseMapper, Phase> implements PhaseService {

  @Resource private AsyncTaskExecutor asyncTaskExecutor;

  private static LambdaQueryWrapper<Phase> buildOneQueryWrapper() {
    return buildQueryWrapper();
  }

  private static LambdaQueryWrapper<Phase> buildQueryWrapper() {

    return Wrappers.<Phase>query().lambda();
  }

  @Async("asyncPoolExecutor")
  @Override
  public void createPhase(PhaseDTO dto) {

    validateDuplicateByCodeOrName(dto);

    Phase phase = new Phase();
    BeanUtil.copyProperties(dto, phase, "status");

    baseMapper.insert(phase);
  }

  @Async("asyncPoolExecutor")
  @Override
  public Future<PhaseVO> getPhase(Long id) {

    Phase phase = getByCondition(new PhaseDTO(id));
    PhaseVO phaseVO = new PhaseVO();
    BeanUtil.copyProperties(phase, phaseVO, "status");

    return AsyncResult.forValue(phaseVO);
  }

  @Async("asyncPoolExecutor")
  @Transactional(rollbackFor = Exception.class)
  @Override
  public void asyncTask4Transaction(PhaseDTO dto, Boolean exFlag) {

    createPhase(dto);
    if (exFlag) {
      throw new RuntimeException("模拟异常");
    }
  }

  @SneakyThrows
  private void validateDuplicateByCodeOrName(PhaseDTO dto) {

    CompletableFuture<Void> runAsync =
        CompletableFuture.runAsync(
            () -> ensureValidPhaseCode(dto.getPhaseCode()), asyncTaskExecutor);

    CompletableFuture<List<Phase>> listCompletableFuture =
        CompletableFuture.supplyAsync(
            () -> {
              LambdaQueryWrapper<Phase> queryWrapper =
                  buildQueryWrapper()
                      .and(
                          obj ->
                              obj.eq(Phase::getPhaseCode, dto.getPhaseCode())
                                  .or()
                                  .eq(Phase::getPhaseName, dto.getPhaseName()));

              if (ObjectUtil.isNotNull(dto.getId())) {
                queryWrapper.ne(Phase::getId, dto.getId());
              }

              return this.list(queryWrapper);
            },
            asyncTaskExecutor);

    CompletableFuture.allOf(listCompletableFuture, runAsync).join();

    if (!CollUtil.isEmpty(listCompletableFuture.get())) {
      throw new RuntimeException("阶段Code或者阶段名称重复");
    }
  }

  private void ensureValidPhaseCode(String phaseCode) {
    if (StrUtil.isNotEmpty(phaseCode)
        && Boolean.FALSE.equals(ActivityPhaseEnum.contains(phaseCode))) {
      throw new RuntimeException("不是有效的阶段 Code");
    }
  }

  private Phase getByCondition(PhaseDTO dto) {
    LambdaQueryWrapper<Phase> queryWrapper = buildQueryWrapper();

    Optional.ofNullable(dto.getId()).ifPresent(t -> queryWrapper.eq(Phase::getId, dto.getId()));
    Optional.ofNullable(dto.getType())
        .ifPresent(t -> queryWrapper.eq(Phase::getType, dto.getType()));
    Optional.ofNullable(dto.getPhaseCode())
        .ifPresent(t -> queryWrapper.eq(Phase::getPhaseCode, dto.getPhaseCode()));
    Optional.ofNullable(dto.getPhaseName())
        .ifPresent(t -> queryWrapper.eq(Phase::getPhaseName, dto.getPhaseName()));

    queryWrapper.last("LIMIT 1");

    return this.getOne(queryWrapper);
  }
}
