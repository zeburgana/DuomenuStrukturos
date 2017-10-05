package com.game.src.main;

import java.util.LinkedList;

/**
 * Created by Pug b0iiiii on 2017-10-05.
 */
public class Physx {
//    public static boolean Collision(Entity lasr, LinkedList<EnemyEntity> Ee){
//        for (int i = 0; i<Ee.size();i++){
//            if(lasr.getBounds().intersects(Ee.get(i).getBounds())){
//                return true;
//            }
//        }
//        return false;
//    }
    public static boolean Collision(EnemyEntity enemy, LinkedList<Entity> e){
        for (int i = 0; i<e.size();i++){
            if(enemy.getBounds().intersects(e.get(i).getBounds())){
                return true;
            }
        }
        return false;
    }
}
