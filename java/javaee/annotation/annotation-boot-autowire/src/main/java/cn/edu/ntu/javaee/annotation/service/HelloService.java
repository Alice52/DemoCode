package cn.edu.ntu.javaee.annotation.service;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Service;

/**
 * @author zack <br>
 * @create 2020-04-30 17:02 <br>
 */
@Service
@Data
@ToString
public class HelloService {

    private String label = "1";
}
