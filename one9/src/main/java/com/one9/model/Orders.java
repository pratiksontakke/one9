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
public class Orders { // OrderID, CustomerID, EmployeeID, OrderDate, ShipperID

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer OrderID;

    @NotNull
    @NotBlank
    @NotEmpty
    private String CustomerID;

    @NotNull
    @NotBlank
    @NotEmpty
    private String EmployeeID;

    @NotNull
    @NotBlank
    @NotEmpty
    private LocalDate OrderDate;

    @NotNull
    @NotBlank
    @NotEmpty
    private String ShipperID;

}
