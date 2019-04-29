package com.raul.bootcam2.repository;

import com.raul.bootcam2.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
