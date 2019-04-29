package com.raul.bootcam2.service;

import com.raul.bootcam2.dto.request.StudentClassRequest;

import com.raul.bootcam2.model.Classes;
import com.raul.bootcam2.model.Student;
import com.raul.bootcam2.model.StudentClasses;
import com.raul.bootcam2.model.StudentClassesPk;
import com.raul.bootcam2.repository.StudentClassesRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentCLassesService {

  @Autowired
  StudentClassesRepository studentClassesRepository;

  public List<StudentClasses> allStudentClasses() {

    return studentClassesRepository.findAll();
  }

  /**
   * Este método se encarga de consultar al studentclasses service.
   *
   * @param studentClassRequest es una json con los datos necesarios para crear un studentclasses
   * @author Raul Ortiz
   */
  public void createStudentClasses(StudentClassRequest studentClassRequest) {
    StudentClasses studentClasses = new StudentClasses();
    studentClasses.setDateTo(studentClassRequest.getDateTo());
    StudentClassesPk classesPk = new StudentClassesPk();
    for (StudentClassRequest.StudentRequest studentRequest : studentClassRequest.getStudentId()) {

      Student student = new Student();
      student.setStudentId(studentRequest.getId());
      classesPk.setStudentId(student);
      classesPk.setDateFrom(studentClassRequest.getDateFrom());
    }
    for (StudentClassRequest.ClassRequest classRequest : studentClassRequest.getClassId()) {
      Classes classes = new Classes();
      classes.setClassId(classRequest.getId());
      classesPk.setClassId(classes);
    }
    studentClasses.setPrimaryKey(classesPk);

    studentClassesRepository.save(studentClasses);

  }


}
