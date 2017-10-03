package com.game.src.main;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Pug b0iiiii on 2017-10-02.
 */
public class Player {

    private double velX = 0;
    private double velY = 0;

    private double x;
    private double y;       //y is flipped
    private BufferedImage player;

    public Player(double x, double y, Game game){
        this.x = x;
        this.y = y;

        SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
        player = ss.grabImage(0,0,32,32);
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }

    public void setVelX(double velocity){
        this.velX = velocity;
    }
    public void setVelY(double velocity){
        this.velY = velocity;
    }
    public double getVelX(){
        return velX;
    }
    public double getVelY(){
        return velY;
    }

    public void tick(){
        x+=velX;
        y+=velY;
        if(x <= 0)
            x = 0;
        if(x >= 640-20)
            x = 640-20;
        if(y <= 0)
            y = 0;
        if(y >= 480-35)
            y = 480-35;
    }
    public void render(Graphics g){
        g.drawImage(player, ((int) x),((int) y),null);
    }

}
