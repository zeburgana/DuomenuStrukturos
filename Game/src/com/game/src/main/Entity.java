package com.game.src.main;

import java.awt.*;

/**
 * Created by Pug b0iiiii on 2017-10-05.
 */
public interface Entity{
    void tick();
    void render(Graphics g);
    public Rectangle getBounds();

    double getX();
    double getY();
}
