package com.learningprojects.bootstrap;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learningprojects.domain.Beer;
import com.learningprojects.repositories.BeerRepository;

@Component
public class BeerLoader implements CommandLineRunner {
// this class will be run every time the spring context starts because of CommandLineRunner
	@Autowired
	private BeerRepository beerRepository;

	private final Logger logger = LogManager.getLogger();

	@Override
	public void run(String... args) throws Exception {
		loadBeerObjects();
	}

	private void loadBeerObjects() {
		if (beerRepository.count() == 0) {
			beerRepository.save(Beer.builder().beerName("Mango Bobs").beerStyle("IPA").quantityToBrew(200).minOnHand(12)
					.upc(337010000001L).price(new BigDecimal("12.95")).build());

			beerRepository.save(Beer.builder().beerName("Galaxy Cat").beerStyle("PALE_ALE").quantityToBrew(200)
					.minOnHand(12).upc(337010000002L).price(new BigDecimal("11.95")).build());
		}

		logger.info("=> Loaded Beers: " + beerRepository.count());
	}

}
