package com.ftn.agent.restService;

import com.ftn.agent.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

    List<Item> saveAll(List<Item> items);
    Item findItemById(Long id);
}
