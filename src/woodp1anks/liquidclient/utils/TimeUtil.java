package woodp1anks.liquidclient.utils;

public class TimeUtil {
    public static int getAsMinute(int ticks) {
        return ticks / 20 / 60;
    }

    public static int getAsSecond(int ticks) {
        return ticks / 20 % 60;
    }
}
