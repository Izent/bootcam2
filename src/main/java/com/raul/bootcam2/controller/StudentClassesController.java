package com.raul.bootcam2.controller;

import com.raul.bootcam2.dto.request.StudentClassRequest;
import com.raul.bootcam2.model.StudentClasses;
import com.raul.bootcam2.service.StudentCLassesService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/StudentClasses")
public class StudentClassesController {

  @Autowired
  StudentCLassesService studentCLassesService;

  /**
   * Este método se encarga de consultar al studenclass service.
   *
   * @return Lista de studentClass
   * @author Raul Ortiz
   */
  @GetMapping("/")
  public List<StudentClasses> listClasses() {
    return studentCLassesService.allStudentClasses();
  }

  /**
   * Este método se encarga de consultar al studenclass service.
   *
   * @param classes datos para crear classes
   * @author Raul Ortiz
   */
  @PostMapping
  public void createClasses(@RequestBody StudentClassRequest classes) {
    studentCLassesService.createStudentClasses(classes);

  }
}
