package woodp1anks.liquidclient.misc;

import java.awt.*;
import java.util.Random;

public class Rainbow {

    private int startR;
    private int startG;
    private int startB;
    private int endR;
    private int endG;
    private int endB;
    private int speed;
    private int r;
    private int g;
    private int b;
    private boolean rd;
    private boolean gd;
    private boolean bd;

    public Rainbow(int startR,int startG,int startB,int endR,int endG,int endB,int speed) {
        this.startR = startR;
        this.startG = startG;
        this.startB = startB;
        this.endR = endR;
        this.endG = endG;
        this.endB = endB;
        this.speed = speed;
        this.rd = true;
        this.gd = true;
        this.bd = true;
        this.r = startR;
        this.g = startG;
        this.b = startB;
    }

    public void update() {
        Random random = new Random();

        this.rd = random.nextInt(2) == 1;
        this.gd = random.nextInt(2) == 1;
        this.bd = random.nextInt(2) == 1;

        boolean endRWrong = endR + speed > 255;
        boolean endGWrong = endG + speed > 255;
        boolean endBWrong = endB + speed > 255;

        boolean startRWrong = startR - speed < 0;
        boolean startGWrong = startG - speed < 0;
        boolean startBWrong = startB - speed < 0;

        int endRMore = endR + speed - endR;
        int endGMore = endG + speed - endG;
        int endBMore = endB + speed - endB;

        int startRMore = -(startR - speed) + startR;
        int startGMore = -(startG - speed) + startR;
        int startBMore = -(startB - speed) + startB;

        if (endRWrong ? this.r >= endR - endRMore : this.r >= endR) {
            this.rd = true;
            this.r -= this.speed;
        } if (startRWrong ? this.r <= startR + startRMore : this.r <= startR) {
            this.rd = false;
            this.r += this.speed;
        }
        if (this.rd) {
            this.r -= random.nextInt(this.speed);
        } else {
            this.r += random.nextInt(this.speed);
        }

        if (endGWrong ? this.g >= endG - endGMore : this.g >= endG) {
            this.gd = true;
            this.g -= this.speed;
        } if (startGWrong ? this.g <= startG + startGMore : this.g <= startG) {
            this.gd = false;
            this.g += this.speed;
        }
        if (this.gd) {
            this.g -= random.nextInt(this.speed);
        } else {
            this.g += random.nextInt(this.speed);
        }

        if (endBWrong ? this.b >= endB - endBMore : this.b >= endB) {
            this.bd = true;
            this.b -= this.speed;
        } if (startBWrong ? this.b <= startB + startBMore : this.b <= startB) {
            this.bd = false;
            this.b += this.speed;
        }
        if (this.bd) {
            this.b -= random.nextInt(this.speed);
        } else {
            this.b += random.nextInt(this.speed);
        }
    }

    public Color getColor() {
        return new Color(getR(),getG(),getB());
    }

    public int getR() {
        return this.r;
    }

    public int getG() {
        return this.g;
    }

    public int getB() {
        return this.b;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getStartR() {
        return this.startR;
    }

    public int getStartG() {
        return this.startG;
    }

    public int getStartB() {
        return this.startB;
    }

    public int getEndR() {
        return this.endR;
    }

    public int getEndG() {
        return this.endG;
    }

    public int getEndB() {
        return this.endB;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setStartR(int startR) {
        this.startR = startR;
    }

    public void setStartG(int startG) {
        this.startG = startG;
    }

    public void setStartB(int startB) {
        this.startB = startB;
    }

    public void setEndR(int endR) {
        this.endR = endR;
    }

    public void setEndG(int endG) {
        this.endG = endG;
    }

    public void setEndB(int endB) {
        this.endB = endB;
    }

    public void setColor(Color color) {
        this.r = color.getRed();
        this.g = color.getGreen();
        this.b = color.getBlue();
    }
}
