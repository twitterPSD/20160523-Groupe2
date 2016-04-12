package twitter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import twitter.model.Item;
import twitter.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemResource {

	@Autowired
	private ItemService itemService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Item> findItems() {
		return itemService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Item addItem(@RequestBody Item item) {
		item.setId(null);
		return itemService.save(item);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Item updateItem(@RequestBody Item updatedItem, @PathVariable Integer id) {
		updatedItem.setId(id);
		return itemService.save(updatedItem);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteItem(@PathVariable Integer id) {
		itemService.delete(id);
	}

}
