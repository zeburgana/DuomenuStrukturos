package com.game.src.main;

import java.awt.*;

/**
 * Created by Pug b0iiiii on 2017-10-05.
 */
public class GameObj {
    public double x,y;
    GameObj(double x, double y){
        this.x = x;
        this.y = y;
    }
    public Rectangle getBounds(int width, int height){
        return new Rectangle((int)x, (int)y, width, height);
    }

}
