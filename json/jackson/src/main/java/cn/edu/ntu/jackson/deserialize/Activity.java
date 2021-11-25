package cn.edu.ntu.jackson.deserialize;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

/**
 * @author asd <br>
 * @create 2021-11-25 10:39 AM <br>
 * @project json <br>
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Activity {
    @JsonProperty("ActivityLocation")
    private ArrayList<ActivityLocation> activityLocation;
}
