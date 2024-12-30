package com.allstudent.data.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentsDto {
    @Min(value = 1, message = "SchoolId must be provided")
    private Integer school_id;
    @NotBlank(message = "SchoolName can´t be blank")
    private String school_name;
    private String students;
}
