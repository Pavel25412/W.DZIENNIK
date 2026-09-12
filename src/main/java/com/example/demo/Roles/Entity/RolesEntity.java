package com.example.demo.Roles.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class RolesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_seq_gen")
    @SequenceGenerator(name = "roles_seq_gen", sequenceName = "roles_seq", allocationSize = 1)
    private Long id;

    @Column(name = "code",  nullable = false, unique = true)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;
}
