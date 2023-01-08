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
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Orders { // OrderID, CustomerID, EmployeeID, OrderDate, ShipperID

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderID;

    /*@NotNull
    @NotBlank
    @NotEmpty
    private Integer customerID;*/

    @NotNull
    @NotBlank
    @NotEmpty
    @JsonIgnore
    private LocalDate orderDate;

    @NotNull
    @NotBlank
    @NotEmpty
    private Integer unit;

    @NotNull
    @NotBlank
    @NotEmpty
    @JsonIgnore
    private Integer shipperID;

    @NotNull
    @NotBlank
    @NotEmpty
    private Integer productID;

    @ManyToOne
    @JsonIgnore
    private Customers customer;

}