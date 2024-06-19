package com.gain.java.knowledge.featuresdemo.service;

import com.gain.java.knowledge.featuresdemo.model.Employee;

public interface EmployeeService {

    Employee updateEmployee(String id, Employee employee);

    Employee getEmployeeById(Long id);

}
