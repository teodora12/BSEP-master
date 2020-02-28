package com.ftn.bsep.repository;

import com.ftn.bsep.model.modelGenerated.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    void deleteItemById (Long id);
}
