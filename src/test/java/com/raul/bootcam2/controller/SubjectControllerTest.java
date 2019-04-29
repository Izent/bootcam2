package com.raul.bootcam2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raul.bootcam2.model.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SubjectControllerTest {

  @Autowired
  ObjectMapper objectmapper;
  @Autowired
  private MockMvc mvc;


  @Test
  public void listSubject() throws Exception {
    this.mvc.perform(get("/api/subject/"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"));
  }

  @Test
  public void createSubject() throws Exception {
    Subject subject = new Subject();
    subject.setSubjectName("test");

    this.mvc.perform(post("/api/subject")
            .content(objectmapper.writeValueAsString(subject))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn();

    this.mvc.perform(post("/api/subject")
            .contentType(MediaType.APPLICATION_JSON)
            .content(" ")).andExpect(status().isBadRequest())
            .andReturn();
    this.mvc.perform(post("/api/subject")
            .contentType(MediaType.APPLICATION_JSON)
            .header("accept-language", "en")
            .content("{} ")).andExpect(status().isBadRequest())
            .andReturn();

  }

  @Test
  public void updateSubject() throws Exception {
    Subject subject = new Subject();
    subject.setSubjectId(1L);
    subject.setSubjectName("test");

    this.mvc.perform(put("/api/subject/1")
            .content(objectmapper.writeValueAsString(subject))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn();

    this.mvc.perform(MockMvcRequestBuilders.put("/api/subject/37"))
            .andExpect(status().isBadRequest())
            .andReturn();

  }

  @Test
  public void deleteSubject() throws Exception {
    Subject subject = new Subject();
    subject.setSubjectId(3L);
    subject.setSubjectName("test");
    this.mvc.perform(delete("/api/subject/3")
            .content(objectmapper.writeValueAsString(subject))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn();

    this.mvc.perform(MockMvcRequestBuilders.delete("/api/subject/37"))
            .andExpect(status().isConflict())
            .andReturn();
  }
}