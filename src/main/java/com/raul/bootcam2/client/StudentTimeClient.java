package com.raul.bootcam2.client;

import com.raul.bootcam2.client.fallback.StudentClientTimeFallBack;
import com.raul.bootcam2.dto.response.ListStudentResponse;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "name-prueb", url = "${service.student.path}",
        fallbackFactory = StudentClientTimeFallBack.class)
public interface StudentTimeClient {

  @GetMapping("/api/student/list-time")
  List<ListStudentResponse> getListTime();
}
