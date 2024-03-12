package com.deepak.advance_assignment.entity;

import java.util.Date;
import java.util.Optional;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "empid", nullable = false, unique = true)
    private String empId;

    @Column(name = "fname", nullable = false)
    private String firstName;

    @Column(name = "fullname", nullable = false)
    private String fullName;

    @Column(name = "dob", nullable = false)
    private Date dateOfBirth;

    @Column(name = "doj", nullable = false)
    private Date dateOfJoining;

    @Column(name = "salary", nullable = false)
    private int salary;

    @Column(name = "reportsto")
    private Long reportsTo;

    @ManyToOne
    @JoinColumn(name = "deptid")
    private DepartmentEntity department;

    @ManyToOne
    @JoinColumn(name = "rankid")
    private RankEntity rank;

    @Column(name = "createdat", nullable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updatedat")
    @UpdateTimestamp
    private Date updatedAt;

    @Column(name = "client_reqid", nullable = false)
    private String clientReqId;
}
