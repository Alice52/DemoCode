package cn.edu.ntu.javaee.annotation.dao;

import org.springframework.stereotype.Repository;

/**
 * HelloDao will be put to IOC container, even no @Repository annotation<br>
 * due to {@link cn.edu.ntu.javaee.annotation.scan.filer.CustomTypeFilter} class
 *
 * @author zack <br>
 * @create 2020-04-29 18:20 <br>
 */
@Repository
public class HelloDao {}
