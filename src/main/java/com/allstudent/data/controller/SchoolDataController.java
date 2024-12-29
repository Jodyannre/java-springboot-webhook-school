package com.allstudent.data.controller;


import com.allstudent.data.dto.ApiResponse;
import com.allstudent.data.dto.SchoolDto;
import com.allstudent.data.model.School;
import com.allstudent.data.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/school")
@RequiredArgsConstructor
public class SchoolDataController {

    private final SchoolService schoolService;

    @PostMapping("/create")
    public @ResponseBody ApiResponse<SchoolDto> addNewSchool(@RequestBody SchoolDto dto) {
        return schoolService.save(dto);
    }
}
