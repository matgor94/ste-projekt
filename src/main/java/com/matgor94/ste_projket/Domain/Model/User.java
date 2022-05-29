package com.matgor94.ste_projket.Domain.Model;

import lombok.*;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "user")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @NotBlank @Size(min = 11, max = 11)
    private String pesel;

    @NotNull @NotBlank @Size(min = 3) @Column(name = "first_name")
    private String firstName;

    @NotBlank @NotNull @Size(min=3) @Column(name = "last_name")
    private String lastName;

    @NotNull @NotBlank @Column(name = "phone_number") @Size(min = 9)
    private String phoneNumber;

    @NotBlank @NotNull
    private String addres;

}
