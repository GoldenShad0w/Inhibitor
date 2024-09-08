package goldenshadow.inhibitor.client;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;


@Config(name = "inhibitor")
public class GooberConfig implements ConfigData {

    public static GooberConfig INSTANCE;
    public boolean stopPartyScraping = false;
    public boolean stopFriendScraping = false;
    public boolean stopCompassScraping = false;
    public boolean stopContentBookScraping = false;

    public static void init() {
        ConfigHolder<GooberConfig> holder = AutoConfig.register(GooberConfig.class, JanksonConfigSerializer::new);
        INSTANCE = holder.getConfig();
    }


}
