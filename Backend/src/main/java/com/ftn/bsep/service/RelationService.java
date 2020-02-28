package com.ftn.bsep.service;

import com.ftn.bsep.model.Relation;
import com.ftn.bsep.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RelationService {

    List<User> allowedRelationsForCertificateOwner(Long id);
    List<User> notInRelationWithCertificateOwner(Long id);
    Relation newRelation(Relation relation);
    boolean deleteRelation(Relation relation);
}
