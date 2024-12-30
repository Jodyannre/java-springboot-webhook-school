package com.allstudent.data.controller;


import com.allstudent.data.dto.CourseDto;
import com.allstudent.data.dto.SchoolDto;
import com.allstudent.data.dto.StudentDto;
import com.allstudent.data.service.CourseService;
import com.allstudent.data.service.SchoolService;
import com.allstudent.data.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api")
@RequiredArgsConstructor
public class SchoolDataController {

    private final SchoolService schoolService;
    private final StudentService studentService;
    private final CourseService courseService;

    @PostMapping("/school")
    @ResponseBody
    public ResponseEntity<?> addNewSchool(@Valid @RequestBody SchoolDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(schoolService.save(dto));
    }

    @PostMapping("/student")
    @ResponseBody
    public ResponseEntity<?> addNewStudent(@Valid @RequestBody StudentDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(dto));
    }

    @PostMapping("/course")
    @ResponseBody
    public ResponseEntity<?> addNewCourse(@Valid @RequestBody CourseDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.save(dto));
    }

    @GetMapping("/school/{id}")
    @ResponseBody
    public ResponseEntity<?> getSchoolById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.getStudents(id));
    }
}
