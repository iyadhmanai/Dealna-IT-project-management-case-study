package com.dealna.api.marketplace;

import java.util.List;

public record MarketplaceStatus(
	String product,
	String phase,
	List<String> stack,
	List<String> capabilities
) {
}
