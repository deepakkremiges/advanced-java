package com.deepak.advance_assignment.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.deepak.advance_assignment.dto.EmployeeDTO;
import com.deepak.advance_assignment.entity.EmployeeEntity;
import com.deepak.advance_assignment.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeEntity addEmployee(@RequestBody EmployeeEntity employeeDTO) {

        return employeeRepository.save(employeeDTO);
    }

    public List<Object[]> getEmployeeIdsAndNames(int id) {
        return employeeRepository.findAll()
                .stream()
                .map(employee -> new Object[] { employee.getId(), employee.getFullName() })
                .collect(Collectors.toList());
    }

    public List<EmployeeEntity> findEmployeesbyFilter(String filter) {
        return employeeRepository.findEmployeesByFilter(filter);
    }
    // public EmployeeDTO getEmployeeDetailsById(Long id) {
    // EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
    // if (employeeEntity != null) {
    // return convertToDTO(employeeEntity);
    // } else {
    // return null;
    // }
    // }

    // private EmployeeDTO convertToDTO(EmployeeEntity entity) {

    // EmployeeDTO dto = new EmployeeDTO();
    // dto.setEmpId(entity.getEmpId());
    // dto.setFirstName(entity.getFirstName());
    // dto.setRankid(entity.getRank().getId());

    // return dto;
    // }

}
