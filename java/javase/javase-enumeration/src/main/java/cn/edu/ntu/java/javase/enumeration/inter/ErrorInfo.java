package cn.edu.ntu.java.javase.enumeration.inter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack<br>
 * @create 2020-01-31 12:02<br>
 */
public interface ErrorInfo {
    static final Logger LOG = LoggerFactory.getLogger(ErrorInfo.class);

    /**
     * This should be implements by subClass.<br>
     * Else will throw exception: UnsupportedOperationException
     *
     * @return error message
     * @throws UnsupportedOperationException: no implements exception.
     */
    default String getErrorInfo() {
        LOG.warn("un implement exception: UnsupportedOperationException");
        throw new UnsupportedOperationException();
    }
}
