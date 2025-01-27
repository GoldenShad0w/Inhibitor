package goldenshadow.inhibitor.client;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;


@Config(name = "inhibitor")
public class InhibitorConfig implements ConfigData {

    public boolean stopPartyScraping = false;
    public boolean stopFriendScraping = false;
    public boolean stopCompassScraping = false;
    public boolean stopContentBookScraping = false;
    public boolean stopHadesConnection = false;
    public boolean stopAthenaConnection = false;
    public boolean gnomeMode = false;

    public static void init() {
        ConfigHolder<InhibitorConfig> holder = AutoConfig.register(InhibitorConfig.class, JanksonConfigSerializer::new);
    }


}
