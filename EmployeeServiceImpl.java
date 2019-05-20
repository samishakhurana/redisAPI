package com.example.demo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true,propagation = Propagation.REQUIRES_NEW)
public class EmployeeServiceImpl implements EmpService {

    @Autowired
    private EmployeeRepositoryImpl employeeRepository;

    @Override
    public EmpDTO getEmployee(String employeeId) {
        Employee result=employeeRepository.findOne(employeeId);
        EmpDTO empDTO=new EmpDTO();
        empDTO.setEmployeeId(result.getEmployeeId());
        empDTO.setName(result.getName());
        return empDTO;
    }

    @Override
    @Transactional(readOnly = false)
    public EmpDTO save(EmpDTO employeeDTO) throws Exception {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        if (employee.getEmployeeId() == null) {
            throw new Exception("Transaction Invalid");
        }
        Employee eResult = employeeRepository.save(employee);
        EmpDTO responseDTO = new EmpDTO();
        BeanUtils.copyProperties(eResult, responseDTO);

        return responseDTO;
    }

    @Override
    public EmpDTO createEmployee(EmpDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        //employee.setPassword("Some Random Password");
        Employee eResult = employeeRepository.insert(employee);
        EmpDTO responseDTO = new EmpDTO();
        BeanUtils.copyProperties(eResult, responseDTO);

        return responseDTO;
    }



    @Override
    public EmpDTO updateEmployee(EmpDTO employeeDTO) {
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        Employee eResult=employeeRepository.save(employee);
        EmpDTO responseDTO = new EmpDTO();
        BeanUtils.copyProperties(eResult, responseDTO);

        return responseDTO;
    }

    @Override
    public EmpDTO deleteEmployee(String  id) {
        Employee employee=new Employee();
        employeeRepository.delete(id);

        return null;
    }
}
