package com.game.src.main;

import java.awt.image.BufferedImage;

/**
 * Created by Pug b0iiiii on 2017-10-02.
 */
public class SpriteSheet {
    private BufferedImage image;
    public SpriteSheet(BufferedImage spsh){
        this.image = spsh;
    }
    public BufferedImage grabImage(int col, int row, int width, int height){
        BufferedImage img = image.getSubimage((col*32), (row*32), width, height);
        return img;
    }


}
