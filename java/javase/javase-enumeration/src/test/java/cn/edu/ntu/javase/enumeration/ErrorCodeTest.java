package cn.edu.ntu.javase.enumeration;

import cn.edu.ntu.javase.enumeration.constants.ErrorConstants;
import cn.edu.ntu.javase.enumeration.enumeration.EnumErrorCode;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br>
 * @create 2020-01-31 13:01 <br>
 */
public class ErrorCodeTest {
  private static final Logger LOG = LoggerFactory.getLogger(ErrorCodeTest.class);

  @Test
  public void testErrorCode() {
    final String errorCode = "030000";
    String messageByErrorCode = EnumErrorCode.getMessageByErrorCode(errorCode);
    LOG.info("The errorMessage of errorCode: {} is: {}", errorCode, messageByErrorCode);
  }

  /**
   * Enum.valueOf(SPECIFY_ENUM.class, enumName) <br>
   * SPECIFY_ENUM.valueOf(enumName)<br>
   */
  @Test
  public void testValueOf() {
    EnumErrorCode unexpected_exception = Enum.valueOf(EnumErrorCode.class, "UNEXPECTED_EXCEPTION");
    LOG.info(unexpected_exception.toString());

    EnumErrorCode enumErrorCode = EnumErrorCode.valueOf(EnumErrorCode.UNEXPECTED_EXCEPTION.name());
    LOG.info(enumErrorCode.toString());
  }

  @Test
  public void testErrorMessage() {
    String errorCode = EnumErrorCode.getCodeByErrorMessage(ErrorConstants.UNEXPECTED_EXCEPTION);
    LOG.info(
        "The errorCode of errorMessage : {} is: {}",
        ErrorConstants.UNEXPECTED_EXCEPTION,
        errorCode);

    final String errorMessage2 = "UNEXPECTED EXCEPTION2";
    String errorCode2 = EnumErrorCode.getCodeByErrorMessage(errorMessage2);
    LOG.info("The errorCode of errorMessage : {} is: {}", errorMessage2, errorCode2);
  }

  @Test
  public void testGetByName() {
    final String enumName = "UNEXPECTED_EXCEPTION2";
    EnumErrorCode errorCode = EnumErrorCode.getByEnumName(enumName);
    LOG.info("The EnumErrorCode of enumName : {} is: {}", enumName, errorCode);
  }
}
