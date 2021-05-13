package boot.security.common;

/**
 * @author zack <br>
 * @create 2021-05-13<br>
 * @project integration <br>
 */
public interface IStatus {

    /**
     * 状态码
     *
     * @return 状态码
     */
    Integer getCode();

    /**
     * 返回信息
     *
     * @return 返回信息
     */
    String getMessage();
}
