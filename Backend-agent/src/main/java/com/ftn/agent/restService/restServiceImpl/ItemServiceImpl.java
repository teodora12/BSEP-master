package com.ftn.agent.restService.restServiceImpl;

import com.ftn.agent.model.Item;
import com.ftn.agent.repository.ItemRepository;
import com.ftn.agent.restService.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
     private ItemRepository itemRepository;

    @Override
    public List<Item> saveAll(List<Item> items) {

        return itemRepository.saveAll(items);
    }

    @Override
    public Item findItemById(Long id) {
        return this.itemRepository.findItemById(id);
    }
}
