package com.raul.bootcam2.dto.request;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class StudentClassRequest {

  @Valid
  private List<StudentRequest> studentId;
  @Valid
  private List<ClassRequest> classId;
  private Date dateFrom;
  private Date dateTo;

  @Data
  public static class StudentRequest {

    @NotNull(message = "id-student")
    private Long id;
  }

  @Data
  public static class ClassRequest {

    @NotNull(message = "id-class")
    private Long id;
  }
}
