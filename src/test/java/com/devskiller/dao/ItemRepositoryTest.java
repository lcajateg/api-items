package com.devskiller.dao;

import com.devskiller.model.Item;
import com.devskiller.model.Review;
import com.devskiller.model.User;

import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldReturnItemsWithAverageRating() {
        assertThat(itemRepository.findItemsWithAverageRatingLowerThan(10.0)).hasSize(10);
        assertThat(itemRepository.findItemsWithAverageRatingLowerThan(1.0)).hasSize(1);
    }

    @Before
    public void prepareData() {
        User user = new User(RandomString.make(5));
        userRepository.save(user);
        for (int i = 0; i < 15; i++) {
            Item item = new Item("title " + i, "description");
            item.addReview(new Review((double) Math.min(i, 10), "Review " + i + "/1", user));
            item.addReview(new Review((double) (i < 10 ? i + 1 : 10), "Review " + i + "/2", user));
            itemRepository.save(item);
        }
    }
}