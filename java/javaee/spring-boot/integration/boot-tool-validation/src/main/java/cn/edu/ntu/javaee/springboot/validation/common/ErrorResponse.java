package cn.edu.ntu.javaee.springboot.validation.common;

import java.util.Map;

/**
 * @author zack <br>
 * @create 2020-08-01 19:28 <br>
 * @project validation <br>
 */
public class ErrorResponse {
  private Integer errorCode;
  private String errorMsg;
  private Map<String, Object> parameters;

  public static ErrorResponse error(ErrorMessageEnum errorMessageEnum) {
    return new ErrorResponse(errorMessageEnum);
  }

  private ErrorResponse(ErrorMessageEnum errorMessageEnum) {
    this.errorMsg = errorMessageEnum.getErrorMsg();
    this.errorCode = errorMessageEnum.getErrorCode();
  }

  public Integer getErrorCode() {
    return errorCode;
  }

  public String getErrorMsg() {
    return errorMsg;
  }

  public Map<String, Object> getParameters() {
    return parameters;
  }

  public void setParameters(Map<String, Object> parameters) {
    this.parameters = parameters;
  }
}
