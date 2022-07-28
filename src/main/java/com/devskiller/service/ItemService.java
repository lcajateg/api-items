package com.devskiller.service;

import com.devskiller.dao.ItemRepository;
import com.devskiller.model.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public ItemService(ItemRepository itemRepository) {
		super();
		this.itemRepository = itemRepository;
	}

	public List<String> getTitlesWithAverageRatingLowerThan(Double rating) {
		List<String> getTitles = new ArrayList<String>();
		getTitles = itemRepository.findItemsWithAverageRatingLowerThan(rating).stream().map(Item::getTitle)
				.collect(Collectors.toList());
		return getTitles;
	}

}
