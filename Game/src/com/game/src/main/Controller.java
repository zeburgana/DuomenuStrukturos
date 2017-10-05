package com.game.src.main;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Pug b0iiiii on 2017-10-02.
 */
public class Controller {
    private LinkedList<Entity> ent = new LinkedList<Entity>();
    private LinkedList<EnemyEntity> Eent = new LinkedList<EnemyEntity>();

    Entity e;
    EnemyEntity Ee;
    Textures textures;
    Game game;
//    Random r = new Random();      //random spawnpoint experimentation

    public Controller(Textures tex, Game game){
        textures = tex;
        this.game = game;
    }

    public void createEnemy(int EnemyCount){
        for(int i = 0; i < EnemyCount; i++){
            if(i<=8)
                addEntity(new Enemy(i*64,0, textures, game, this));//r.nextInt(Game.WIDTH)
            if(i>8&&i<=18)
                addEntity(new Enemy(Game.WIDTH*Game.SCALE-(i-7)*64,32, textures, game, this));
        }
    }

    public void tick() {
        //friendly entities
        for (int i = 0; i < ent.size(); i++) {
            e = ent.get(i);
            e.tick();
        }
        //enemy entities
        for (int i = 0; i < Eent.size(); i++) {
            Ee = Eent.get(i);
            Ee.tick();
        }
    }
    public void render(Graphics g){
        //friendly entities
        for (int i = 0; i< ent.size(); i++){
            e = ent.get(i);
            e.render(g);
        }
        //enemy entities
        for (int i = 0; i< Eent.size(); i++){
            Ee = Eent.get(i);
            Ee.render(g);
        }
    }
    public void addEntity(Entity obj){
        ent.add(obj);
    }
    public void removeEntity(Entity obj){
        ent.remove(obj);
    }
    public void addEntity(EnemyEntity obj){
        Eent.add(obj);
    }
    public void removeEntity(EnemyEntity obj){
        Eent.remove(obj);
    }
    public LinkedList<Entity> GetF(){
        return ent;
    }
    public LinkedList<EnemyEntity> GetE(){
        return Eent;
    }
}
