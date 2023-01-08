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
public class Products {
    // ProductID, ProductName, SupplierID, CategoryID, Unit, Price

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productID;

    @NotNull
    @NotBlank
    @NotEmpty
    private String productName;

    @NotNull
    @NotBlank
    @NotEmpty
    private Integer supplierID;

    @NotNull
    @NotBlank
    @NotEmpty
    private Integer categoryID;

    @NotNull
    @NotBlank
    @NotEmpty
    private Integer unit;

    @NotNull
    @NotBlank
    @NotEmpty
    private Integer price;

    @ManyToOne
    @JsonIgnore
    private Employees employee;
}