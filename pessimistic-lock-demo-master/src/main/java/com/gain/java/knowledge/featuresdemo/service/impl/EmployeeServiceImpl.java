package com.gain.java.knowledge.featuresdemo.service.impl;

import com.gain.java.knowledge.featuresdemo.entity.EmployeeEntity;
import com.gain.java.knowledge.featuresdemo.model.Employee;
import com.gain.java.knowledge.featuresdemo.repository.EmployeeRepository;
import com.gain.java.knowledge.featuresdemo.service.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;


import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public Employee updateEmployee(String name, Employee employee) {
        LOGGER.info("Inside EmployeeServiceImpl updateEmployee method.");
        Optional<EmployeeEntity> empOpt = employeeRepository.findByName(name);

        // stop for 5 seconds
        wait(5000);

        if(empOpt.isPresent()) {
            EmployeeEntity empEntity = empOpt.get();
            if(StringUtils.isNotEmpty(employee.getName()))
                empEntity.setName(employee.getName());
            if(StringUtils.isNotEmpty(employee.getAddress()))
                empEntity.setAddress(employee.getAddress());
            if(!ObjectUtils.isEmpty(employee.getAge()))
                empEntity.setAge(employee.getAge());
            LOGGER.info("Added Balance : "+employee.getBalance());
            if(!ObjectUtils.isEmpty(employee.getBalance())) {
                LOGGER.info("Total Balance : "+empEntity.getSalary() + employee.getBalance());
                empEntity.setSalary(empEntity.getSalary() + employee.getBalance());
            }
            EmployeeEntity empEntityRes = employeeRepository.save(empEntity);
            return getEmployeeModelFromEntity(empEntityRes);
        }
        return null;
    }

    private void wait(int ms) {
        try {
            Thread.sleep(ms);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public Employee getEmployeeById(Long id) {
        LOGGER.info("Inside EmployeeServiceImpl getEmployeeById method.");
        return getEmployeeModelFromEntity(employeeRepository.findById(id).orElse(null));
    }

    private Employee getEmployeeModelFromEntity(EmployeeEntity empEntity) {
        if(empEntity == null)
            return null;
        return new Employee(empEntity.getId(), empEntity.getName(),
                empEntity.getAge(), empEntity.getSalary(), empEntity.getAddress());
    }
}
