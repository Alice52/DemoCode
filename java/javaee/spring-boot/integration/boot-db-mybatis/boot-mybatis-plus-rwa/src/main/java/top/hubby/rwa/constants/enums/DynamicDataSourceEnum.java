package top.hubby.rwa.constants.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author asd <br>
 * @create 2021-09-28 4:41 PM <br>
 * @project boot-security-shiro <br>
 */
@Slf4j
@Getter
@AllArgsConstructor
public enum DynamicDataSourceEnum {
    MASTER("master"),
    SLAVE("slave"),
    ;
    private final String dataSourceName;
}
