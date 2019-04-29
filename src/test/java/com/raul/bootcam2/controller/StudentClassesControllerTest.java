package com.raul.bootcam2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raul.bootcam2.model.StudentClasses;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class StudentClassesControllerTest {

  @Autowired
  ObjectMapper objectmapper;
  @Autowired
  private MockMvc mvc;

  @Test
  public void listClasses() throws Exception {

    this.mvc.perform(get("/api/StudentClasses/"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"));
  }

  @Test
  public void createClasses() throws Exception {

    this.mvc.perform(post("/api/StudentClasses")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\n" +
                    "\t\"dateFrom\":\"2019-04-24\",\n" +
                    "\t\"dateTo\":\"2019-04-26\",\n" +
                    "\t\"studentId\":[\n" +
                    "\t\t{\n" +
                    "\t\t\t\"id\":1\n" +
                    "\t\t}\n" +
                    "\t],\n" +
                    "\t\"classId\":[\n" +
                    "\t\t{\n" +
                    "\t\t\t\"id\":1\n" +
                    "\t\t}\n" +
                    "\t]\n" +
                    "}")).andExpect(status().isOk())
            .andReturn();
  }
}