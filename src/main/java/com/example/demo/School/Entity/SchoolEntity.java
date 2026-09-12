package com.example.demo.School.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "schools")
public class SchoolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_seq_gen")
    @SequenceGenerator(name = "school_seq_gen", sequenceName = "schools_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;
}
