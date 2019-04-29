package com.raul.bootcam2.error;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class CustomControllerAdvice {

  @ExceptionHandler(CustomException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  @ResponseBody
  public String handleMyException(CustomException ex) {

    return "Error: " + ex.getErrCode() + " Message: " + ex.getErrMsg();
  }

  @ExceptionHandler(ValidateException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public List<String> handleMyException2(ValidateException ex) {

    return ex.getErrMsg();
  }

}
