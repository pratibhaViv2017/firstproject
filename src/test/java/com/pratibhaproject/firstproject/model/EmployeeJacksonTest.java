package com.pratibhaproject.firstproject.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeJacksonTest {

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee();
    }

    @Test
    public void testDeSerializingWithJsonProperty() throws IOException {
        String jsonString = "{\"id\":1,\"employee_name\":\"Tiger Nixon\",\"employee_salary\":320800,\"employee_age\":61,\"profile_image\":\"\"}";
        ObjectMapper mapper = new ObjectMapper();
        Employee bean = mapper.readValue(jsonString, Employee.class);
        assertEquals(bean.getEmployeeName(), "Tiger Nixon");
        assertEquals(bean.getEmployeeAge(), 61);
    }
}