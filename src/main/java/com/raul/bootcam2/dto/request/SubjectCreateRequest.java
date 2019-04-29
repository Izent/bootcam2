package com.raul.bootcam2.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;


@Data
public class SubjectCreateRequest {

  @NotEmpty(message = "notEmpty-subject")
  @Size(max = 20, message = "size-subject")
  private String subjectName;

}
