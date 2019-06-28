package com.example.unittesting.unittesting;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item,Integer> {
}
