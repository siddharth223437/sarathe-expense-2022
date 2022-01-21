package com.sarathe.expense.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Embeddable
public class Address {

    @Basic
    @Column(name = "street1")
    private String street1;
    @Basic
    @Column(name = "street2")
    private String street2;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "state")
    private String state;
    @Basic
    @Column(name = "country")
    private String country;

    @Basic
    @Column(name = "address_type")
    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @Basic
    @Column(name = "postal_code")
    private String postalCode;
}
