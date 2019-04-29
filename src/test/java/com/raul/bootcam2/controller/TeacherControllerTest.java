package com.raul.bootcam2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raul.bootcam2.model.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TeacherControllerTest {

  @Autowired
  ObjectMapper objectmapper;

  @Autowired
  private MockMvc mvc;


  @Test
  public void listTeacher() throws Exception {

    this.mvc.perform(get("/api/teacher/"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"));
  }

  @Test
  public void createTeacher() throws Exception {
    Teacher teacher = new Teacher();
    teacher.setFirstName("a");
    teacher.setMiddleName("test");
    teacher.setLastName("test");
    teacher.setOtherTeacherDetails("details");

    this.mvc.perform(post("/api/teacher")
            .content(objectmapper.writeValueAsString(teacher))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn();
  }

  @Test
  public void updateTeacher() throws Exception {
    Teacher teacher = new Teacher();
    teacher.setTeacherId(2L);
    teacher.setFirstName("a");
    teacher.setMiddleName("test");
    teacher.setLastName("test");
    teacher.setOtherTeacherDetails("details");

    this.mvc.perform(put("/api/teacher/1")
            .content(objectmapper.writeValueAsString(teacher))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn();
    this.mvc.perform(MockMvcRequestBuilders.put("/api/teacher/37"))
            .andExpect(status().isBadRequest())
            .andReturn();
  }

  @Test
  public void deleteTeacher() throws Exception {

    Teacher teacher = new Teacher();
    teacher.setFirstName("a");
    teacher.setMiddleName("test");
    teacher.setLastName("test");
    teacher.setOtherTeacherDetails("details");

    this.mvc.perform(delete("/api/teacher/4")
            .content(objectmapper.writeValueAsString(teacher))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn();

    this.mvc.perform(MockMvcRequestBuilders.delete("/api/teacher/37"))
            .andExpect(status().isConflict())
            .andReturn();


  }
}