package com.pratibhaproject.firstproject.model;

import java.util.Objects;

public class User {

    private Integer userId;
    private String userName;
    private Address address;

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId.equals(user.userId) && userName.equals(user.userName) && address.equals(user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, address);
    }
}
