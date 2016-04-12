package twitter.service;

import java.util.List;

import twitter.model.Item;

public interface ItemService {

	List<Item> findAll();

	Item save(Item item);

	void delete(Integer id);

}