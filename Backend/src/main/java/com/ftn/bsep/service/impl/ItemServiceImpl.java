package com.ftn.bsep.service.impl;


import com.ftn.bsep.model.modelGenerated.Item;
import com.ftn.bsep.repository.ItemRepository;
import com.ftn.bsep.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> saveAll(List<Item> items) {
        return this.itemRepository.saveAll(items);
    }

    @Override
    public void removeItem(Long id) {
        this.itemRepository.deleteItemById(id);
    }

    @Override
    public void delete(Item i){
        this.itemRepository.delete(i);
    }

    @Override
    public Item findById(Long id){
        for (Item category : itemRepository.findAll()) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }
}
