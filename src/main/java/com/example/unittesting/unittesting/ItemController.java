package com.example.unittesting.unittesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService itemBusinessService;


    @GetMapping("/dummy-item")
    public Item dummyItem(){

        return new Item(1,"Ball",10,100);
    }

    @GetMapping("/item-from-business-services")
    public Item itemFromBusinessService(){

        return itemBusinessService.retrieveHardCodedItem();
    }

    @GetMapping("/all-items-from-database")
    public List<Item> getAll(){
        return itemBusinessService.retrieveAll();
    }
}
