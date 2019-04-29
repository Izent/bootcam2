package com.raul.bootcam2.dto.response;

import java.util.Date;

import lombok.Data;


@Data
public class ListStudentResponse {

  private Long id;
  private String gender;
  private String firstName;
  private String middleName;
  private String lastName;
  private Date dateOfBirth;
  private String otherStudentDetails;


}
