package cn.edu.ntu.javaee.springboot.mapstruct.utils;

import org.springframework.stereotype.Component;

/**
 * @author zack <br>
 * @create 2020-11-08 23:46 <br>
 * @project springboot <br>
 */
@Component
public class BooleanStrFormat {
    public String toStr(Boolean isDisable) {
        if (isDisable) {
            return "Y";
        } else {
            return "N";
        }
    }

    public Boolean toBoolean(String str) {
        if (str.equals("Y")) {
            return true;
        } else {
            return false;
        }
    }
}
