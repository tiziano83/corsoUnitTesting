package com.example.unittesting.unittesting;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessService {

    @Autowired
    private ItemRepository itemRepository;

    public Item retrieveHardCodedItem() {
        return new Item(1,"Ball",10,100);

    }

    public List<Item> retrieveAll(){

        List<Item> items = itemRepository.findAll();

        for (Item item : items) {
            item.setValue(item.getPrice()*item.getQuantity());
        }
        return items;
    }
}
