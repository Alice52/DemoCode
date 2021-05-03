package cn.edu.ntu.boot.elasticsearch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zack <br>
 * @create 2020-10-28 21:45 <br>
 * @project springboot <br>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {

    private static final long serialVersionUID = 8510634155374943623L;

    /** 主键 */
    private Long id;

    /** 名字 */
    private String name;

    /** 国家 */
    private String country;

    /** 年龄 */
    private Integer age;

    /** 生日 */
    private Date birthday;

    /** 介绍 */
    private String remark;
}
