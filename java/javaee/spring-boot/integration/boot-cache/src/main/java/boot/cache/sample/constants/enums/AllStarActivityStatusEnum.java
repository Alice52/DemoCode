package boot.cache.sample.constants.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zack <br>
 * @create 2021-04-09 10:19 <br>
 * @project integration <br>
 */
@Getter
@AllArgsConstructor
public enum AllStarActivityStatusEnum {
  DEFAULT("", ""),
  NOT_STARTED("NOT_STARTED", "未开始"),
  STARTED("STARTED", "已开始"),
  ENDED("ENDED", "已结束");

  private String statusCode;
  private String statusName;

  /**
   * Notice this method may return null.
   *
   * @param statusCode
   * @return
   */
  public static AllStarActivityStatusEnum getEnumByStatusCode(String statusCode) {
    for (AllStarActivityStatusEnum item : AllStarActivityStatusEnum.values()) {
      if (item.statusCode.equals(statusCode)) {
        return item;
      }
    }
    return null;
  }
}
