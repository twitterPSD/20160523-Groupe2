package twitter.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import twitter.model.Item;
import twitter.repository.ItemRepository;
import twitter.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
	
	private final Logger log = LoggerFactory.getLogger(ItemServiceImpl.class);
	
	@Inject
	private ItemRepository itemRepository;

	/* (non-Javadoc)
	 * @see twitter.service.ItemService#findAll()
	 */
	@Override
	public List<Item> findAll() {
		log.debug("Request to get all items");
		List<Item> items = itemRepository.findAll();
		return items;
	}

	/* (non-Javadoc)
	 * @see twitter.service.ItemService#save(twitter.model.Item)
	 */
	@Override
	public Item save(Item item) {
		log.debug("Request to save Item : {}",item);
		Item savedItem = itemRepository.saveAndFlush(item);
		return savedItem;
	}

	/* (non-Javadoc)
	 * @see twitter.service.ItemService#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id) {
		log.debug("Request to delete Item : {}",id);
		itemRepository.delete(id);
		
	}

}
