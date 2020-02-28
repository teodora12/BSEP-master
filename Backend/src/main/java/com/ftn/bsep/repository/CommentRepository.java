package com.ftn.bsep.repository;

import com.ftn.bsep.model.CommentForDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentForDatabase, Long> {
}