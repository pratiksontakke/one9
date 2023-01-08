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
public class Shippers {
    // ShipperID, ShipperName, Phone
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer shipperID;

    @NotNull
    @NotBlank
    @NotEmpty
    private String shipperName;

    @NotNull
    @NotBlank
    @NotEmpty
    private Long phone;

    @ManyToOne
    @JsonIgnore
    private Employees employee;


}
