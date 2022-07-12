package woodp1anks.liquidclient.config.configs;

import woodp1anks.liquidclient.LiquidClient;
import woodp1anks.liquidclient.config.Config;
import woodp1anks.liquidclient.target.TargetManager;

public class TargetConfig extends Config {
    public TargetConfig() {
        super("Target");
    }

    @Override
    public void syncStart() {
        TargetManager targetManager = LiquidClient.targetManager;
        targetManager.setDisablePracticeBot(Boolean.parseBoolean(get("disablepracticebot", String.valueOf(true))));
    }

    @Override
    public void syncStop() {
        TargetManager targetManager = LiquidClient.targetManager;
        set("disablepracticebot", String.valueOf(targetManager.isDisablePracticeBot()));
    }
}
