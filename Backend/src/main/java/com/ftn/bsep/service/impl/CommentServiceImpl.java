package com.ftn.bsep.service.impl;

import com.ftn.bsep.model.AccommodationForDatabase;
import com.ftn.bsep.model.CommentForDatabase;
import com.ftn.bsep.model.User;
import com.ftn.bsep.repository.AccommodationRepository;
import com.ftn.bsep.repository.CommentRepository;
import com.ftn.bsep.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository repository;

    @Autowired
    AccommodationRepository accommodation;

    @Override
    public CommentForDatabase findOne(Long id) {
        for (CommentForDatabase CommentForDatabase : repository.findAll()) {
            if (CommentForDatabase.getId() == id) {
                return CommentForDatabase;
            }
        }
        return null;
    }

    @Override
    public List<CommentForDatabase> findAll() {
        return repository.findAll();
    }

    @Override
    public List<CommentForDatabase> findApprovedComments() {
        List<CommentForDatabase> approvedCommentForDatabases = new ArrayList<>();
        for (CommentForDatabase CommentForDatabase : findAll()) {
            if (CommentForDatabase.getStatus().equals("approved")) {
                approvedCommentForDatabases.add(CommentForDatabase);
            }
        }
        return approvedCommentForDatabases;
    }

    @Override
    public List<CommentForDatabase> findApartmentApprovedComments(Long id) {
        List<CommentForDatabase> approvedCommentForDatabases = new ArrayList<CommentForDatabase>();
        for (CommentForDatabase CommentForDatabase : findApartmentComments(id)) {
            if (CommentForDatabase.getStatus().equals("approved")) {
                approvedCommentForDatabases.add(CommentForDatabase);
            }
        }
        return approvedCommentForDatabases;
    }

    @Override
    public CommentForDatabase findByUserAndApartment(Long apartmentId, Long userId) {
        for (CommentForDatabase CommentForDatabase : findApartmentComments(apartmentId)) {
            System.out.println(CommentForDatabase);
            if (CommentForDatabase.getUser().getId() == userId) {
                return CommentForDatabase;
            }
        }
        return null;
    }

    @Override
    public List<CommentForDatabase> findWaitingComments() {
        List<CommentForDatabase> waitingCommentForDatabases = new ArrayList<CommentForDatabase>();
        for (CommentForDatabase CommentForDatabase : findAll()) {
            if (CommentForDatabase.getStatus().equals("waiting")) {
                waitingCommentForDatabases.add(CommentForDatabase);
            }
        }
        return waitingCommentForDatabases;
    }

    @Override
    public List<CommentForDatabase> findUserComments(User user) {
        List<CommentForDatabase> userCommentForDatabases = new ArrayList<CommentForDatabase>();
        for (CommentForDatabase CommentForDatabase : findAll()) {
            if (CommentForDatabase.getUser().getId() == user.getId()) {
                userCommentForDatabases.add(CommentForDatabase);
            }
        }
        return userCommentForDatabases;
    }

    @Override
    public List<CommentForDatabase> findApartmentComments(Long id) {
        //TODO findbyId of accomodatioom and find all comments


   /*AccommodationForDatabase a=accommodation.findById(id);
        return  a.getComments();*/
        return null;
    }

    @Override
    public CommentForDatabase save(CommentForDatabase comment) {
        return repository.save(comment);
    }

    @Override
    public void delete(CommentForDatabase comment) {


        repository.delete(comment);
    }
}