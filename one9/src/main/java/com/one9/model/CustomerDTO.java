package com.one9.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public class CustomerDTO {
    @NotNull
    @NotBlank
    @NotEmpty
    private String firstName;

    @NotNull
    @NotBlank
    @NotEmpty
    private String lastName;

    @NotNull
    @NotBlank
    @NotEmpty
    private LocalDate birthDate;

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

    @Size(min = 10, message = "Please enter valid mobile number")
    @Column(unique=true)
    private String mobileNumber;

    @Email(message = "Enter valid email id.")
    private String email;

}
