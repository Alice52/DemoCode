package boot.mybatis.plus.controller;

import boot.mybatis.common.model.entity.Activity;
import boot.mybatis.common.model.vo.ActivityVO;
import boot.mybatis.plus.service.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author zack <br>
 * @create 2021-04-09 10:10 <br>
 * @project integration <br>
 */
@Slf4j
@Api(tags = {"活动信息"})
@RestController
@RequestMapping("/hubby")
public class ActivityController4UsageSample {
    @Resource private ActivityService activityService;

    @GetMapping("/activitys")
    public List<ActivityVO> list(@RequestParam(value = "id") List<Long> ids) {

        return activityService.queryByPhaseIds(ids);
    }

    @ApiModelProperty("SelectMaps Usage Sample")
    @GetMapping("/activity/maps")
    public List<Map<String, Object>> selectMaps() {

        return activityService.selectMaps();
    }

    @ApiModelProperty("SelectMaps Usage Sample-V2")
    @GetMapping("/activity/maps/v2")
    public List<Map<String, Object>> summarySelectMaps() {

        return activityService.summarySelectMaps();
    }

    @ApiModelProperty("selectObjs Usage Sample")
    @GetMapping("/activity/objs")
    public List<Object> selectObjs() {

        return activityService.selectObjs();
    }

    @ApiModelProperty("Wrapper Entity Usage Sample")
    @GetMapping("/activity/wrapper/entity")
    public List<Activity> wrapperEntity() {

        return activityService.wrapperEntity();
    }
}
