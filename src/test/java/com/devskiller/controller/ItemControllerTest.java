package com.devskiller.controller;

import com.devskiller.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.util.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @Test
    public void providesRestEndpointAndReturnsTitlesBasedOnServiceLayer() throws Exception {
        String title = "title1";
        given(itemService.getTitlesWithAverageRatingLowerThan(10.0)).willReturn(newArrayList(title));
        this.mockMvc.perform(get("/titles?rating=10.0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(title)));
    }
}