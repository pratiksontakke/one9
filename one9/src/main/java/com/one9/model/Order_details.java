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
public class Order_details { // OrderDetailID, OrderID, ProductID, Quantity
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer OrderDetailID;

    @NotNull
    @NotBlank
    @NotEmpty
    private String OrderID;

    @NotNull
    @NotBlank
    @NotEmpty
    private String ProductID;

    @NotNull
    @NotBlank
    @NotEmpty
    private LocalDate Quantity;

}
