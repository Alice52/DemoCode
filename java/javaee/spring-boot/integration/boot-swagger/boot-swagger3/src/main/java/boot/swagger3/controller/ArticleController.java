package boot.swagger3.controller;

import boot.swagger3.model.ArticleListReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zack <br>
 * @create 2021-06-21 16:37 <br>
 * @project boot-security-shiro <br>
 */
@Api(tags = {"1. 文章"})
@RestController
@RequestMapping("/article")
public class ArticleController {
    @ApiOperation(value = "文章列表")
    @GetMapping("/article")
    public Map<String, Object> articleList(@ModelAttribute ArticleListReq articleListReq) {
        return null;
    }
}
