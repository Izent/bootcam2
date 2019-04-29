package com.raul.bootcam2.dto.request;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ClassesCreateRequest {

  @NotEmpty(message = "classCode-empty")
  @Size(max = 10, message = "name-size")
  private String classCode;
  @NotEmpty(message = "className-empty")
  @Size(max = 20, message = "name-size")
  private String className;

  private Date dateForm;

  private Date dateTo;
  @Valid
  private List<SubjectListRequest> subjectId;
  @Valid
  private List<TeacherListRequest> teacherId;

  @Data
  public static class SubjectListRequest {
    @NotNull(message = "id-subject")
    private Long id;
  }

  @Data
  public static class TeacherListRequest {
    @NotNull(message = "id-teacher")
    private Long id;
  }
}
