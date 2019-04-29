package com.raul.bootcam2.controller;

import com.raul.bootcam2.dto.request.SubjectCreateRequest;
import com.raul.bootcam2.dto.request.SubjectUpdateRequest;
import com.raul.bootcam2.dto.response.ListSubjectResponse;
import com.raul.bootcam2.error.ValidateException;
import com.raul.bootcam2.model.Subject;
import com.raul.bootcam2.service.SubjectService;
import com.raul.bootcam2.trastale.Translator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/subject")
@Api(value = "Subject Management System",
        description = "Operations pertaining to Subject in Subject Management System")
public class SubjectController {

  @Autowired
  SubjectService subjectService;

  /**
   * Este método se encarga de consultar al subject service.
   *
   * @return lista de subject
   * @author Raul Ortiz
   */
  @ApiOperation(value = "View a list of available Subject", response = List.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully retrieved list"),
          @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
          @ApiResponse(code = 403,
                  message = "Accessing the resource you were trying to reach is forbidden"),
          @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
  })
  @GetMapping
  public List<ListSubjectResponse> listSubject() {
    log.debug("Log de Debug");
    log.info("Log de Info");
    log.warn("Log de Warn");
    log.error("Log de Error");
    log.trace("Log de Trace");
    return subjectService.allSubject();
  }

  /**
   * Este método se encarga de consultar al subject service.
   *
   * @param subject es una json con los datos necesarios para crear un subject
   * @param br      extiende de error para validar las entradas
   * @return ultimo id creado, status ok
   * @author Raul Ortiz
   */
  @ApiOperation(value = "Add an Subject")
  @PostMapping
  public Long createSubject(@ApiParam(value = "Subject object store in database table",
          required = true)
                            @RequestBody @Validated SubjectCreateRequest subject,
                            BindingResult br) {

    if (br.hasErrors()) {
      log.info("error of validation");
      List<String> errorList = new ArrayList<>();
      for (FieldError e : br.getFieldErrors()) {
        errorList.add(Translator.toLocale(e.getDefaultMessage()));
      }
      if (!errorList.isEmpty()) {
        throw new ValidateException(errorList);
      }
    }
    return subjectService.createSubject(subject);
  }

  /**
   * Este método se encarga de consultar al subject service.
   *
   * @param subject es una json con los datos necesarios para actualizar un subject
   * @param id      id de subject a actualizar
   * @return mensaje update successful, status ok
   * @author Raul Ortiz
   */
  @ApiOperation(value = "Update an Subject")
  @PutMapping("/{subjectId}")
  public String updateSubject(@ApiParam(value = "Subject Id to update Subject object",
          required = true)
                              @PathVariable("subjectId") Long id,
                              @ApiParam(value = "Update Subject object", required = true)
                              @RequestBody SubjectUpdateRequest subject) {

    return subjectService.updateSubject(id, subject);

  }

  /**
   * Este método se encarga de consultar al subject service.
   *
   * @param id id de subject a eliminar
   * @return mensaje delete successful, status ok
   * @author Raul Ortiz
   */
  @ApiOperation(value = "Delete an Subject")
  @DeleteMapping("/{subjectId}")
  public String deleteSubject(@ApiParam(
          value = "Subject Id from which Subject object will delete from database table",
          required = true)
                              @PathVariable("subjectId") Long id) {

    return subjectService.deleteSubject(id);
  }
}
