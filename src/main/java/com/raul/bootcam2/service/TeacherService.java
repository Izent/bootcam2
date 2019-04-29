package com.raul.bootcam2.service;

import com.raul.bootcam2.dto.request.TeacherCreateRequest;
import com.raul.bootcam2.error.CustomException;
import com.raul.bootcam2.model.Teacher;
import com.raul.bootcam2.repository.TeacherRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

  @Autowired
  TeacherRepository teacherRepository;

  public List<Teacher> allTeacher() {
    return teacherRepository.findAll();
  }

  /**
   * Este método se encarga de teacher request.
   *
   * @param teacherCreateRequest es una json con los datos necesarios para crear un teacher
   * @return ultimo id creado, status ok
   * @author Raul Ortiz
   */
  public Long createTeacher(TeacherCreateRequest teacherCreateRequest) {
    Teacher teacher = new Teacher();
    teacher.setOtherTeacherDetails(teacherCreateRequest.getOtherTeacherDetails());
    teacher.setMiddleName(teacherCreateRequest.getMiddleName());
    teacher.setLastName(teacherCreateRequest.getLastName());
    teacher.setGender(teacherCreateRequest.getGender());
    teacher.setFirstName(teacherCreateRequest.getFirstName());

    teacher = teacherRepository.save(teacher);

    return teacher.getTeacherId();
  }

  /**
   * Este método se encarga de consultar al teacher service.
   *
   * @param teacherCreateRequest es una json con los datos necesarios para actualizar un teacher
   * @param id                   id de teacher a actualizar
   * @return mensaje update successful, status ok
   * @author Raul Ortiz
   */
  public String updateTeacher(Long id, TeacherCreateRequest teacherCreateRequest) {
    Optional<Teacher> teacherOptional = teacherRepository.findById(id);
    if (teacherOptional.isPresent()) {
      Teacher teacherBase = teacherOptional.get();

      teacherBase.setFirstName(teacherCreateRequest.getFirstName());
      teacherBase.setGender(teacherCreateRequest.getGender());
      teacherBase.setLastName(teacherCreateRequest.getLastName());
      teacherBase.setMiddleName(teacherCreateRequest.getMiddleName());
      teacherBase.setOtherTeacherDetails(teacherCreateRequest.getOtherTeacherDetails());

      teacherRepository.save(teacherBase);

      return "Update successful";

    } else {
      throw new CustomException("400", "no existe id " + id);
    }
  }

  /**
   * Este método se encarga de consultar al teacher service.
   *
   * @param id id de teacher a eliminar
   * @return mensaje delete successful, status ok
   * @author Raul Ortiz
   */
  public String deleteTeacher(Long id) {
    Optional<Teacher> teacherOptional = teacherRepository.findById(id);
    if (teacherOptional.isPresent()) {


      teacherRepository.deleteById(id);
      return "Delete successful";
    } else {
      throw new CustomException("400", "no existe id " + id);
    }
  }
}
