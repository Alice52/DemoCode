package cn.edu.ntu.javaee.mvc.common.model;

import com.alibaba.fastjson.JSON;

/**
 * @author zack <br>
 * @create 2020-04-05 17:45 <br>
 */
public class JsonResult {

  /** success message data */
  private String message;

  private JSON jsonData;
  private int success;

  public JsonResult() {}

  public JsonResult(String message, JSON jsonData, int success) {
    this.message = message;
    this.jsonData = jsonData;
    this.success = success;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public JSON getJsonData() {
    return jsonData;
  }

  public void setJsonData(JSON jsonData) {
    this.jsonData = jsonData;
  }

  public int getSuccess() {
    return success;
  }

  public void setSuccess(int success) {
    this.success = success;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof JsonResult)) return false;

    JsonResult that = (JsonResult) o;

    if (success != that.success) return false;
    if (message != null ? !message.equals(that.message) : that.message != null) return false;
    return jsonData != null ? jsonData.equals(that.jsonData) : that.jsonData == null;
  }

  @Override
  public int hashCode() {
    int result = message != null ? message.hashCode() : 0;
    result = 31 * result + (jsonData != null ? jsonData.hashCode() : 0);
    result = 31 * result + success;
    return result;
  }

  @Override
  public String toString() {
    return "JsonResponse{"
        + "message='"
        + message
        + '\''
        + ", jsonData="
        + jsonData
        + ", success="
        + success
        + '}';
  }
}
