package com.learningprojects.services;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import com.learningprojects.domain.Beer;
import com.learningprojects.repositories.BeerRepository;
import com.learningprojects.web.controller.NotFoundException;
import com.learningprojects.web.mappers.BeerMapper;
import com.learningprojects.web.model.BeerDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {
	private final BeerRepository beerRepository;
	private final BeerMapper beerMapper;

	@Override
	public BeerDto getById(UUID beerId) {
		return beerMapper.beerToBeerDto(beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {
		return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
	}

	@Override
	public BeerDto updateBeerById(UUID beerId, BeerDto beerDto) {
		Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);
		beer.setBeerName(beerDto.getBeerName());
		beer.setBeerStyle(beerDto.getBeerStyle().name());
		beer.setPrice(beerDto.getPrice());
		beer.setUpc(beerDto.getUpc());
		return beerMapper.beerToBeerDto(beerRepository.save(beer));
	}

}
