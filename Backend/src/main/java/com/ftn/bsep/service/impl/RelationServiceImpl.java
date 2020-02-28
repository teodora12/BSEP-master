package com.ftn.bsep.service.impl;

import com.ftn.bsep.model.Certificate;
import com.ftn.bsep.model.Relation;
import com.ftn.bsep.model.State;
import com.ftn.bsep.model.User;
import com.ftn.bsep.repository.CertificateRepository;
import com.ftn.bsep.repository.RelationRepository;
import com.ftn.bsep.repository.UserRepository;
import com.ftn.bsep.service.RelationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Log4j2
public class RelationServiceImpl implements RelationService {

    @Autowired
    private RelationRepository relationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CertificateRepository certificateRepository;


    @Override
    public List<User> allowedRelationsForCertificateOwner(Long id) {

        Certificate certificate = this.certificateRepository.findCertificateById(id);

        User user = certificate.getUser();
        List<User> allowedRelations = new ArrayList<>();
        List<Relation> relations = this.relationRepository.findAllByFirstUserIdOrSecondUserId(user.getId(), user.getId());

        for (Relation relation : relations) {
            if (user.getId() != relation.getFirstUserId()) {
                allowedRelations.add(this.userRepository.findUserById(relation.getFirstUserId()));
            } else {
                allowedRelations.add(this.userRepository.findUserById(relation.getSecondUserId()));
            }
        }

        return allowedRelations;
    }

    @Override
    public List<User> notInRelationWithCertificateOwner(Long id) {

        Certificate certificate = this.certificateRepository.findCertificateById(id);
        User user = certificate.getUser();

       // List<Certificate> certificates = this.certificateRepository.

        List<Relation> relations = this.relationRepository.findAllByFirstUserIdOrSecondUserId(user.getId(), user.getId());

        List<User> notInRelation = new ArrayList<>();

        List<User> allUsers = this.userRepository.findAll();
        for (User u : allUsers) {
            boolean contains = false;
            if (u.getId() == user.getId()) {    // da onemoguci vezu sam sa sobom
                continue;
            }
            for (Relation relation : relations) {
                // da li se user u nalazi u nekoj od postojecih relacija
                if ((relation.getFirstUserId() == u.getId() || relation.getSecondUserId() == u.getId())) {
                    contains = true;        // ako se nalazi u postojecim vezama datog usera
                    break;
                }
            }
            if (!contains) {
                List<Certificate> certificatesForUser = this.certificateRepository.findCertificateByIssuedToAndState
                        (u.getEmail(), State.valid);
                if (!certificatesForUser.isEmpty()) {
                    notInRelation.add(u);
                }
            }
        }
        return notInRelation;
    }

    @Override
    public Relation newRelation(Relation relation) {
        relation.setFirstUserId(this.certificateRepository.findCertificateById(relation.getFirstUserId()).getUser().getId());

        log.info("Allowed relation for users with ids: "+ relation.getFirstUserId()+" and "+ relation.getSecondUserId());
        return this.relationRepository.save(relation);
    }

    @Override
    public boolean deleteRelation(Relation relation) {

        // u first user id je id od sertifikata

        Certificate certificate = this.certificateRepository.findCertificateById(relation.getFirstUserId());
        relation.setFirstUserId(certificate.getUser().getId());

        List<Relation> relToDelete = this.relationRepository.
                findRelationByFirstAndSecond(relation.getFirstUserId(), relation.getSecondUserId());

        try{
            for (Relation r : relToDelete ) {
                this.relationRepository.delete(r);
            }
            log.info("Deleted relation allowance for users with ids: "+ relation.getFirstUserId()+" and "+ relation.getSecondUserId());
            return true;
        } catch (Exception e) {
            log.error("Error while deleting relations between users with ids: "+ relation.getFirstUserId()+" and "+ relation.getSecondUserId());
            return false;
        }
    }
}
