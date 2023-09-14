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
			description = "Hide Fossil island notes Collection log CC broadcasts"
	)
	default boolean fossilNotes(){
		return true;
	}

	@ConfigItem(
			keyName = "chompyHats",
			name = "Hide Chompy hats",
			description = "Hide Chompy bird hats Collection log CC broadcasts"
	)
	default boolean chompyHats(){
		return true;
	}

	@ConfigItem(
			keyName = "castleWars",
			name = "Castle Wars",
			description = "Hide Castle Wars Collection log CC broadcasts "
	)
	default boolean castleWars() { return false; }

	@ConfigItem(
			keyName = "troubleBrewing",
			name = "Trouble Brewing",
			description = "Hide Trouble Brewing Collection log CC broadcasts "
	)
	default boolean troubleBrewing() { return false; }

	@ConfigItem(
			keyName = "agilityArena",
			name = "Agility Arena/Graceful",
			description = "Hide Agility Arena and Graceful Collection log CC broadcasts "
	)
	default boolean agilityArena() { return false; }
}
