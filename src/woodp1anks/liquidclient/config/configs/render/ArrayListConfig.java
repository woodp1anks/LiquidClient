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
    public void load() {
        JsonObject jsonObject = null;
        try {
            jsonObject = new Gson().fromJson(new String(Files.readAllBytes(getPath()), StandardCharsets.UTF_8), JsonObject.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList arrayList = (ArrayList) LiquidClient.modManager.getMod("ArrayList");
        try {
            if (jsonObject.has("startstr")) {
                arrayList.setStartStr(jsonObject.get("startstr").getAsString());
            } else {arrayList.setStartStr(" - ");}
            if (jsonObject.has("middlestr")) {
                arrayList.setMiddleStr(jsonObject.get("middlestr").getAsString());
            } else {arrayList.setMiddleStr(" ");}
            if (jsonObject.has("endstr")) {
                arrayList.setEndStr(jsonObject.get("endstr").getAsString());
            } else {arrayList.setEndStr("");}
            if (jsonObject.has("argsr")) {
                arrayList.setArgsR(jsonObject.get("argsr").getAsInt());
            } else {arrayList.setArgsR(Color.LIGHT_GRAY.getRed());}
            if (jsonObject.has("argsg")) {
                arrayList.setArgsG(jsonObject.get("argsg").getAsInt());
            } else {arrayList.setArgsG(Color.LIGHT_GRAY.getGreen());}
            if (jsonObject.has("argsb")) {
                arrayList.setArgsB(jsonObject.get("argsb").getAsInt());
            } else {
                arrayList.setArgsB(Color.LIGHT_GRAY.getBlue());
            }
        } catch (UnsupportedOperationException ex) {
            arrayList.setStartStr(" - ");
            arrayList.setMiddleStr(" ");
            arrayList.setEndStr("");
            arrayList.setArgsR(Color.LIGHT_GRAY.getRed());
            arrayList.setArgsG(Color.LIGHT_GRAY.getGreen());
            arrayList.setArgsB(Color.LIGHT_GRAY.getBlue());
        }
    }

    @Override
    public void save() {
        JsonObject jsonObject = new JsonObject();
        ArrayList arrayList = (ArrayList) LiquidClient.modManager.getMod("ArrayList");
        jsonObject.addProperty("startstr",arrayList.getStartStr());
        jsonObject.addProperty("middlestr",arrayList.getMiddleStr());
        jsonObject.addProperty("endstr",arrayList.getEndStr());
        jsonObject.addProperty("argsr",arrayList.getArgsR());
        jsonObject.addProperty("argsg",arrayList.getArgsG());
        jsonObject.addProperty("argsb",arrayList.getArgsB());
        try {
            Files.write(getPath(),jsonObject.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
