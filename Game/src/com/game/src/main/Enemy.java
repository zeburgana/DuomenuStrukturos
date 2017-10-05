package com.game.src.main;

import java.awt.*;
import java.util.Random;

/**
 * Created by Pug b0iiiii on 2017-10-03.
 */
public class Enemy extends GameObj implements EnemyEntity {
//    double x, y;
    String direction = "Right";       //true for right lel
    private Textures tex;
    Random r = new Random();
//    private int speed = r.nextInt(3)+1;   //experimenting with individual speeds

    public Enemy(double x, double y, Textures tex){
//        this.x = x;
//        this.y = y;
        super(x,y);
        this.tex = tex;
    }
    public void tick(){
        if(x>=(Game.WIDTH*Game.SCALE)-25){
            direction = "Left";
            y+=32;
        }
        if(x<=-1){
            direction = "Right";
            y+=32;
        }
        switch(direction){
            case "Right":x+=5;break;
            case "Left" :x-=5;break;
        }
        if(y>=(Game.HEIGHT*Game.SCALE)-64){
            y = 0;
            //x = r.nextInt(Game.WIDTH*Game.SCALE);
        }

    }
    public void render(Graphics g){
        g.drawImage(tex.enemy,(int)x,(int)y,null);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
