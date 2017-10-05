package com.game.src.main;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Pug b0iiiii on 2017-10-05.
 */
public class Animation {
    private int speed;
    private int frames;
    private int index = 0;
    private int count = 0;

    private BufferedImage img0;
    private BufferedImage img1;
    private BufferedImage img2;
    private BufferedImage img3;
    private BufferedImage img4;
    private BufferedImage img5;

    private BufferedImage current;

    public Animation(int speed,BufferedImage img0, BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4, BufferedImage img5){
        this.speed = speed;
        this.img0 = img0;
        this.img0 = img1;
        this.img0 = img2;
        this.img0 = img3;
        this.img0 = img4;
        this.img0 = img5;
        frames = 6;
    }

    public void runAnimation(){
        index++;
        if(index>speed){
            index = 0;
            nextFrame();
        }
    }
    public void nextFrame(){
        switch(count){
            case 0:
                current = img0;
                count++;
                if(count > frames)
                    count = 0;
                break;
            case 1:
                current = img1;
                count++;
                if(count > frames)
                    count = 0;
                break;
            case 2:
                current = img2;
                count++;
                if(count > frames)
                    count = 0;
                break;
            case 3:
                current = img3;
                count++;
                if(count > frames)
                    count = 0;
                break;
            case 4:
                current = img4;
                count++;
                if(count > frames)
                    count = 0;
                break;
            case 5:
                current = img5;
                count++;
                if(count > frames)
                    count = 0;
                break;
        }
    }
    public void renderAnimation(Graphics g, double x, double y, int offset){
        g.drawImage(current,(int)x-offset,(int)y,null);
    }
    public void setCount(int count){
        this.count = count;
    }
    public int getCount(){
        return count;
    }
    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
}
