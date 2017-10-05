package com.game.src.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 * Created by Pug b0iiiii on 2017-10-03.
 */
public class Enemy extends GameObj implements EnemyEntity {
    String direction = "Right";
    private Textures tex;
    Animation animation;
    Game game;
    Controller controller;

//    private int speed = r.nextInt(3)+1;   //experimenting with individual speeds

    public Enemy(double x, double y, Textures tex, Game game, Controller controller){
//        this.x = x;
//        this.y = y;
        super(x,y);
        this.tex = tex;
        this.game = game;
        this.controller = controller;
        animation = new Animation(1,tex.enemy[0],tex.enemy[3],tex.enemy[2],tex.enemy[1],tex.enemy[2],tex.enemy[3]);
    }
    public void tick(){
        if(Physx.Collision(this,controller.GetF())){
            controller.removeEntity(this);
            animation.runAnimation();
            animation.renderAnimation(game.getGraphics(),x,y,0);
            game.setEnemyKilled(game.getEnemyKilled()+1);
        }
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
        g.drawImage(tex.enemy[0],(int)x,(int)y,null);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32, 32);
    }

}
