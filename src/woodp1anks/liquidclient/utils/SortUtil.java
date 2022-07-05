package woodp1anks.liquidclient.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.main.Main;

import java.util.List;

public class SortUtil {
    public static List<String> sortByLength(List<String> list) {
        FontRenderer font = Minecraft.getMinecraft().fontRendererObj;
        int i = 0;
        int j = 0;

        for (String string : list) {
            for (String string1 : list) {
                if (font.getStringWidth(string1) > font.getStringWidth(string)) {
                    list.set(i,string1);
                }
                j++;
            }
            i++;
        }

        return list;
    }
}
