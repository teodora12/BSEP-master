package com.ftn.bsep.service;

import com.ftn.bsep.model.modelGenerated.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

    List<Item> saveAll(List<Item> Items);
    void removeItem(Long id);
    void delete(Item item);
    Item findById(Long id);

}
