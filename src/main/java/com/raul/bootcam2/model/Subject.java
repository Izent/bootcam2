package com.raul.bootcam2.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "subject")
@ApiModel(description = "All details about the Subject. ")
public class Subject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ApiModelProperty(notes = "The database generated Subject ID")
  private Long subjectId;

  @Column(length = 20, name = "subject_name")
  @ApiModelProperty(notes = "The Subject  name")
  private String subjectName;

}
