package com.adytechmc.nodurability;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoDurability implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("nodurability");

	@Override
	public void onInitialize() {
		LOGGER.info("Infinite Durability!");
	}
}