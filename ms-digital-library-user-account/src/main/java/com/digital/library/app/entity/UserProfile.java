package com.digital.library.app.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ToString
@Data
@Entity
@Table(name = "user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_profile_seq")
    @SequenceGenerator(name = "user_profile_seq", sequenceName = "user_profile_seq", allocationSize = 1)
    @Column(name = "user_profile_id")
    private Integer id;

    @NotNull(message = "Propiedad firstName requerido.")
    @Size(min = 5, max = 120, message = "Propiedad firstName con tamaño invalido.")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Propiedad lastName requerido.")
    @Size(min = 5, max = 120, message = "Propiedad lastName con tamaño invalido.")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Propiedad fullName requerido.")
    @Size(min = 5, max = 120, message = "Propiedad fullName con tamaño invalido.")
    @Column(name = "full_name")
    private String fullName;

    @NotNull(message = "Propiedad email requerido.")
    @Size(min = 5, max = 120, message = "Propiedad email con tamaño invalido.")
    @Column(name = "email")
    private String email;


}
