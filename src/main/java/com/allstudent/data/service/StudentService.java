package com.allstudent.data.service;

import com.allstudent.data.dto.StudentDto;
import com.allstudent.data.dto.StudentsDto;
import com.allstudent.data.exception.Assert;
import com.allstudent.data.exception.NotFoundException;
import com.allstudent.data.model.School;
import com.allstudent.data.model.Student;
import com.allstudent.data.repository.SchoolRepository;
import com.allstudent.data.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class StudentService implements Service<Student,StudentDto> {

    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;

    @Override
    public StudentDto save(StudentDto studentDto) {
        Student savedStudent = studentRepository.save(convertToEntity(studentDto));
        sendWebHook(studentDto.getName()).subscribe(System.out::println);
        return convertToDto(savedStudent);
    }

    public Mono<String> sendWebHook(String studentName){
        String url = "http://localhost:8081/api/student/"+studentName;
        WebClient client = WebClient.builder()
                .baseUrl(url)
                .build();
        return client.get().retrieve().bodyToMono(String.class);
    }

    @Override
    public StudentDto convertToDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setName(student.getName());
        studentDto.setAge(student.getAge());
        studentDto.setSchool_id(student.getSchool().getId());
        return studentDto;
    }

    public StudentsDto getStudents(Integer school_id) {
        Optional<School> optional = schoolRepository.findById(school_id);
        Assert.entityNotFound(optional.isEmpty(),"School "+school_id);
        School school = optional.get();
        List<Student> students = studentRepository.findBySchool(school);
        return StudentsDto.builder()
                .school_id(school.getId())
                .school_name(school.getName())
                .students(students.stream().map(Student::getName).collect(Collectors.joining(",")))
                .build();
    }

    @Override
    public Student convertToEntity(StudentDto studentDto) {
        Optional<School> optional = schoolRepository.findById(studentDto.getSchool_id());
        Assert.entityNotFound(optional.isEmpty(),"School "+studentDto.getSchool_id());
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        School school = optional.get();
        student.setSchool(school);
        return student;
    }

}
