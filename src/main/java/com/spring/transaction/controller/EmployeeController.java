package com.spring.transaction.controller;


import com.spring.transaction.entity.EmployeeEntity;
import com.spring.transaction.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Integer id) {
        EmployeeEntity employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }


    @GetMapping("/get-by-email/{email}")
    public ResponseEntity<EmployeeEntity> getEmployeeByEmail(@PathVariable String email) {
        EmployeeEntity employee = employeeService.getEmployeeByEmail(email);
        return ResponseEntity.ok(employee);
    }
}
