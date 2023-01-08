package com.one9.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private Integer SupplierID;

    @NotNull
    @NotBlank
    @NotEmpty
    private String SupplierName;

    @NotNull
    @NotBlank
    @NotEmpty
    private String ContactName;

    @NotNull
    @NotBlank
    @NotEmpty
    private String Address;

    @NotNull
    @NotBlank
    @NotEmpty
    private String City;

    @NotNull
    @NotBlank
    @NotEmpty
    private String PostalCode;

    @NotNull
    @NotBlank
    @NotEmpty
    private String Country;

    @NotNull
    @NotBlank
    @NotEmpty
    private String Phone;

}
