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

    private Textures tex;

    int HEIGHT, WIDTH, SCALE;

    public Player(double x, double y, Textures tex, Game game){
        this.x = x;
        this.y = y;
        this.tex = tex;
        HEIGHT = game.HEIGHT;
        WIDTH = game.WIDTH;
        SCALE = game.SCALE;
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
        if(x >= (WIDTH*SCALE)-20)
            x = (WIDTH*SCALE)-20;
        if(y <= 0)
            y = 0;
        if(y >= (HEIGHT*SCALE)-24)
            y = (HEIGHT*SCALE)-24;
    }
    public void render(Graphics g){
        g.drawImage(tex.player, ((int) x),((int) y),null);
    }

}
