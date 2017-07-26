package com.mobileapplication.domain;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "tariff")
public class Tariff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "price")
    private Integer price;
    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "tariff_options",
            joinColumns = { @JoinColumn(name = "id_tariff") },
            inverseJoinColumns = { @JoinColumn(name = "id_option") }
            )
    private Set<Option> availableOptions;


    @OneToMany(
            mappedBy = "tariff",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Contract> contracts ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<Option> getAvailableOptions() {
        return availableOptions;
    }

    public void setAvailableOptions(Set<Option> availableOptions) {
        this.availableOptions = availableOptions;
    }

    public List<Contract> getContracts() {
        return contracts;
    }
    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}

