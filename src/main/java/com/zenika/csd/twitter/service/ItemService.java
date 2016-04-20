package com.zenika.csd.twitter.service;

import java.util.List;

import com.zenika.csd.twitter.model.Item;

public interface ItemService {

	List<Item> findAll();

	Item save(Item item);

	void delete(Integer id);

}