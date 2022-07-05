package woodp1anks.liquidclient.utils;
@Deprecated
public class Animation {
    @Deprecated
    public static double animation(double start,double end,double speed,int time,AnimationMode animationMode) {
        double pos = start;
        int i = 0;
        double j = end - start;
        if (animationMode == AnimationMode.ALWAYS_NORMAL) {
            for (;;) {
                if (i >= 20) {
                    break;
                }
                if (i == time) {
                    break;
                }
                pos += j / 20;
                i++;
            }
        } else if (animationMode == AnimationMode.FAST_AT_START) {
            double pos1 = pos;
            for (;;) {
                if (i >= 20) {
                    break;
                }
                if (i == time) {
                    break;
                }
                if ((i < 5)) {
                    pos += j / 20 * 3;
                }
                if (i == 5) {
                    pos1 = pos1 + pos;
                }
                if (i >= 5) {
                    pos += pos1 / 15;
                }
                i++;
            }
        }
        return pos;
    }
}
