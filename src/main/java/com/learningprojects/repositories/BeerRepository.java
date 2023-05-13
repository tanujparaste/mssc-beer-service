package com.learningprojects.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.learningprojects.domain.Beer;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID>, CrudRepository<Beer, UUID> {
// PagingAndSortingRepository doesn't extend CrudRepository in Spring6+,. hence need to add CrudRepository explicitely
}
