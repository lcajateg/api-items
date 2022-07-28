package com.devskiller.service;

import com.devskiller.dao.ItemRepository;
import com.devskiller.model.Item;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ItemServiceTest {

    private ItemRepository itemRepository = mock(ItemRepository.class);
    private ItemService itemService = new ItemService(itemRepository);

    @Test
    public void returnsTitlesBasedOnItemsFromPersistenceLayer() {
        Double rating = 10.0;
        given(itemRepository.findItemsWithAverageRatingLowerThan(rating))
                .willReturn(newArrayList(new Item("title1", "desc1"), new Item("title2", "desc2")));

        List<String> titles = itemService.getTitlesWithAverageRatingLowerThan(rating);

        assertThat(titles).containsExactly("title1", "title2");
    }

}