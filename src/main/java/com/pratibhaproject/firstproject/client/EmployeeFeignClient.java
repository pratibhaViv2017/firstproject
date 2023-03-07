package com.pratibhaproject.firstproject.client;

import com.pratibhaproject.firstproject.model.EmployeeResource;
import feign.RequestLine;

public interface EmployeeFeignClient {

    @RequestLine("GET /employees")
    EmployeeResource findAll();

}