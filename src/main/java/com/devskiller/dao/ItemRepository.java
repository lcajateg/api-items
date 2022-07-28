package com.devskiller.dao;

import com.devskiller.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
	@Query(value = "SELECT i FROM Item i WHERE (SELECT AVG(r.rating) FROM Review r WHERE r.item = i) < :rating")
	List<Item> findItemsWithAverageRatingLowerThan(@Param("rating") Double rating);
}