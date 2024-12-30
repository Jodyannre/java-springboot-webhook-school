package com.allstudent.data.service;

import com.allstudent.data.dto.CourseDto;
import com.allstudent.data.exception.NotFoundException;
import com.allstudent.data.model.Course;
import com.allstudent.data.model.School;
import com.allstudent.data.repository.CourseRepository;
import com.allstudent.data.repository.SchoolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@AllArgsConstructor
public class CourseService implements Service<Course, CourseDto> {

    private final CourseRepository courseRepository;
    private final SchoolRepository schoolRepository;

    @Override
    public CourseDto save(CourseDto courseDto) {
        Course savedCourse = courseRepository.save(convertToEntity(courseDto));
        return convertToDto(savedCourse);
    }

    @Override
    public CourseDto convertToDto(Course course) {
        CourseDto courseDto = new CourseDto();
        courseDto.setName(course.getName());
        courseDto.setCode(course.getCode());
        courseDto.setSchoolId(course.getSchool().getId());
        return courseDto;
    }

    @Override
    public Course convertToEntity(CourseDto courseDto) {
        Course course = new Course();
        course.setName(courseDto.getName());
        course.setCode(courseDto.getCode());
        Optional<School> optional = schoolRepository.findById(courseDto.getSchoolId());
        if (optional.isEmpty()) {
            throw new NotFoundException("School not found");
        }
        School school = optional.get();
        course.setSchool(school);
        return course;
    }
}