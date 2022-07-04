package woodp1anks.liquidclient.config.configs;

import woodp1anks.liquidclient.config.Config;

public class MiscsConfig extends Config {
    public MiscsConfig() {
        super("Miscs");
    }

    @Override
    public void syncStop() {
        set("firstPlay","false");
    }
}
