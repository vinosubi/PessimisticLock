package com.gain.java.knowledge.featuresdemo.controller;

import com.gain.java.knowledge.featuresdemo.model.Employee;
import com.gain.java.knowledge.featuresdemo.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id){
        LOGGER.info("Inside EmployeeController getEmployeeById method.");
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/employee/{name}")
    public Employee updateEmployee(@PathVariable("name") String name, @RequestBody Employee employee){
        LOGGER.info("Inside EmployeeController updateEmployee method.");
        return employeeService.updateEmployee(name, employee);
    }
}
