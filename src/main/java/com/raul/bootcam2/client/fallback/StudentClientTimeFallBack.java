package com.raul.bootcam2.client.fallback;

import com.raul.bootcam2.client.StudentTimeClient;
import feign.hystrix.FallbackFactory;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class StudentClientTimeFallBack implements FallbackFactory<StudentTimeClient> {
  @Override
  public StudentTimeClient create(Throwable cause) {
    return ArrayList::new;
  }
}
