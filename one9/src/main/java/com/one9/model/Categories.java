package com.one9.model;

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
public class Categories { // CategoryID, CategoryName, Description

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer categoryID;

    @NotNull
    @NotBlank
    @NotEmpty
    private String categoryName;

    @NotNull
    @NotBlank
    @NotEmpty
    private String description;

    @ManyToOne
    private Employees employee;


}
