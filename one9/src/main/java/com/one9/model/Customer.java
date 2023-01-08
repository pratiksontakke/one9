package com.one9.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerID;

    @NotNull
    @NotBlank
    @NotEmpty
    private String customerName;

    @NotNull
    @NotBlank
    @NotEmpty
    private String contactName;

    @NotNull
    @NotBlank
    @NotEmpty
    private String address;

    @NotNull
    @NotBlank
    @NotEmpty
    private String city;

    @NotNull
    @NotBlank
    @NotEmpty
    private String postalCode;

    @NotNull
    @NotBlank
    @NotEmpty
    private String country;



    /*@Size(min = 10, message = "Please enter valid mobile number")
    @Column(unique=true)
    private String mobileNumber;

    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}", message = "Password must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters")
    private String password;

    @Email(message = "Enter valid email id.")
    private String email;*/



}
