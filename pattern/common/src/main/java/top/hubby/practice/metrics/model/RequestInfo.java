package top.hubby.practice.metrics.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author asd <br>
 * @create 2021-12-24 4:59 PM <br>
 * @project pattern <br>
 */
@Slf4j
@Data
public class RequestInfo {
    private String apiName;
    private double responseTime;
    private long timestamp;
}
