package boot.mybatis.plus.controller;

import boot.mybatis.common.model.dto.PhaseDTO;
import boot.mybatis.common.model.vo.PhaseVO;
import boot.mybatis.common.utils.ValidationUtil;
import boot.mybatis.plus.service.PhaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
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
public class PhaseController {
  @Resource private PhaseService phaseService;

  @GetMapping("/list")
  public List<PhaseVO> list(
      @RequestParam(value = "type", required = false) @ApiParam(value = "活动标识") String type) {

    return phaseService.listPhases(type);
  }

  @GetMapping("/{id}")
  public PhaseVO get(
      @PathVariable("id") Long id,
      @RequestParam(value = "type", required = false) @ApiParam(value = "活动标识") String type) {

    return phaseService.getPhase(id, type);
  }

  @PutMapping("/{id}")
  public Boolean update(@PathVariable("id") Long id, @RequestBody PhaseDTO phase) {
    phase.setId(id);
    return phaseService.updatePhase(phase);
  }

  @DeleteMapping("/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return phaseService.deletePhase(id);
  }

  @PostMapping
  public Boolean create(
      @RequestBody @Validated({ValidationUtil.Add.class, Default.class}) PhaseDTO phase) {
    return phaseService.createPhase(phase);
  }
}
