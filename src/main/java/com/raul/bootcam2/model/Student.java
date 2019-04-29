package com.raul.bootcam2.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long studentId;
  @Column(length = 1, name = "gender")
  private String gender;
  @Column(length = 20, name = "first_name", nullable = false)
  private String firstName;
  @Column(length = 20, name = "middle_name")
  private String middleName;
  @Column(length = 20, name = "last_name")
  private String lastName;
  @Column(name = "date_of_birth")
  private Date dateOfBirth;
  @Column(length = 50, name = "other_student_details")
  private String otherStudentDetails;


}
