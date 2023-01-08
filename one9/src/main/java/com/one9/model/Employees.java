package com.one9.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employees { // EmployeeID, LastName, FirstName, BirthDate, Photo, Notes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeID;

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

    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}", message = "Password must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters")
    private String password;

    @Email(message = "Enter valid email id.")
    private String email;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Products> products;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Shippers> shippers;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Suppliers> suppliers;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Categories> categories;

}
