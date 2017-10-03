package com.game.src.main;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Pug b0iiiii on 2017-10-02.
 */
public class Controller {
    private LinkedList<Laser> lasers = new LinkedList<>();
    private LinkedList<Enemy> enemies = new LinkedList<>();

    Laser temp;
    Enemy Etemp;

    Game game;
    Textures tex;

    public Controller(Game game, Textures tex){
        this.game = game;
        this.tex = tex;

        for(int x =30;x<(Game.WIDTH *Game.SCALE);x+=80){
            addEnemy(new Enemy(x,0,tex));
        }
    }

    public void tick(){
        for(int i = 0;i<lasers.size();i++){
            temp = lasers.get(i);
            if(temp.GetY()<=1)
                removeLaser(temp);
            temp.tick();
        }
        for(int i = 0;i<enemies.size();i++){
            Etemp = enemies.get(i);
            Etemp.tick();
        }
    }
    public void render(Graphics g){
        for(Laser laser : lasers){
            temp = laser;
            temp.render(g);
        }
        for(Enemy enemy : enemies){
            Etemp = enemy;
            Etemp.render(g);
        }
    }
    public void addLaser(Laser laser){
        lasers.add(laser);
    }
    public void removeLaser(Laser laser){
        lasers.remove(laser);
    }
    public void addEnemy(Enemy enemy){
        enemies.add(enemy);
    }
    public void removeEnemy(Enemy enemy){
        enemies.remove(enemy);
    }
}
