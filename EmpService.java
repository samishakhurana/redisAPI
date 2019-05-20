package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public interface EmpService {
    EmpDTO getEmployee(String id);

    EmpDTO createEmployee(EmpDTO employeeDTO);


    EmpDTO updateEmployee(EmpDTO employeeDTO);

    EmpDTO deleteEmployee(String id);

    EmpDTO save(EmpDTO employee) throws Exception;
}

