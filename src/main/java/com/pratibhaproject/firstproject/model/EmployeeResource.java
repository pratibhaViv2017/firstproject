package com.pratibhaproject.firstproject.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class EmployeeResource {
    private List<Employee> data;

    public EmployeeResource() {
    }

    public List<Employee> getData() {
        return data;
    }

    public void setData(List<Employee> data) {
        this.data = data;
    }
}
