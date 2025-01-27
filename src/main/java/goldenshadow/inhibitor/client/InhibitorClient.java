package goldenshadow.inhibitor.client;

import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.ClientModInitializer;

public class InhibitorClient implements ClientModInitializer {

    public static InhibitorConfig CONFIG;

    @Override
    public void onInitializeClient() {
        InhibitorConfig.init();
        CONFIG = AutoConfig.getConfigHolder(InhibitorConfig.class).getConfig();
    }
}
