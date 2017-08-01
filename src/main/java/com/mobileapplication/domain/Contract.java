package com.mobileapplication.domain;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "number")
    private Integer number;


    @ManyToOne
    @JoinColumn(name = "id_tariff", nullable = false)
    private Tariff tariff;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "contract_options",
            joinColumns = { @JoinColumn(name = "id_contract") },
            inverseJoinColumns = { @JoinColumn(name = "id_option") }
    )
    private Set<Option> options;

    @Column(name = "isBlockedByUser")
    private Integer isBlockedByUser;

    @Column(name = "isBlockedByAdmin")
    private Integer isBlockedByAdmin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }
    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }

    public Integer getIsBlockedByUser() {
        return isBlockedByUser;
    }

    public void setIsBlockedByUser(Integer isBlockedByUser) {
        this.isBlockedByUser = isBlockedByUser;
    }

    public Integer getIsBlockedByAdmin() {
        return isBlockedByAdmin;
    }

    public void setIsBlockedByAdmin(Integer isBlockedByAdmin) {
        this.isBlockedByAdmin = isBlockedByAdmin;
    }
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


}

