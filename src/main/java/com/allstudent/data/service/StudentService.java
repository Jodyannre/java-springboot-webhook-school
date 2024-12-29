package com.allstudent.data.service;

import com.allstudent.data.dto.StudentDto;
import com.allstudent.data.exception.NotFoundException;
import com.allstudent.data.model.School;
import com.allstudent.data.model.Student;
import com.allstudent.data.repository.SchoolRepository;
import com.allstudent.data.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


import java.util.Optional;

@Component
@AllArgsConstructor
public class StudentService implements Service<Student,StudentDto> {

    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;

    @Override
    public StudentDto save(StudentDto studentDto) {
        Student savedStudent = studentRepository.save(convertToEntity(studentDto));
        return convertToDto(savedStudent);
    }

    @Override
    public StudentDto convertToDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setName(student.getName());
        studentDto.setAge(student.getAge());
        studentDto.setSchool_id(student.getSchool().getId());
        return studentDto;
    }

    @Override
    public Student convertToEntity(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        Optional<School> school = schoolRepository.findById(studentDto.getSchool_id());
        if (school.isEmpty()) {
            throw new NotFoundException(String.format("School with id: %s not found",
                    studentDto.getSchool_id()));
        }
        student.setSchool(school.orElse(null));
        return student;
    }

}
