package com.raul.bootcam2.client.fallback;

import com.raul.bootcam2.client.StudentClient;
import feign.hystrix.FallbackFactory;

import java.util.ArrayList;

import org.springframework.stereotype.Component;


@Component
public class StudentClientFallBack implements FallbackFactory<StudentClient> {
  @Override
  public StudentClient create(Throwable cause) {
    return ArrayList::new;
  }
}
