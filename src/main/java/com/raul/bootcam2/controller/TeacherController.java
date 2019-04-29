package com.raul.bootcam2.controller;

import com.raul.bootcam2.dto.request.TeacherCreateRequest;
import com.raul.bootcam2.model.Teacher;
import com.raul.bootcam2.service.TeacherService;

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
@RequestMapping("/api/teacher")
public class TeacherController {

  @Autowired
  TeacherService teacherService;

  /**
   * Este método se encarga de consultar al teacher service.
   *
   * @return lista de teacher
   * @author Raul Ortiz
   */
  @GetMapping("/")
  public List<Teacher> listTeacher() {
    return teacherService.allTeacher();
  }

  /**
   * Este método se encarga de consultar al teacher service.
   *
   * @param teacher es una json con los datos necesarios para crear un teacher
   * @return ultimo id creado, status ok
   * @author Raul Ortiz
   */
  @PostMapping
  public Long createTeacher(@RequestBody TeacherCreateRequest teacher) {

    return teacherService.createTeacher(teacher);
  }

  /**
   * Este método se encarga de consultar al teacher service.
   *
   * @param teacher es una json con los datos necesarios para actualizar un teacher
   * @param id      id de teacher a actualizar
   * @return mensaje update successful, status ok
   * @author Raul Ortiz
   */
  @PutMapping("/{teacherId}")
  public String updateTeacher(@PathVariable("teacherId") Long id,
                              @RequestBody TeacherCreateRequest teacher) {

    return teacherService.updateTeacher(id, teacher);

  }

  /**
   * Este método se encarga de consultar al teacher service.
   *
   * @param id id de teacher a eliminar
   * @return mensaje delete successful, status ok
   * @author Raul Ortiz
   */
  @DeleteMapping("/{teacherId}")
  public String deleteTeacher(@PathVariable("teacherId") Long id) {

    return teacherService.deleteTeacher(id);
  }

}
