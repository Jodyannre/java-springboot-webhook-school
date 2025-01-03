package com.allstudent.data.service;

import com.allstudent.data.dto.SchoolDto;
import com.allstudent.data.model.School;
import com.allstudent.data.repository.SchoolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class SchoolService implements Service<School, SchoolDto> {
    private final SchoolRepository schoolRepository;

    @Override
    public SchoolDto save(SchoolDto schoolDto) {
        School savedSchool = schoolRepository.save(convertToEntity(schoolDto));
        return convertToDto(savedSchool);
    }

    @Override
    public SchoolDto convertToDto(School school) {
        SchoolDto schoolDto = new SchoolDto();
        schoolDto.setName(school.getName());
        return schoolDto;
    }

    @Override
    public School convertToEntity(SchoolDto schoolDto) {
        School school = new School();
        school.setName(schoolDto.getName());
        return school;
    }
}
