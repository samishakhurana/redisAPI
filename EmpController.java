package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/employee")
    public EmpDTO getEmployee(@RequestParam String id){
        EmpDTO result=employeeService.getEmployee(id);
        if(result==null){
            System.out.println("No member exists with given Id");
            return null;
        }
        return employeeService.getEmployee(id);

    }

    @PostMapping("/employee")
    public EmpDTO createEmployee(@RequestBody EmpDTO employeeDTO){
        return employeeService.createEmployee(employeeDTO);

    }

    @PutMapping("/employee")
    public EmpDTO updateEmployee(@RequestBody EmpDTO employeeDTO){

        return employeeService.updateEmployee(employeeDTO);
    }



    @DeleteMapping("/deleteEmployee")
    public EmpDTO deleteEmployee(@RequestParam String id){
        return employeeService.deleteEmployee(id);
    }

    @RequestMapping("/saveEmployee")
    public EmpDTO saveEmployee(@RequestBody EmpDTO employeeDTO) throws Exception{
        return employeeService.save(employeeDTO);
    }
}
