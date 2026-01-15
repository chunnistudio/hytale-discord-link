package studio.chunni.chatevent;

import com.hypixel.hytale.event.EventRegistry;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.event.events.player.PlayerChatEvent;
import com.hypixel.hytale.server.core.universe.Universe;
import studio.chunni.discord.DiscordBridge;

public class PlayerChatEventHandler {


    public void registryEvent(EventRegistry eventRegistry) {
        eventRegistry.registerGlobal(PlayerChatEvent.class, this::onPlayerChat);
    }


    public void onPlayerChat(PlayerChatEvent event) {
        DiscordBridge.sendToDiscordWebhook(event.getContent(), event.getSender().getUsername(), "");
    }
}
