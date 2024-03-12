package com.deepak.advance_assignment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ranks")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class RankEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "rankdesc", length = 100)
    private String rankDescription;

    @Column(name = "parentrankid")
    private Integer parentRankId;
}
