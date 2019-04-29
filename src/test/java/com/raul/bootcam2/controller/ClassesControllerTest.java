package com.raul.bootcam2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raul.bootcam2.model.Classes;
import com.raul.bootcam2.model.Subject;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ClassesControllerTest {

  @Autowired
  ObjectMapper objectmapper;
  @Autowired
  private MockMvc mvc;

  @Test
  public void getListClassById() throws Exception {
    this.mvc.perform(get("/api/classes/2"))
            .andExpect(status().isOk())
            .andReturn();
  }

  @Test
  public void getListStudent() throws Exception {
    this.mvc.perform(get("/api/classes/list-student"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"));
  }

  @Test
  public void getListTimeStudent() throws Exception {
    this.mvc.perform(get("/api/classes/list-student-time"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"));
  }

  @Test
  public void listClasses() throws Exception {
    this.mvc.perform(get("/api/classes/"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"));
  }

  @Test
  public void createClasses() throws Exception {
    this.mvc.perform(post("/api/classes")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\n" +
                    "\t\"classCode\":\"IS001\",\n" +
                    "\t\"className\":\"Spring\",\n" +
                    "\t\"dateForm\":\"2019-04-24\",\n" +
                    "\t\"dateTo\":\"2019-04-26\",\n" +
                    "\t\"subjectId\":[\n" +
                    "\t\t{\n" +
                    "\t\t\"id\": 1\n" +
                    "\t\t}\n" +
                    "\t],\n" +
                    "\t\"teacherId\":[\n" +
                    "\t\t{\n" +
                    "\t\t\"id\":1\n" +
                    "\t\t}\n" +
                    "\t]\n" +
                    "\t\n" +
                    "}")).andExpect(status().isOk())
            .andReturn();
  }

  @Test
  public void updateClasses() throws Exception {
    this.mvc.perform(put("/api/classes/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\n" +
                    "\t\"classCode\":\"IS002\",\n" +
                    "\t\"className\":\"edit\",\n" +
                    "\t\"dateForm\":\"2019-04-24\",\n" +
                    "\t\"dateTo\":\"2019-04-26\",\n" +
                    "\t\"subjectId\":[\n" +
                    "\t\t{\n" +
                    "\t\t\"id\": 2\n" +
                    "\t\t}\n" +
                    "\t],\n" +
                    "\t\"teacherId\":[\n" +
                    "\t\t{\n" +
                    "\t\t\"id\":1\n" +
                    "\t\t}\n" +
                    "\t]\n" +
                    "\t\n" +
                    "}")).andExpect(status().isOk())
            .andReturn();

    this.mvc.perform(MockMvcRequestBuilders.put("/api/classes/37"))
            .andExpect(status().isBadRequest())
            .andReturn();
  }

  @Test
  public void deleteClasses() throws Exception {

    this.mvc.perform(MockMvcRequestBuilders.delete("/api/classes/3"))
            .andExpect(status().isOk())
            .andReturn();

    this.mvc.perform(MockMvcRequestBuilders.delete("/api/classes/37"))
            .andExpect(status().isConflict())
            .andReturn();
  }
}