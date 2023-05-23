package com.learningprojects.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learningprojects.services.BeerService;
import com.learningprojects.web.model.BeerDto;
import com.learningprojects.web.model.BeerStyleEnum;

@WebMvcTest
class BeerControllerTest {
	@Autowired
	MockMvc mockMvc;

	@MockBean
	BeerService beerService;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	void testGetBeerById() throws Exception {
		mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	void testSaveNewBeer() throws Exception {
		BeerDto beerDto = getValidBeerDto();
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);
		mockMvc.perform(post("/api/v1/beer").contentType(MediaType.APPLICATION_JSON).content(beerDtoJson))
				.andExpect(status().isCreated());
	}

	@Test
	void testUpdateBeerById() throws Exception {
		BeerDto beerDto = getValidBeerDto();
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);
		mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString()).contentType(MediaType.APPLICATION_JSON)
				.content(beerDtoJson)).andExpect(status().isNoContent());
	}

	BeerDto getValidBeerDto() {
		return BeerDto.builder().beerName("My Beer").beerStyle(BeerStyleEnum.PALE_ALE).price(new BigDecimal("2.99"))
				.upc(123123123123L).build();
	}
}
