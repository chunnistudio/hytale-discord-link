package studio.chunni.discord;

import club.minnced.discord.webhook.WebhookClient;
import club.minnced.discord.webhook.send.WebhookMessageBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import studio.chunni.listener.DiscordListener;

public class DiscordBridge {

    private static WebhookClient webhookClient;
    private static JDA jda;

    public static void start(String botToken) {
        try {
            jda = JDABuilder.createDefault(botToken)
                    .addEventListeners(new DiscordListener())
                    .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                    .build();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startWebhook(String url) {
        try {
            System.out.println("[DiscordBridge] Starting Webhook with URL: " + url);
            webhookClient = WebhookClient.withUrl(url);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendToDiscordWebhook(String message, String name, String avatarUrl) {
        webhookClient.send(
                new WebhookMessageBuilder()
                        .setUsername(name)
                        //.setAvatarUrl(avatarUrl)
                        .setContent(message)
                        .build()
        );
    }


}
