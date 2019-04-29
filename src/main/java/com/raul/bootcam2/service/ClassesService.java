package com.raul.bootcam2.service;

import com.raul.bootcam2.client.StudentClient;
import com.raul.bootcam2.dto.request.ClassesCreateRequest;
import com.raul.bootcam2.dto.response.ListClassStudentResponse;
import com.raul.bootcam2.dto.response.ListStudentResponse;
import com.raul.bootcam2.error.CustomException;
import com.raul.bootcam2.model.Classes;
import com.raul.bootcam2.model.StudentClasses;
import com.raul.bootcam2.model.Subject;
import com.raul.bootcam2.model.Teacher;
import com.raul.bootcam2.repository.ClassesRepository;
import com.raul.bootcam2.repository.StudentClassesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClassesService {

  @Autowired
  ClassesRepository classesRepository;

  @Autowired
  StudentClassesRepository studentClassesRepository;

  @Autowired
  StudentClient studentClient;

  /**
   * Este método se encarga de realizar los get and set y devolverte la lista.
   *
   * @return lista de classes
   * @author Raul Ortiz
   */
  public List<Classes> allClasses() {
    return classesRepository.findAll();
  }

  /**
   * Este método se encarga de realizar los get and set y devolverte la lista.
   *
   * @return lista de classes
   * @author Raul Ortiz
   */
  public List<ListClassStudentResponse> listClassStudent(Long id) {
    List<ListStudentResponse> listStudentResponses = studentClient.getList();
    List<StudentClasses> studentClasses = studentClassesRepository
            .findByPrimaryKeyClassIdClassId(id);
    List<ListClassStudentResponse> listClassStudentResponses = null;

    List<ListClassStudentResponse.ListStudentResponse> listStudents = new ArrayList<>();

    for (StudentClasses classes : studentClasses) {

      listClassStudentResponses = new ArrayList<>();
      ListClassStudentResponse classStudentResponseBase = new ListClassStudentResponse();

      classStudentResponseBase.setClassCode(classes.getPrimaryKey().getClassId().getClassCode());
      classStudentResponseBase.setClassName(classes.getPrimaryKey().getClassId().getClassName());
      classStudentResponseBase.setDateForm(classes.getPrimaryKey().getClassId().getDateForm());
      classStudentResponseBase.setDateTo(classes.getPrimaryKey().getClassId().getDateTo());

      for (ListStudentResponse listStudent : listStudentResponses) {

        if (listStudent.getId() == classes.getPrimaryKey().getStudentId().getStudentId()) {
          ListClassStudentResponse.ListStudentResponse studentResponse =
                  new ListClassStudentResponse.ListStudentResponse();
          studentResponse.setId(listStudent.getId());
          studentResponse.setFirstName(listStudent.getFirstName());
          studentResponse.setMiddleName(listStudent.getMiddleName());
          studentResponse.setLastName(listStudent.getLastName());
          studentResponse.setGender(listStudent.getGender());
          studentResponse.setOtherStudentDetails(listStudent.getOtherStudentDetails());

          listStudents.add(studentResponse);
        }

      }
      classStudentResponseBase.setStudents(listStudents);
      listClassStudentResponses.add(classStudentResponseBase);
    }

    return listClassStudentResponses;
  }

  /**
   * Este método se encarga de consultar al teacher model y realizar la operacion.
   *
   * @param classesCreateRequest es una json con los datos necesarios para crear un class
   * @return ultimo id creado, status ok
   * @author Raul Ortiz
   */
  public Long createClasses(ClassesCreateRequest classesCreateRequest) {
    Classes classes = new Classes();
    classes.setClassName(classesCreateRequest.getClassName());
    classes.setClassCode(classesCreateRequest.getClassCode());
    classes.setDateForm(classesCreateRequest.getDateForm());
    classes.setDateTo(classesCreateRequest.getDateTo());

    for (ClassesCreateRequest.SubjectListRequest subjectListRequest
            : classesCreateRequest.getSubjectId()) {
      Subject subject = new Subject();
      subject.setSubjectId(subjectListRequest.getId());
      classes.setSubjectId(subject);
    }
    for (ClassesCreateRequest.TeacherListRequest teacherListRequest
            : classesCreateRequest.getTeacherId()) {
      Teacher teacher = new Teacher();
      teacher.setTeacherId(teacherListRequest.getId());
      classes.setTeacherId(teacher);
    }

    classes = classesRepository.save(classes);
    return classes.getClassId();
  }

  /**
   * actualizar classes.
   */

  public String updateClasses(Long id, ClassesCreateRequest classesCreateRequest) {
    Optional<Classes> classesOptional = classesRepository.findById(id);
    if (classesOptional.isPresent()) {
      Classes classesBase = classesOptional.get();

      classesBase.setClassName(classesCreateRequest.getClassName());
      classesBase.setClassCode(classesCreateRequest.getClassCode());
      classesBase.setDateForm(classesCreateRequest.getDateForm());
      classesBase.setDateTo(classesCreateRequest.getDateTo());

      for (ClassesCreateRequest.SubjectListRequest subjectListRequest
              : classesCreateRequest.getSubjectId()) {
        Subject subject = new Subject();
        subject.setSubjectId(subjectListRequest.getId());
        classesBase.setSubjectId(subject);
      }
      for (ClassesCreateRequest.TeacherListRequest teacherListRequest
              : classesCreateRequest.getTeacherId()) {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(teacherListRequest.getId());
        classesBase.setTeacherId(teacher);
      }

      classesRepository.save(classesBase);

      return "Update successful";

    } else {
      throw new CustomException("400", "no existe id " + id);
    }
  }

  /**
   * borrar classes.
   */

  public String deleteClasses(Long id) {
    Optional<Classes> classesOptional = classesRepository.findById(id);
    if (classesOptional.isPresent()) {

      classesRepository.deleteById(id);
      return "Delete successful";
    } else {
      throw new CustomException("400", "no existe id " + id);
    }
  }


}
