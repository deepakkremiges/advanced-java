package com.deepak.advance_assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deepak.advance_assignment.entity.RankEntity;

@Repository
public interface RankRepository extends JpaRepository<RankEntity, Long> {

}
