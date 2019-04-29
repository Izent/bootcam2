package com.raul.bootcam2.client;

import com.raul.bootcam2.client.fallback.StudentClientFallBack;
import com.raul.bootcam2.dto.response.ListStudentResponse;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "EVERIS-EJERCICIO-B", url = "${service.student.path}",
        fallbackFactory = StudentClientFallBack.class)
public interface StudentClient {

  @GetMapping("/api/student/")
  List<ListStudentResponse> getList();

}
