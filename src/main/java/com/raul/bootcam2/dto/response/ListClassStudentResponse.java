package com.raul.bootcam2.dto.response;

import java.sql.Date;
import java.util.List;

import lombok.Data;


@Data
public class ListClassStudentResponse {

  private String className;
  private String classCode;
  private Date dateForm;
  private Date dateTo;
  private List<ListStudentResponse> students;

  @Data
  public static class ListStudentResponse {
    private Long id;
    private String firstName;
    private String middleName;
    private String gender;
    private String lastName;
    private String otherStudentDetails;

  }

}
