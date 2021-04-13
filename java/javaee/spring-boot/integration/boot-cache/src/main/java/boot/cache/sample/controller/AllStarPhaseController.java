package boot.cache.sample.controller;

import boot.cache.sample.constants.GlobalCacheConstants;
import boot.cache.sample.model.dto.AllStarPhaseDTO;
import boot.cache.sample.model.vo.AllStarPhaseVO;
import boot.cache.sample.service.AllStarPhaseService;
import boot.cache.sample.util.Add;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.groups.Default;
import java.util.List;

/**
 * @author zack <br>
 * @create 2021-04-09 10:10 <br>
 * @project integration <br>
 */
@Slf4j
@Api(tags = {"活动阶段信息"})
@RestController
@RequestMapping("/mcdonalds/phase")
public class AllStarPhaseController {
  @Resource AllStarPhaseService allStarPhaseService;

  @GetMapping("/details")
  public List<AllStarPhaseVO> listWithActivities(
      @RequestParam(value = "type", required = false) @ApiParam(value = "活动标识") String type) {
    return allStarPhaseService.listWithActivities(type);
  }

  @GetMapping
  public AllStarPhaseVO currentPhase(
      @RequestParam(value = "type", required = false) @ApiParam(value = "活动标识") String type) {
    return allStarPhaseService.currentStage(type);
  }

  @GetMapping("/list")
  @Cacheable(
      value = GlobalCacheConstants.MODULE_MCDONALDS_ALLSTART_PHASE_KEY,
      key = "'list'",
      unless = "#result.size() == 0")
  public List<AllStarPhaseVO> list(
      @RequestParam(value = "type", required = false) @ApiParam(value = "活动标识") String type) {

    return allStarPhaseService.listPhases(type);
  }

  @GetMapping("/{id}")
  @Cacheable(
      value = GlobalCacheConstants.MODULE_MCDONALDS_ALLSTART_PHASE_KEY,
      key = "#id",
      unless = "#result.id == null")
  public AllStarPhaseVO get(
      @PathVariable("id") Long id,
      @RequestParam(value = "type", required = false) @ApiParam(value = "活动标识") String type) {

    return allStarPhaseService.getPhase(id, type);
  }

  @PutMapping("/{id}")
  @Caching(
      evict = {
        @CacheEvict(value = GlobalCacheConstants.MODULE_MCDONALDS_ALLSTART_PHASE_KEY, key = "#id"),
        @CacheEvict(
            value = GlobalCacheConstants.MODULE_MCDONALDS_ALLSTART_PHASE_KEY,
            key = "'list'")
      })
  public Boolean update(@PathVariable("id") Long id, @RequestBody AllStarPhaseDTO phase) {
    phase.setId(id);
    return allStarPhaseService.updatePhase(phase);
  }

  @DeleteMapping("/{id}")
  @Caching(
      evict = {
        @CacheEvict(value = GlobalCacheConstants.MODULE_MCDONALDS_ALLSTART_PHASE_KEY, key = "#id"),
        @CacheEvict(
            value = GlobalCacheConstants.MODULE_MCDONALDS_ALLSTART_PHASE_KEY,
            key = "'list'")
      })
  public Boolean delete(@PathVariable("id") Long id) {
    return allStarPhaseService.deletePhase(id);
  }

  @PostMapping
  @CacheEvict(value = GlobalCacheConstants.MODULE_MCDONALDS_ALLSTART_PHASE_KEY, key = "'list'")
  public Boolean create(@RequestBody @Validated({Add.class, Default.class}) AllStarPhaseDTO phase) {
    return allStarPhaseService.createPhase(phase);
  }
}
