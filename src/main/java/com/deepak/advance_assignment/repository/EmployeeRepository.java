package com.deepak.advance_assignment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deepak.advance_assignment.dto.EmployeeDetailsDTO;
import com.deepak.advance_assignment.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    // writing query for problem 9.
    @Query(value = "SELECT * FROM employee WHERE LOWER(fname) LIKE LOWER(CONCAT('%',:filter,'%'))", nativeQuery = true)
    List<EmployeeEntity> findEmployeesByFilter(@Param("filter") String filter);

    // @Query("SELECT new
    // com.deepak.advance_assignment.dto.EmployeeDetailsDTO(e.fullName,
    // r.rankDescription, d.departmentName, s.supervisorName) "
    // +
    // "FROM EmployeeEntity e " +
    // "JOIN e.rank r " +
    // "JOIN e.department d " +
    // "LEFT JOIN e.supervisor s " +
    // "WHERE e.id = :id")
    // Optional<EmployeeDetailsDTO> findEmployeeDetailsById(Long id);
}
