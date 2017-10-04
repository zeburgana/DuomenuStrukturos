package com.game.src.main;

import java.awt.*;

/**
 * Created by Pug b0iiiii on 2017-10-03.
 */
public class Enemy {
    double x, y;
    String direction = "Right";       //true for right lel
    int WIDTH, SCALE, HEIGHT;
    private Textures tex;
    boolean state = true;
    public Enemy(double x, double y, Textures tex, Game game){
        this.x = x;
        this.y = y;
        this.tex = tex;
        WIDTH = game.WIDTH;
        SCALE = game.SCALE;
        HEIGHT = game.HEIGHT;
    }
    public void tick(){
        if(x==(WIDTH*SCALE)-20){
            direction = "Left";
            y+=32;
        }
        if(x==20){
            direction = "Right";
            y+=32;
        }
        switch(direction){
            case "Right":x+=2;break;
            case "Left" :x-=2;break;
        }
        if(y>=(HEIGHT*SCALE)-64)
            state = false;
        if(!state)
            return;
    }
    public void render(Graphics g){
        g.drawImage(tex.enemy,(int)x,(int)y,null);
    }
}
