package cn.edu.ntu.springboot.mvc.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author asd <br>
 * @create 2022-01-10 10:43 AM <br>
 * @project boot-mybatis-rwa <br>
 */
@Slf4j
@Data
public class UserDTO {

    /**
     * 1. Lombok: getUName() / setUName() -- uname is validated <br>
     * 2. Idea: getuName() / setuName() -- uName is validated <br>
     *
     * <p>Controller @RequestBody 解析填充 UserDTO 过程
     *
     * <pre>
     *     1. https://github.com/Alice52/java-ocean/issues/239
     * </pre>
     */
    private String uName;

    //    public String getuName() {
    //        return uName;
    //    }
    //
    //    public void setuName(String uName) {
    //        this.uName = uName;
    //    }

    // isActive() / setActive()
    private boolean active;
    // isActive2() / setActive2()
    private boolean isActive2;

    // getClosed() / setClosed()
    private Boolean closed;

    // getIsDeleted() / setIsDeleted()
    private Boolean isDeleted;
}
