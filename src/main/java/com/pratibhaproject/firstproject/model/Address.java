package com.pratibhaproject.firstproject.model;

import java.util.Objects;

public class Address {
    private String city;
    private String state;
    private Integer zipCode;

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return city.equals(address.city) && state.equals(address.state) && zipCode.equals(address.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, state, zipCode);
    }
}
