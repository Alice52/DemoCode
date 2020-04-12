package cn.edu.ntu.springcloud.stream.service;

/**
 * @author zack <br>
 * @create 2020-04-11 21:36 <br>
 */
public interface IMessageProvider {

  /** send message */
  Object send();
}
