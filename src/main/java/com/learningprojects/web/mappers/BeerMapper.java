package com.learningprojects.web.mappers;

import org.mapstruct.Mapper;

import com.learningprojects.domain.Beer;
import com.learningprojects.web.model.BeerDto;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {
	BeerDto beerToBeerDto(Beer beer);

	Beer beerDtoToBeer(BeerDto beerDto);
}
