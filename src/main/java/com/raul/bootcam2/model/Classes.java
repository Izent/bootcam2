package com.raul.bootcam2.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "classes")
public class Classes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long classId;

  @ManyToOne()
  @JoinColumn(name = "subject_id")
  private Subject subjectId;
  @ManyToOne()
  @JoinColumn(name = "teacher_id")
  private Teacher teacherId;
  @Column(length = 8, name = "class_code")
  private String classCode;
  @Column(length = 8, name = "class_name")
  private String className;
  @Column(name = "date_form")
  private Date dateForm;
  @Column(name = "date_to")
  private Date dateTo;

}
