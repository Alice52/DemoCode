package cn.edu.ntu.java.javase.enumeration.constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is error message constants. <br>
 *
 * @author zack<br>
 * @create 2020-01-31 12:39<br>
 */
public final class ErrorConstants {
    public static final String UNEXPECTED_EXCEPTION = "UNEXPECTED EXCEPTION";
    public static final String UNKNOWN_EXCEPTION = "UNKNOWN EXCEPTION";
    public static final String DB_EXCEPTION = "DATABASE EXCEPTION";
    public static final String BIZ_EXCEPTION = "BUSINESS EXCEPTION";
    public static final String REPEAT_SUBMIT_EXCEPTION = "REPEAT SUBMIT EXCEPTION";
    public static final String PARAMETER_EXCEPTION = "PARAMETER EXCEPTION";
    private static final Logger LOG = LoggerFactory.getLogger(ErrorConstants.class);
}
