package com.zenika.csd.twitter.service;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.zenika.csd.twitter.TwitterApplication;
import com.zenika.csd.twitter.model.Item;
import com.zenika.csd.twitter.service.ItemService;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TwitterApplication.class)
@WebAppConfiguration
@IntegrationTest
@Transactional
public class ItemServiceIntTest {
	
	@Inject
	private ItemService itemService;
	
	private Item item;
	
	@Before
	public void before(){
		item = new Item();
		item.setChecked(true);
		item.setDescription("ma description test");
	}
	
	@Test
	public void testSaveItem(){
		Item savedItem = itemService.save(item);
		
		assertThat(savedItem.getId()).isNotNull();
		assertThat(savedItem.getDescription()).isEqualTo("ma description test");
		assertThat(savedItem.isChecked()).isTrue();		
	}
	
	@Test
	public void testUpdateItem(){
		Item savedItem = itemService.save(item);
		
		assertThat(savedItem.getId()).isNotNull();
		assertThat(savedItem.getDescription()).isEqualTo("ma description test");
		
		savedItem.setDescription("ma description mise à jour");
		savedItem.setChecked(false);
		Item updatedItem = itemService.save(savedItem);
		assertThat(updatedItem.getDescription()).isEqualTo("ma description mise à jour");
		assertThat(updatedItem.isChecked()).isFalse();
	}
	
	@Test
	public void testDeleteItem(){
		Item savedItem = itemService.save(item);
		List<Item> items = itemService.findAll();
		
		assertThat(items.size()).isEqualTo(1);
		
		itemService.delete(savedItem.getId());
		items = itemService.findAll();
		
		assertThat(items.size()).isEqualTo(0);
	}

}
