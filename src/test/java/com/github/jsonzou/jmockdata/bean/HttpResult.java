package com.github.jsonzou.jmockdata.bean;

/**
 * 通用HTTP响应结果包装类
 * Common HTTP response result wrapper class
 *
 * @param <T> 数据类型
 */
public class HttpResult<T> {

  /**
   * 响应状态码
   */
  private Integer code;

  /**
   * 响应消息
   */
  private String message;

  /**
   * 响应数据
   */
  private T data;

  public HttpResult() {
  }

  public HttpResult(Integer code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "HttpResult{" +
        "code=" + code +
        ", message='" + message + '\'' +
        ", data=" + data +
        '}';
  }
}
