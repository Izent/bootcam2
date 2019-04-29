package com.raul.bootcam2.repository;

import com.raul.bootcam2.model.StudentClasses;
import com.raul.bootcam2.model.StudentClassesPk;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentClassesRepository extends JpaRepository<StudentClasses, StudentClassesPk> {

  List<StudentClasses> findByPrimaryKeyClassIdClassId(Long id);

}
