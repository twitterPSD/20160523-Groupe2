package com.zenika.csd.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenika.csd.twitter.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
