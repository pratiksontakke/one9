package com.one9.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Suppliers { // SupplierID, SupplierName, ContactName, Address, City, PostalCode, Country, Phone

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer supplierID;

    @NotNull
    @NotBlank
    @NotEmpty
    private String supplierName;

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

    @NotNull
    @NotBlank
    @NotEmpty
    private Long phone;

    @ManyToOne
    @JsonIgnore
    private Employees employee;

}
