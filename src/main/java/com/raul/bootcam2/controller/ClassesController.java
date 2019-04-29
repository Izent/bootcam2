package com.raul.bootcam2.controller;

import com.raul.bootcam2.client.StudentClient;
import com.raul.bootcam2.client.StudentTimeClient;
import com.raul.bootcam2.dto.request.ClassesCreateRequest;
import com.raul.bootcam2.dto.response.ListClassStudentResponse;
import com.raul.bootcam2.dto.response.ListStudentResponse;
import com.raul.bootcam2.model.Classes;
import com.raul.bootcam2.repository.StudentClassesRepository;
import com.raul.bootcam2.service.ClassesService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/classes")
public class ClassesController {

  @Autowired
  ClassesService classesService;

  @Autowired
  StudentClient studentClient;

  @Autowired
  StudentTimeClient studentTimeClient;

  @Autowired
  StudentClassesRepository studentClassesRepository;

  @GetMapping("/{classesId}")
  public List<ListClassStudentResponse> getListClassById(@PathVariable("classesId") Long id) {

    return classesService.listClassStudent(id);
  }

  @GetMapping("/list-student")
  public List<ListStudentResponse> getListStudent() {

    return studentClient.getList();
  }

  @GetMapping("/list-student-time")
  public List<ListStudentResponse> getListTimeStudent() {

    return studentTimeClient.getListTime();
  }

  /**
   * Este método se encarga de consultar al class service.
   *
   * @return Lista de clases
   * @author Raul Ortiz
   */
  @GetMapping("/")
  public List<Classes> listClasses() {
    return classesService.allClasses();
  }

  /**
   * Este método se encarga de consultar al class service.
   *
   * @param classes es una json de datos con el nombre a de la clase
   * @return ultimo id creado, status ok
   * @author Raul Ortiz
   */
  @PostMapping
  public Long createClasses(@RequestBody ClassesCreateRequest classes) {


    return classesService.createClasses(classes);
  }

  /**
   * Este método se encarga de consultar al class service.
   *
   * @param classes es una json de datos con el nombre a de la clase
   * @param id es el id de la clase a actualizar
   * @return El mensaje usado para el saludo
   * @author Raul Ortiz
   */
  @PutMapping("/{classesId}")
  public String updateClasses(@PathVariable("classesId") Long id,
                              @RequestBody ClassesCreateRequest classes) {

    return classesService.updateClasses(id, classes);

  }

  /**
   * Este método se encarga de consultar al class service.
   *
   * @param id es el id de la clase a actualizar
   * @return El mensaje usado para el saludo
   * @author Raul Ortiz
   */
  @DeleteMapping("/{classesId}")
  public String deleteClasses(@PathVariable("classesId") Long id) {

    return classesService.deleteClasses(id);
  }

}
