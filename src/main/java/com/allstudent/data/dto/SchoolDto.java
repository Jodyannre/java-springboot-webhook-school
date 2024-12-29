package com.allstudent.data.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDto {
    @NotBlank(message = "Name can't be blank.")
    @Size(min = 8, max = 50)
    private String name;
}
