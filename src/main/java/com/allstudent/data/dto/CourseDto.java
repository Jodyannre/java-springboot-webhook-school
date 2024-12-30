package com.allstudent.data.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    @NotBlank(message="Name can't be blank")
    @NotNull(message = "Name must be provided.")
    private String name;
    @Min(value = 1,message = "Code can't be less than 1")
    @NotNull(message = "Code must be provided.")
    private Integer code;
    @Min(value = 1,message = "SchoolId can't be less than 1")
    @NotNull(message = "SchoolId must be provided.")
    private Integer schoolId;
}
