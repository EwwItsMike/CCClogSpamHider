package com.example;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("CCClogSpamHider")
public interface CCClogSpamHiderConfig extends Config
{
	@ConfigItem(
			keyName = "fossilNotes",
			name = "Hide Fossil Island Notes",
			description = "Hide the Fossil Island Notes section of the Collection Log"
	)
	default boolean fossilNotes(){
		return true;
	}

	@ConfigItem(
			keyName = "chompyHats",
			name = "Hide Chompy hats",
			description = "Hide the Chompy hats section of the Collection Log"
	)
	default boolean chompyHats(){
		return true;
	}
}
