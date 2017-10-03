package com.game.src.main;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Pug b0iiiii on 2017-10-02.
 */
public class Controller {
    private LinkedList<Bullet> bullets = new LinkedList<>();

    Bullet temp;

    Game game;

    public Controller(Game game){
        this.game = game;
    }

    public void tick(){
        for(Bullet bullet : bullets){
            temp = bullet;
            if(temp.GetY()<=5)
                removeBullet(temp);
            temp.tick();
        }
    }
    public void render(Graphics g){
        for(Bullet bullet : bullets){
            temp = bullet;
            temp.render(g);
        }
    }
    public void addBullet(Bullet bullet){
        bullets.add(bullet);
    }
    public void removeBullet(Bullet bullet){
        bullets.remove(bullet);
        bullet = null;
    }
}
