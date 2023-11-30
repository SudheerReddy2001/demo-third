package com.OneToOneMapping.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String countryName;
    private String countryPmName;

    @OneToMany(cascade = {CascadeType.ALL,CascadeType.REMOVE},orphanRemoval = true)
    @JoinColumn(name = "country_id")
    private Set<State> state= new HashSet<>();
}

