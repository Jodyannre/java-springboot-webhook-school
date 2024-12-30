package com.allstudent.data.model;


import jakarta.persistence.*;
import jakarta.validation.Constraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private Integer code;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @OneToMany(targetEntity = Enroll.class, fetch = FetchType.LAZY, mappedBy="courses")
    private Set<Enroll> enrolls = new HashSet<>();
}
