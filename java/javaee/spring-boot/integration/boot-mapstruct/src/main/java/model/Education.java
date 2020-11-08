package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br/>
 * @create 2020-11-08 23:26 <br/>
 * @project springboot <br/>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Education {
    private String degreeName;
    private String institute;
    private Integer yearOfPassing;
}
