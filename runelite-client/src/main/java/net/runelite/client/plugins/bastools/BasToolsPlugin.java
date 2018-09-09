package net.runelite.client.plugins.bastools;

import com.google.common.collect.ObjectArrays;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MessageNode;
import net.runelite.api.Skill;
import net.runelite.api.events.BoostedLevelChanged;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.SetMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

import javax.inject.Inject;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@PluginDescriptor(
        name = "BasTools"
)

@Slf4j
public class BasToolsPlugin extends Plugin
{
    @Inject
    private Client client;

    @Inject
    private InfoBoxManager infoBoxManager;

    @Inject
    private BasToolsConfig config;

    @Provides
    BasToolsConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(BasToolsConfig.class);
    }


    @Subscribe
    public void onSetMessage(SetMessage setMessage) {
        if (client.getGameState() != GameState.LOGGED_IN) {
            return;
        }

        switch (setMessage.getType()) {
            case PUBLIC:
            case CLANCHAT:
            case PRIVATE_MESSAGE_SENT:
                break;
            case PRIVATE_MESSAGE_RECEIVED:
            default:
                return;
        }

        String message = setMessage.getValue();
        MessageNode messageNode = setMessage.getMessageNode();

        // clear RuneLite formatted message as the message node is
        // being reused
        messageNode.setRuneLiteFormatMessage(null);

        if (message.toLowerCase().equals("!ignore")) {

            BufferedWriter bw=null;
            try {
                bw = new BufferedWriter(new FileWriter(Long.toString(System.nanoTime())+".txt", true));
                bw.newLine();
                bw.write("test");
                bw.flush();
            }catch (IOException e){

            } finally {
                if(bw!=null) try{
                    bw.close();
                } catch (IOException e2){

                }
            }
        }
    }
}