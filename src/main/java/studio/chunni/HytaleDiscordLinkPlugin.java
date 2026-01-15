package studio.chunni;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.protocol.packets.interface_.ServerMessage;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import studio.chunni.chatevent.PlayerChatEventHandler;
import studio.chunni.config.PropertiesConfig;
import studio.chunni.discord.DiscordBridge;

import javax.annotation.Nonnull;

public class HytaleDiscordLinkPlugin extends JavaPlugin {

    public HytaleDiscordLinkPlugin(@Nonnull JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {

        PropertiesConfig.loadOrCreate();
        String botToken = PropertiesConfig.get("bot.token");
        String channelId = PropertiesConfig.get("channel.id");
        String webhookUrl = PropertiesConfig.get("webhook.url");

        if(botToken == null || botToken.isEmpty()) {
            System.out.println("Error, bot token missinng");
            return;
        }

        if(channelId == null || channelId.isEmpty()) {
            System.out.println("Error, channel id missinng");
            return;
        }

        if(webhookUrl == null || webhookUrl.isEmpty()) {
            System.out.println("Error, webhook url missinng");
            return;
        }

        DiscordBridge.start(botToken);
        DiscordBridge.startWebhook(webhookUrl);
        new PlayerChatEventHandler().registryEvent(this.getEventRegistry());
    }




}
