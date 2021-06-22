package boot.swagger3.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zack <br>
 * @create 2021-06-21 16:37 <br>
 * @project boot-security-shiro <br>
 */
@ApiModel(value = "ArticleListReq文章列表请求实体")
@Data
public class ArticleListReq {
    @ApiModelProperty(value = "pageNum")
    private Integer pageNum;

    @ApiModelProperty(value = "pageSize")
    private Integer pageSize;

    @ApiModelProperty(value = "关键字搜索：标题、描述、内容")
    private String keyword;

    @ApiModelProperty(value = "资源类型")
    private Integer type;
}
