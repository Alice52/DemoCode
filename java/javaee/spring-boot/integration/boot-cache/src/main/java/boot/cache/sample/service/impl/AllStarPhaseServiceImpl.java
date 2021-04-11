package boot.cache.sample.service.impl;

import boot.cache.sample.constants.enums.AllStarActivityPhaseEnum;
import boot.cache.sample.mapper.AllStarPhaseMapper;
import boot.cache.sample.model.dto.AllStarPhaseDTO;
import boot.cache.sample.model.entity.AllStarPhase;
import boot.cache.sample.model.vo.AllStarActivityVO;
import boot.cache.sample.model.vo.AllStarPhaseVO;
import boot.cache.sample.service.AllStarActivityService;
import boot.cache.sample.service.AllStarPhaseService;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zack <br>
 * @create 2021-04-09 10:22 <br>
 * @project integration <br>
 */
@Service
public class AllStarPhaseServiceImpl extends ServiceImpl<AllStarPhaseMapper, AllStarPhase>
    implements AllStarPhaseService {

  @Resource private AllStarActivityService activityService;

  private static LambdaQueryWrapper<AllStarPhase> buildQueryWrapper() {
    return buildQueryWrapper(null);
  }

  private static LambdaQueryWrapper<AllStarPhase> buildQueryWrapper(String type) {
    LambdaQueryWrapper<AllStarPhase> queryWrapper =
        Wrappers.<AllStarPhase>query().lambda().eq(AllStarPhase::getIsDeleted, 0);
    Optional.ofNullable(type).ifPresent(t -> queryWrapper.eq(AllStarPhase::getType, type));

    return queryWrapper;
  }

  @Override
  public AllStarPhaseVO currentStage(String type) {
    LocalDateTime now = LocalDateTime.now();

    LambdaQueryWrapper<AllStarPhase> queryWrapper = buildQueryWrapper(type);
    List<AllStarPhase> phaseList = this.list(queryWrapper);
    if (CollUtil.isEmpty(phaseList)) {
      throw new RuntimeException("未获取到阶段信息");
    }

    phaseList =
        phaseList.stream()
            .map(
                x -> {
                  x.setStartTime(Optional.ofNullable(x.getStartTime()).orElse(LocalDateTime.MIN));
                  return x;
                })
            .sorted(Comparator.comparing(AllStarPhase::getStartTime))
            .collect(Collectors.toList());

    LocalDateTime startTime, endTime;
    for (int i = 0; i < phaseList.size(); i++) {
      AllStarPhase phase = phaseList.get(i);
      startTime = Optional.ofNullable(phase.getStartTime()).orElse(LocalDateTime.MIN);
      endTime = Optional.ofNullable(phase.getEndTime()).orElse(LocalDateTime.MAX);

      if (i == 0 && now.isBefore(startTime)) {
        return new AllStarPhaseVO("NOT_STARTED", "未开始");
      }

      if (i == phaseList.size() - 1 && now.isAfter(endTime)) {
        return new AllStarPhaseVO("ENDED", "已结束");
      }

      if (now.isBefore(endTime) && (now.isAfter(startTime) || now.isEqual(startTime))) {
        return new AllStarPhaseVO(phase.getPhaseCode(), phase.getPhaseName());
      }
    }

    return new AllStarPhaseVO("UNKNOWN", "未知");
  }

  @Override
  public AllStarPhaseVO getPhase(Long id, String type) {

    AllStarPhase phase = getByCondition(new AllStarPhaseDTO(id, type));
    AllStarPhaseVO phaseVO = new AllStarPhaseVO();
    BeanUtil.copyProperties(phase, phaseVO, "status");

    return phaseVO;
  }

  @Override
  public Boolean updatePhase(AllStarPhaseDTO dto) {
    validatePeriod(dto);
    validateDuplicateByCodeOrName(dto);

    AllStarPhase phase = new AllStarPhase();
    BeanUtil.copyProperties(dto, phase, "status");

    return retBool(baseMapper.updateById(phase));
  }

  @Override
  public Boolean deletePhase(Long id) {

    ensureNoUse(id);
    AllStarPhase phase = validateThenGet(id);
    phase.setIsDeleted(true);

    return retBool(baseMapper.updateById(phase));
  }

  @Override
  public Boolean createPhase(AllStarPhaseDTO dto) {

    validatePeriod(dto);
    validateDuplicateByCodeOrName(dto);

    AllStarPhase phase = new AllStarPhase();
    BeanUtil.copyProperties(dto, phase, "status");

    return retBool(baseMapper.insert(phase));
  }

  @Override
  public List<AllStarPhaseVO> listPhases(String type) {

    return getPhases(type);
  }

  @Override
  public List<AllStarPhaseVO> listWithActivities(String type) {

    List<AllStarPhaseVO> phaseVOS = getPhases(type);

    List<Long> phaseIds = phaseVOS.stream().map(AllStarPhaseVO::getId).collect(Collectors.toList());
    if (CollUtil.isEmpty(phaseIds)) {
      return phaseVOS;
    }

    Map<Long, List<AllStarActivityVO>> collect =
        activityService.queryByPhaseIds(phaseIds).stream()
            .map(AllStarActivityVO::new)
            .collect(Collectors.groupingBy(AllStarActivityVO::getPhaseId));

    phaseVOS.forEach(
        x ->
            x.setAllStarActivityVO(
                collect.getOrDefault(x.getId(), new ArrayList<AllStarActivityVO>())));

    return phaseVOS;
  }

  private void ensureNoUse(Long id) {

    if (activityService.queryByPhaseIds(Arrays.asList(id)).size() > 0) {
      throw new RuntimeException("不能删除已使用的阶段");
    }
  }

  private List<AllStarPhaseVO> getPhases(String type) {
    LambdaQueryWrapper<AllStarPhase> queryWrapper = buildQueryWrapper(type);
    List<AllStarPhase> phases = this.list(queryWrapper);

    return phases.stream().map(AllStarPhaseVO::new).collect(Collectors.toList());
  }

  private void validatePeriod(AllStarPhaseDTO dto) {

    if (ObjectUtil.isNull(dto.getStartTime()) && ObjectUtil.isNull(dto.getEndTime())) {
      throw new RuntimeException("开始时间和结束时间不能都为空");
    }

    LocalDateTime endTime = Optional.ofNullable(dto.getEndTime()).orElse(LocalDateTime.MAX);
    LocalDateTime startTime = Optional.ofNullable(dto.getStartTime()).orElse(LocalDateTime.MIN);
    if (endTime.isBefore(startTime) || endTime.isEqual(startTime)) {
      throw new RuntimeException("结束时间不大于开始时间");
    }

    LambdaQueryWrapper<AllStarPhase> queryWrapper = buildQueryWrapper();
    if (Optional.ofNullable(dto.getEndTime()).isPresent()) {
      queryWrapper.and(
          obj ->
              obj.lt(AllStarPhase::getStartTime, dto.getEndTime())
                  .or()
                  .isNull(AllStarPhase::getStartTime));
    }
    if (Optional.ofNullable(dto.getStartTime()).isPresent()) {
      queryWrapper.and(
          obj ->
              obj.gt(AllStarPhase::getEndTime, dto.getStartTime())
                  .or()
                  .isNull(AllStarPhase::getEndTime));
    }

    if (ObjectUtil.isNotNull(dto.getId())) {
      queryWrapper.ne(AllStarPhase::getId, dto.getId());
    }

    List<AllStarPhase> phases = this.list(queryWrapper);

    if (!CollUtil.isEmpty(phases)) {
      String names =
          phases.stream()
              .map(AllStarPhase::getPhaseName)
              .collect(Collectors.joining(StrUtil.COMMA));
      throw new RuntimeException(StrUtil.format("该阶段的时间与以下阶段存在冲突: {}", names));
    }
  }

  private void validateDuplicateByCodeOrName(AllStarPhaseDTO dto) {

    ensureValidPhaseCode(dto.getPhaseCode());

    LambdaQueryWrapper<AllStarPhase> queryWrapper = buildQueryWrapper();
    queryWrapper.and(
        obj ->
            obj.eq(AllStarPhase::getPhaseCode, dto.getPhaseCode())
                .or()
                .eq(AllStarPhase::getPhaseName, dto.getPhaseName()));

    if (ObjectUtil.isNotNull(dto.getId())) {
      queryWrapper.ne(AllStarPhase::getId, dto.getId());
    }

    List<AllStarPhase> phases = this.list(queryWrapper);

    if (!CollUtil.isEmpty(phases)) {
      throw new RuntimeException("阶段Code或者阶段名称重复");
    }
  }

  private void ensureValidPhaseCode(String phaseCode) {
    if (StrUtil.isNotEmpty(phaseCode)
        && Boolean.FALSE.equals(AllStarActivityPhaseEnum.contains(phaseCode))) {
      throw new RuntimeException("不是有效的阶段 Code");
    }
  }

  private AllStarPhase validateThenGet(Long id) {
    return validateThenGet(id, null);
  }

  /**
   * 根据条件判断记录是否存在, 不存在则抛出 {@link RuntimeException}, 存在则获取该对象
   *
   * @param id
   * @param type
   * @return
   */
  private AllStarPhase validateThenGet(Long id, String type) {

    AllStarPhase phase = getByCondition(new AllStarPhaseDTO(id, type));
    Optional.ofNullable(phase)
        .orElseThrow(() -> new RuntimeException(StrUtil.format("Id 为 {} 的记录不存在", id)));

    return phase;
  }

  private AllStarPhase getByCondition(AllStarPhaseDTO dto) {
    LambdaQueryWrapper<AllStarPhase> queryWrapper = buildQueryWrapper();

    Optional.ofNullable(dto.getId())
        .ifPresent(t -> queryWrapper.eq(AllStarPhase::getId, dto.getId()));
    Optional.ofNullable(dto.getType())
        .ifPresent(t -> queryWrapper.eq(AllStarPhase::getType, dto.getType()));
    Optional.ofNullable(dto.getPhaseCode())
        .ifPresent(t -> queryWrapper.eq(AllStarPhase::getPhaseCode, dto.getPhaseCode()));
    Optional.ofNullable(dto.getPhaseName())
        .ifPresent(t -> queryWrapper.eq(AllStarPhase::getPhaseName, dto.getPhaseName()));

    queryWrapper.last("LIMIT 1");

    return this.getOne(queryWrapper);
  }
}
