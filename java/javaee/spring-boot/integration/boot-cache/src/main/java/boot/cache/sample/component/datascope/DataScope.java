package boot.cache.sample.component.datascope;

/**
 * 数据权限查询参数
 *
 * @author zack <br>
 * @create 2021-04-09 12:31 <br>
 * @project integration <br>
 */
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class DataScope extends HashMap {
  /** 限制范围的字段名称 */
  private String scopeName = "deptId";

  /** 具体的数据范围 */
  private List<Integer> deptIds;

  /** 是否只查询本部门 */
  private Boolean isOnly = false;
}
