package com.raul.bootcam2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "teacher")
public class Teacher {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long teacherId;

  @Column(length = 1, name = "gender")
  private String gender;
  @Column(length = 20, name = "first_name")
  private String firstName;
  @Column(length = 20, name = "middle_name")
  private String middleName;
  @Column(length = 20, name = "last_name")
  private String lastName;
  @Column(length = 30, name = "other_teacher_details")
  private String otherTeacherDetails;


}
