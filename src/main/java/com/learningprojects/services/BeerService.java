package com.learningprojects.services;

import java.util.UUID;

import com.learningprojects.web.model.BeerDto;

public interface BeerService {

	BeerDto getById(UUID beerId);

	BeerDto saveNewBeer(BeerDto beerDto);

	BeerDto updateBeerById(UUID beerId, BeerDto beerDto);

}
