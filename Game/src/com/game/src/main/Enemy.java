package com.game.src.main;

import java.awt.*;

/**
 * Created by Pug b0iiiii on 2017-10-03.
 */
public class Enemy {
    double x, y;
    String direction = "Right";       //true for right lel
    private Textures tex;
    public Enemy(double x, double y, Textures tex){
        this.x = x;
        this.y = y;
        this.tex = tex;
    }
    public void tick(){
        if(x==620){
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
    }
    public void render(Graphics g){
        g.drawImage(tex.enemy,(int)x,(int)y,null);
    }
}
