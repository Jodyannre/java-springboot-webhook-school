package com.allstudent.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;

    @ManyToOne(targetEntity = School.class)
    @NotNull
    @JoinColumn(name = "school_id")
    private School school;

    @OneToMany(targetEntity = Enroll.class, fetch = FetchType.LAZY, mappedBy = "student")
    private Set<Enroll> enrolls = new HashSet<>();
}
