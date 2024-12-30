package com.allstudent.data.repository;

import com.allstudent.data.model.School;
import com.allstudent.data.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findBySchool(School school);
}

