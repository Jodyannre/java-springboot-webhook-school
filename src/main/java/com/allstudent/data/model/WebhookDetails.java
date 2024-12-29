package com.allstudent.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebhookDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String eventName;
    private String endPointUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="school_id")
    private School school;

}
