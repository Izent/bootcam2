package com.raul.bootcam2.service;

import com.raul.bootcam2.dto.request.SubjectCreateRequest;
import com.raul.bootcam2.dto.request.SubjectUpdateRequest;
import com.raul.bootcam2.dto.response.ListSubjectResponse;
import com.raul.bootcam2.error.CustomException;
import com.raul.bootcam2.model.Subject;
import com.raul.bootcam2.repository.SubjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SubjectService {

  @Autowired
  SubjectRepository subjectRepository;

  public List<ListSubjectResponse> allSubject() {
    List<Subject> subjectList = subjectRepository.findAll();
    List<ListSubjectResponse> subjectResponse = null;
    if (subjectList != null && !subjectList.isEmpty()) {
      subjectResponse = new ArrayList<>();
      ListSubjectResponse subjectResponseBase = null;

    for (Subject subject : subjectList) {
      subjectResponseBase = new ListSubjectResponse();
      subjectResponseBase.setSubjectId(subject.getSubjectId());
      subjectResponseBase.setSubjectName(subject.getSubjectName());
    }

      subjectResponse.add(subjectResponseBase);
    }
    return subjectResponse;
  }

  /**
   * Este método se encarga de consultar al subject service.
   *
   * @param subjectRequest es una json con los datos necesarios para crear un subject
   * @return ultimo id creado, status ok
   * @author Raul Ortiz
   */
  public Long createSubject(SubjectCreateRequest subjectRequest) {
    Subject subject = new Subject();
    subject.setSubjectName(subjectRequest.getSubjectName());
    subject = subjectRepository.save(subject);
    return subject.getSubjectId();
  }

  /**
   * Este método se encarga de consultar al subject service.
   *
   * @param subjectUpdateRequest es una json con los datos necesarios para actualizar un subject
   * @param id                   id de subject a actualizar
   * @return mensaje update successful, status ok
   * @author Raul Ortiz
   */
  public String updateSubject(Long id, SubjectUpdateRequest subjectUpdateRequest) {
    Optional<Subject> subjectOptional = subjectRepository.findById(id);
    if (subjectOptional.isPresent()) {
      Subject subjectBase = subjectOptional.get();
      subjectBase.setSubjectName(subjectUpdateRequest.getSubjectName());
      subjectRepository.save(subjectBase);
      return "Update successful";
    } else {
      throw new CustomException("400", "no existe id " + id);
    }
  }

  /**
   * Este método se encarga de consultar al subject service.
   *
   * @param id id de teacher a eliminar
   * @return mensaje delete successful, status ok
   * @author Raul Ortiz
   */
  public String deleteSubject(Long id) {
    Optional<Subject> subjectOptional = subjectRepository.findById(id);
    if (subjectOptional.isPresent()) {
      subjectRepository.deleteById(id);
      return "Delete successful";
    } else {
      throw new CustomException("400", "no existe id " + id);
    }
  }
}
