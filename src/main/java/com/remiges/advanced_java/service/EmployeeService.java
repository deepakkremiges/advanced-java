package com.remiges.advanced_java.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.remiges.advanced_java.entity.Employee;
import com.remiges.advanced_java.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Object[]> listEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(employee -> new Object[] { employee.getId(), employee.getName() })
                .collect(Collectors.toList());
    }

    public List<Employee> listEmployees(String filter) {
        if (filter != null && !filter.isEmpty()) {
            return employeeRepository.findAll();
        } else {
            return employeeRepository.findAll();
        }
    }

    public Optional<Employee> getEmployeeDetails(Long id) {
        return employeeRepository.findById(id);
    }

    // public Optional<Employee> updateEmployee(Long id,@RequestBody Employee
    // updatedEmployee) {
    // Optional<Employee> emp = employeeRepository.findById(id);
    // if (!emp.isPresent()) {
    // throw new RuntimeException("Cannot find employee with id=" + id);
    // }else{
    // emp.get().setFirstName(updatedEmployee.getFirstName());
    // return emp;
    // }

}
