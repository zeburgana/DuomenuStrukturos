package com.game.src.main;

import java.awt.*;

/**
 * Created by Pug b0iiiii on 2017-10-05.
 */
public interface EnemyEntity {
    void tick();
    void render(Graphics g);

    double getX();
    double getY();
}
