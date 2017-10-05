package com.game.src.main;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Pug b0iiiii on 2017-10-02.
 */
public class Laser extends GameObj implements Entity {
//    private double x;
//    private double y;

    private Textures tex;
    private Game game;
    public Animation animation;

    public Laser(double x, double y, Textures tex, Game game) {
//        this.x = x;
//        this.y = y;
        super(x,y);
        this.tex = tex;
        this.game = game;
        animation = new Animation(5,tex.laser[0],tex.laser[1],tex.laser[2],tex.laser[3],tex.laser[4],tex.laser[4]);
    }

    public void tick() {
        y -= 10;
    }

    public void render(Graphics g) {
        g.drawImage(tex.laser[0], (int) x, (int) y, null);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x+16, (int)y+14, 2, 18);
    }


//    public double GetY() {
//        return y;
//    }
//
//    public double GetX(){
//        return x;
//    }
}