package com.game.src.main;

import java.awt.image.BufferedImage;

/**
 * Created by Pug b0iiiii on 2017-10-03.
 */
public class Textures {

    public BufferedImage player, laser, enemy;


    private SpriteSheet spriteSheet = null;
    public Textures(Game game){
        spriteSheet = new SpriteSheet(game.getSpriteSheet());
        getTextures();
    }
    private void getTextures(){
        player = spriteSheet.grabImage(0,0,32,32);
        laser = spriteSheet.grabImage(1,0,32,32);
        enemy = spriteSheet.grabImage(2,0,32,32);
    }
}
