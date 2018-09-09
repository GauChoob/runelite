package net.runelite.client.plugins.bastools;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
        keyName = "bastools",
        name = "BasTools",
        description = "hi"
)
public interface BasToolsConfig extends Config
{
    @ConfigItem(
            keyName = "ignoreListPrint",
            name = "IgnorePrint",
            description = "ok",
            position = 1
    )
    default boolean ignoreListPrint()
    {
        return true;
    }
}
