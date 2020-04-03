package com.augmentum.springboot.integration.enumeration;

/**
 * @author zack
 * @create 2019-12-22 22:04
 * @function
 */
public enum HttpErrorCode {
  OK(200, "OK"),
  NOT_Authorization(401, "NOT AUTHORIZATION"),
  NOT_FIND(404, "NOT FOUND"),
  UN_KNOWED(9999, "UNKNOWCODE");

  private int errorCode;
  private String message;

  public int getErrorCode() {
    return errorCode;
  }

  public String getMessage() {
    return message;
  }

  HttpErrorCode(int errorCode, String message) {
    this.errorCode = errorCode;
    this.message = message;
  }

  public static HttpErrorCode getByCode(int errorCode) {
    for (HttpErrorCode httpErrorCode : HttpErrorCode.values()) {
      if (httpErrorCode.getErrorCode() == errorCode) {
        return httpErrorCode;
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return "HttpErrorCode{" + "errorCode=" + errorCode + ", message='" + message + '\'' + '}';
  }
}
