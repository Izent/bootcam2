package com.raul.bootcam2.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Embeddable
public class StudentClassesPk implements Serializable {

  @ManyToOne
  @JoinColumn(name = "student_id")
  private Student studentId;

  @ManyToOne
  @JoinColumn(name = "class_id")
  private Classes classId;

  @JoinColumn(name = "date_from")
  private Date dateFrom;
}
