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
public class Shippers {
    // ShipperID, ShipperName, Phone
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ShipperID;

    @NotNull
    @NotBlank
    @NotEmpty
    private String ShipperName;

    @NotNull
    @NotBlank
    @NotEmpty
    private String Phone;

}
