package com.dealna.api.marketplace;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
class MarketplaceController {

	@GetMapping("/status")
	MarketplaceStatus status() {
		return new MarketplaceStatus(
			"Dealna",
			"Implementation foundation: Angular frontend and Spring Boot API",
			List.of(
				"Angular 22",
				"Spring Boot 4.1",
				"Java 17",
				"PostgreSQL",
				"Flyway",
				"Spring Security"
			),
			List.of(
				"Public marketplace shell",
				"MVP category metadata",
				"API health foundation",
				"Security-ready backend"
			)
		);
	}

	@GetMapping("/categories")
	List<CategorySummary> categories() {
		return List.of(
			new CategorySummary("restaurants-cafes", "Restaurants and cafes", 1, 40),
			new CategorySummary("beauty-grooming", "Beauty and grooming", 2, 25),
			new CategorySummary("entertainment", "Entertainment and experiences", 3, 15),
			new CategorySummary("fitness-wellness", "Fitness and wellness", 4, 10),
			new CategorySummary("hotels-staycations", "Hotels and staycations", 5, 10)
		);
	}
}
