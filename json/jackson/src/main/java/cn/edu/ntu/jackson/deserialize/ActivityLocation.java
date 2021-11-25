package cn.edu.ntu.jackson.deserialize;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author asd <br>
 * @create 2021-11-25 10:40 AM <br>
 * @project json <br>
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityLocation {
    @JsonProperty("Address")
    private Address address;
}
