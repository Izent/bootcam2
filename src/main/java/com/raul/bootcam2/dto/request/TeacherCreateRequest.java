package com.raul.bootcam2.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;


@Data
public class TeacherCreateRequest {

  @NotEmpty(message = "gender-empty")
  @Size(max = 1, message = "gender-size")
  private String gender;
  @NotEmpty(message = "firstName-empty")
  @Size(message = "firstName-size")
  private String firstName;
  @NotEmpty(message = "middleName-empty")
  @Size(max = 20, message = "middleName-size")
  private String middleName;
  @NotEmpty(message = "lastName-empty")
  @Size(max = 20, message = "lastName-size")
  private String lastName;

  @Size(max = 30, message = "details-size")
  private String otherTeacherDetails;

}
