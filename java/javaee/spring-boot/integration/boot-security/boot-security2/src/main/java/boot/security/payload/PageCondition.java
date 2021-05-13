package boot.security.payload;

import lombok.Data;

/**
 * @author zack <br>
 * @create 2021-05-13 12:41 <br>
 * @project boot-security-shiro <br>
 */
@Data
public class PageCondition {
    /** 当前页码 */
    private Integer currentPage;

    /** 每页条数 */
    private Integer pageSize;
}
