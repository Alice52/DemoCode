package boot.mybatis.async.controller;

import boot.mybatis.async.service.PhaseService;
import boot.mybatis.common.model.dto.PhaseDTO;
import boot.mybatis.common.model.vo.PhaseVO;
import boot.mybatis.common.utils.ValidationUtil;
import io.swagger.annotations.Api;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.groups.Default;

/**
 * @author zack <br>
 * @create 2021-04-09 10:10 <br>
 * @project integration <br>
 */
@Slf4j
@Api(tags = {"活动阶段信息"})
@RestController
@RequestMapping("/boot-mybatis-async")
public class PhaseController {
    @Resource private PhaseService phaseService;

    @PostMapping("/phase")
    public void create(
            @RequestBody @Validated({ValidationUtil.Add.class, Default.class}) PhaseDTO phase) {
        phaseService.createPhase(phase);
    }

    @SneakyThrows
    @GetMapping("/phase/{id}")
    public PhaseVO get(@PathVariable("id") Long id) {

        return phaseService.getPhase(id).get();
    }

    @SneakyThrows
    @PostMapping("/phase/transaction")
    public void transaction(
            @RequestBody @Validated({ValidationUtil.Add.class, Default.class}) PhaseDTO phase,
            @RequestParam("hasException") Boolean hasException) {

        phaseService.asyncTask4Transaction(phase, hasException);
    }
}
