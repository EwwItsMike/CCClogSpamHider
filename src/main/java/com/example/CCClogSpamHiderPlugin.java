package com.example;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

@Slf4j
@PluginDescriptor(
	name = "CC Clog Spam Hider"
)
public class CCClogSpamHiderPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private CCClogSpamHiderConfig config;

	@Provides
	CCClogSpamHiderConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CCClogSpamHiderConfig.class);
	}

	private final String ccClogMessage = "received a new collection log item:";
	private final ArrayList<String> fossilNotes = new ArrayList<String>(Arrays.asList("Scribbled note", "Partial note", "Ancient note", "Ancient writings", "Experimental note", "Paragraph of text", "Musty smelling note", "Hastily scrawled note", "Old writing", "Short note"));



	//Source: ChatFilter plugin
	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent event){
		if (!event.getEventName().equals("chatFilterCheck")) return;

		int[] intStack = client.getIntStack();
		int intStackSize = client.getIntStackSize();
		String[] stringStack = client.getStringStack();
		int stringStackSize = client.getStringStackSize();


		final int messageType = intStack[intStackSize - 2];
		String message = stringStack[stringStackSize - 1];
		ChatMessageType chatMessageType = ChatMessageType.of(messageType);

		if (chatMessageType != ChatMessageType.CLAN_MESSAGE
				|| !message.toLowerCase(Locale.ROOT).contains(ccClogMessage)){
			return;
		}

		boolean spam = false;

		if (config.fossilNotes() && !spam)
		{
			for (String s : fossilNotes){
				if (message.contains(s)){
					spam = true;
//					System.out.println("[DEBUG] Message contains fossil island note");
					break;
				}
			}
		}
		if (config.chompyHats() && !spam){
			if (message.contains("Chompy bird hat"))
//				System.out.println("[DEBUG] Message contains chompy bird hat");
				spam = true;
		}

		if (spam){
//			System.out.println("[DEBUG] Blocking CC clog spam");
			intStack[intStackSize - 3] = 0;
		}

	}

}
