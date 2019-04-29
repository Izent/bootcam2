package com.raul.bootcam2.model;

import java.sql.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "student_classes")
public class StudentClasses {

  @EmbeddedId
  private StudentClassesPk primaryKey;

  @JoinColumn(name = "date_to")
  private Date dateTo;

}
