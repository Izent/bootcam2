package com.raul.bootcam2.error;

import java.util.List;

import lombok.Getter;

@Getter
public class ValidateException extends RuntimeException {

  private List<String> errMsg;

  public ValidateException(List<String> errMsg) {
    this.errMsg = errMsg;
  }
}
