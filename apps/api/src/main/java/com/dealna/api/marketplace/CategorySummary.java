package com.dealna.api.marketplace;

public record CategorySummary(
	String slug,
	String name,
	int priority,
	int launchShare
) {
}
