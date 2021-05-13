package boot.security.controller;

import boot.security.common.PageResult;
import boot.security.model.vo.OnlineUser;
import boot.security.payload.PageCondition;
import boot.security.service.MonitorService;
import boot.security.util.PageUtil;
import boot.security.util.SecurityUtil;
import cn.edu.ntu.common.api.constants.enums.CommonResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 监控 Controller，在线用户，手动踢出用户等功能
 *
 * @author zack <br>
 * @create 2021-05-13 12:22 <br>
 * @project boot-security-shiro <br>
 */
@Slf4j
@RestController
@RequestMapping("/api/monitor")
public class MonitorController {
    @Autowired private MonitorService monitorService;

    /**
     * 在线用户列表
     *
     * @param pageCondition 分页参数
     */
    @GetMapping("/online/user")
    public PageResult onlineUser(PageCondition pageCondition) {
        PageUtil.checkPageCondition(pageCondition, PageCondition.class);
        PageResult<OnlineUser> pageResult = monitorService.onlineUser(pageCondition);
        return pageResult;
    }

    /**
     * 批量踢出在线用户
     *
     * @param names 用户名列表
     */
    @DeleteMapping("/online/user/kickout")
    public void kickoutOnlineUser(@RequestBody List<String> names) {
        CommonResponseEnum.CUSTOM.assertIsNull(names);
        CommonResponseEnum.CUSTOM.assertIsFalse(names.contains(SecurityUtil.getCurrentUsername()));

        monitorService.kickout(names);
    }
}
