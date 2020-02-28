package com.ftn.bsep.service;


import com.ftn.bsep.model.CommentForDatabase;
import com.ftn.bsep.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    CommentForDatabase findOne(Long id);
    List<CommentForDatabase> findAll();
    List<CommentForDatabase> findApprovedComments();
    List<CommentForDatabase> findWaitingComments();
    List<CommentForDatabase> findUserComments(User user);
    List<CommentForDatabase> findApartmentComments(Long id);
    CommentForDatabase save(CommentForDatabase comment);
    void delete(CommentForDatabase comment);
    List<CommentForDatabase> findApartmentApprovedComments(Long id);
    CommentForDatabase findByUserAndApartment(Long id, Long id2);
}