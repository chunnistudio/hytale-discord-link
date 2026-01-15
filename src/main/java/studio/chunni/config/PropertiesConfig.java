package studio.chunni.config;

import studio.chunni.constants.ModConstants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesConfig {

    private static Properties properties = new Properties();
    private static File propertiesFile = new File("mods/hytale-discord-link.properties");

    public static void loadOrCreate() {
        if(!propertiesFile.exists()) {
            createDefault();
        }
        try( FileInputStream reader = new FileInputStream(propertiesFile)) {
            properties.load(reader);
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }

    private static void createDefault() {
        try {
            boolean isCreated = propertiesFile.createNewFile();
            if(isCreated) {
                FileWriter writer = new FileWriter("mods/hytale-discord-link.properties");
                writer.write("bot.token=".concat(ModConstants.BOT_TOKEN).concat("\n"));
                writer.write("channel.id=".concat(ModConstants.CHANNEL_ID).concat("\n"));
                writer.write("webhook.url=".concat(ModConstants.WEBHOOK_URL).concat("\n"));
                writer.close();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
