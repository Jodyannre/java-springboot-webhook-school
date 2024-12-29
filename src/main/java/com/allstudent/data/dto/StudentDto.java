package com.allstudent.data.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    @NotBlank(message = "Name can't be blank.")
    private String name;
    @NotNull(message = "Age can't be blank.")
    @Min(16)
    private Integer age;
    @NotNull(message = "School id must be provided")
    @Min(1)
    private Integer school_id;
}
