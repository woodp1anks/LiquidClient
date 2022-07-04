package woodp1anks.liquidclient.config.configs.render;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import woodp1anks.liquidclient.LiquidClient;
import woodp1anks.liquidclient.config.Config;
import woodp1anks.liquidclient.mod.mods.render.AntiBlind;
import woodp1anks.liquidclient.mod.mods.render.ArrayList;

import java.awt.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ArrayListConfig extends Config {
    public ArrayListConfig() {
        super("ArrayList");
    }

    @Override
    public void syncStart() {
        ArrayList arrayList = (ArrayList) LiquidClient.modManager.getMod("ArrayList");
        arrayList.setStartStr(get("startstr"," - "));
        arrayList.setMiddleStr(get("middlestr",", "));
        arrayList.setEndStr(get("endstr",""));
        arrayList.setArgsR(Integer.parseInt(get("argsr", String.valueOf(Color.LIGHT_GRAY.getRed()))));
        arrayList.setArgsG(Integer.parseInt(get("argsg", String.valueOf(Color.LIGHT_GRAY.getGreen()))));
        arrayList.setArgsB(Integer.parseInt(get("argsb", String.valueOf(Color.LIGHT_GRAY.getBlue()))));
    }

    @Override
    public void syncStop() {
        ArrayList arrayList = (ArrayList) LiquidClient.modManager.getMod("ArrayList");
        set("startstr",arrayList.getStartStr());
        set("middlestr",arrayList.getMiddleStr());
        set("endstr",arrayList.getEndStr());
        set("argsr", String.valueOf(arrayList.getArgsR()));
        set("argsg", String.valueOf(arrayList.getArgsG()));
        set("argsb", String.valueOf(arrayList.getArgsB()));
    }
}
