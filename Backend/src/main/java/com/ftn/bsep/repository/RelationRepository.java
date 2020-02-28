package com.ftn.bsep.repository;

import com.ftn.bsep.model.Relation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RelationRepository extends JpaRepository<Relation, Long> {

    Relation findRelationById(Long id);
    List<Relation> findAllByFirstUserIdOrSecondUserId(Long id, Long id1);
    @Query("select r from Relation r where ((r.firstUserId = ?1 and r.secondUserId = ?2 ) or (r.secondUserId = ?1 or r.firstUserId = ?2))")
    List<Relation> findRelationByFirstAndSecond(Long first, Long second);
}
