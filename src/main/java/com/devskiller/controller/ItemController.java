package com.devskiller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.devskiller.service.ItemService;
import java.util.List;

@RestController
@RequestMapping(value = "api/devskiller/items")
public class ItemController {
	@Autowired
	private ItemService service;

	@GetMapping(value = "/titles/{rating}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<String> getById(@PathVariable Double rating) {
		return service.getTitlesWithAverageRatingLowerThan(rating);
	}

}
