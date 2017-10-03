package com.game.src.main;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Pug b0iiiii on 2017-10-02.
 */
public class Bullet {
    private double x;
    private double y;

    public Bullet(double x, double y, Game game){
        this.x = x;
        this.y = y;
        SpriteSheet spsh = new SpriteSheet(game.getSpriteSheet());
        image = spsh.grabImage(1,0,32,32);
    }

    BufferedImage image;

    public void tick(){
        y-=10;
    }
    public void render(Graphics g){
        g.drawImage(image,(int)x,(int)y, null);
    }
    public double GetY(){
        return y;
    }
}
