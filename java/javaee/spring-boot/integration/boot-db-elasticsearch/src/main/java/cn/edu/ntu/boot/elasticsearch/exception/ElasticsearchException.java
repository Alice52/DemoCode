package cn.edu.ntu.boot.elasticsearch.exception;

import cn.edu.ntu.boot.elasticsearch.common.ResultCode;
import lombok.Getter;

/**
 * @author zack <br>
 * @create 2020-10-28 21:44 <br>
 * @project springboot <br>
 */
public class ElasticsearchException extends RuntimeException {

    @Getter private int errcode;

    @Getter private String errmsg;

    public ElasticsearchException(ResultCode resultCode) {
        this(resultCode.getCode(), resultCode.getMsg());
    }

    public ElasticsearchException(String message) {
        super(message);
    }

    public ElasticsearchException(Integer errcode, String errmsg) {
        super(errmsg);
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public ElasticsearchException(String message, Throwable cause) {
        super(message, cause);
    }

    public ElasticsearchException(Throwable cause) {
        super(cause);
    }

    public ElasticsearchException(
            String message,
            Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
