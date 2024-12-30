package com.allstudent.data.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    @NotBlank(message="Name can't be blank.")
    private String name;
    @Min(value = 1,message = "Code can't be less than 1")
    private Integer code;
    @Min(value = 1,message = "Code can't be less than 1")
    private Integer schoolId;
}
