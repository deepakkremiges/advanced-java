package com.remiges.advanced_java.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Data
@Getter
@Setter
public class Employee {

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
    private Department department;

    @ManyToOne
    @JoinColumn(name = "rankid")
    private Rank rank;

    @Column(name = "createdat", nullable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updatedat")
    @UpdateTimestamp
    private Date updatedAt;

    @Column(name = "client_reqid", nullable = false)
    @UuidGenerator
    private String clientReqId;

    // No-args constructor for JPA
    public Employee() {
    }

    // Parameterised Constructor
    public Employee(Long id, String empId, String firstName, String fullName, Date dateOfBirth, Date dateOfJoining,
            int salary) {
        // Long reportsTo, Date createdAt, Date updatedAt, String clientReqId) {
        this.id = id;
        this.empId = empId;
        this.firstName = firstName;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
        // this.reportsTo = reportsTo;
        // this.createdAt = createdAt;
        // this.updatedAt = updatedAt;
        // this.clientReqId = clientReqId;
    }

    public String getName() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getName'");
        return fullName;
    }

    public String getEmpId() {

        return empId;
    }

}
