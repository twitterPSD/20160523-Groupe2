package twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import twitter.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
