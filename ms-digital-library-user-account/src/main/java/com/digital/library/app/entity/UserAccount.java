package com.digital.library.app.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ToString
@Data
@Entity
@Table(name = "user_account")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_account_seq")
    @SequenceGenerator(name = "user_account_seq", sequenceName = "user_account_seq", allocationSize = 1)
    @Column(name = "user_account_id")
    private Integer id;

    @NotNull(message = "Propiedad userName requerido.")
    @Size(min = 5, max = 120, message = "Propiedad UserName con tamaño invalido.")
    @Column(name = "user_name")
    private String userName;

    @NotNull(message = "Propiedad email requerido.")
    @Size(min = 5, max = 120, message = "Propiedad email con tamaño invalido.")
    @Column(name = "email")
    private String email;

    @NotNull(message = "Propiedad password requerido.")
    @Size(min = 5, max = 120, message = "Propiedad password con tamaño invalido.")
    @Column(name = "password")
    private String password;

    @Column(name = "user_account_status",nullable=false, columnDefinition="BOOLEAN" )
    private boolean  userAccountStatus = true;

    @Column(name = "user_profile_id")
    private Integer userProfileId;

}
