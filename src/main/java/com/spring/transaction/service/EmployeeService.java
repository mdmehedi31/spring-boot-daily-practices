package com.spring.transaction.service;


import com.spring.transaction.entity.EmployeeEntity;
import com.spring.transaction.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public EmployeeEntity getEmployeeById(Integer id) {
        try{
            EmployeeEntity employeeEntity= this.employeeRepository.findById(id).get();
            return employeeEntity;
        }catch (Exception e) {
            throw  e;
        }
    }

    public EmployeeEntity getEmployeeByEmail(String email) {
        try{
            EmployeeEntity employeeEntity = this.employeeRepository.findByEmail(email);
            return employeeEntity;
        }catch (Exception e) {
            throw  e;
        }
    }
}
