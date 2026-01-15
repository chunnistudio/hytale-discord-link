# Initial setup

In order for this mod to work you will need to

- Create a private discord bot
- Create a Discord channel webhook

This guide will teach you how to do that

## Install mod

Copy the mod's jar file into /path/to/your/server/mods

Start the server and then it will create a file called **hytale-discord-link.properties**, it will looks something like this

````
bot.token=your-bot-token-here
channel.id=your-id-channel-here
webhook.url=your-webhook-url-here
````

Stop the server and modify the properties file with the information request, here below you can learn how to get such information

# Setup your own Discord Bot

To get your Discord bot token, you will need to create a bot first, for that, enter the [Discord developer portal](https://discord.com/developers/applications)
and create a new application

After this, go to the Installation option and at Install Link select None

![Installation](img/discord-mod-installation.png)

Now, go to Bot option and make your bot private by turning off the public bot option
![Public bot](img/discord-mod-auth-flow.png)

At the bottom, turn on all the Privilege Gateway Intents
![Gateway Intents](img/discord-mod-gateway-intents.png)



# How to invite the bot to my server

Go to Discord Developer Portal, enter the OAuth2 option and copy the Client ID

![client id](img/discord-mod-clientid.png)

Go to this website https://discordapi.com/permissions.html

Check Send Messages at the Text Permissions column and enter the Client ID at the bottom.

Copy the generated link at the bottom of the page, that will let you invite your bot the your server

# How to get Bot's token

To get your Token, go to Bot option and press Reset Token, that will show you a new Token, copy that token and
put it in the mod's config file

![Token](img/discord-mod-tokenpng.png)

# How to get Channel ID

You need to have Developer Mode activate in your Discord

Go to Configuration > Advanced and activate Developer Mode 

![Developer Mode](img/discord-devmode.png)

Then, create a new Text channel, ***Make sure the bot have the roles needed in your server to see the new text channel***

After that, right-click the text channel and there will be an option to copy th Channel ID

![Channel Id](img/discord-channelid.png)

Copy that and put it inside th mod config's file

# How to get your channel Webhook

Select "Edit Channel" in the channel that will be used

![Channel Edit](img/discord-webhook-edit.png)

Then, select Integrations, and then Webhooks

![Channel webhooks](img/discord-webhook-integration.png)

Then create a new Webhook, and finally clock on the Webhook created and click "Copy webhook url"

![Channel webhook url](img/discord-webhook-url.png)

Finally copy the url into the config's file

