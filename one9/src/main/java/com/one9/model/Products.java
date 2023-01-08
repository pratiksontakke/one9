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
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Products {
    // ProductID, ProductName, SupplierID, CategoryID, Unit, Price

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ProductID;

    @NotNull
    @NotBlank
    @NotEmpty
    private String ProductName;

    @NotNull
    @NotBlank
    @NotEmpty
    private String SupplierID;

    @NotNull
    @NotBlank
    @NotEmpty
    private LocalDate CategoryID;

    @NotNull
    @NotBlank
    @NotEmpty
    private String Unit;

    @NotNull
    @NotBlank
    @NotEmpty
    private String Price;
}
