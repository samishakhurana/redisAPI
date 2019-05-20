package com.example.demo;

import java.io.Serializable;

public class Employee implements Serializable {

    String name;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    String employeeId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
