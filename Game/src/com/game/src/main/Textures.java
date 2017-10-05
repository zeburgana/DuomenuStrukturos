package com.game.src.main;

import java.awt.image.BufferedImage;

/**
 * Created by Pug b0iiiii on 2017-10-03.
 */
public class Textures {

    public BufferedImage player;
    public BufferedImage[] enemy = new BufferedImage[4];
    public BufferedImage[] laser = new BufferedImage[5];


    private SpriteSheet spriteSheet = null;
    public Textures(Game game){
        spriteSheet = new SpriteSheet(game.getSpriteSheet());
        getTextures();
    }
    private void getTextures(){
        player = spriteSheet.grabImage(0,0,32,32);

        laser[0] = spriteSheet.grabImage(1,0,32,32);
        laser[1] = spriteSheet.grabImage(1,1,32,32);
        laser[2] = spriteSheet.grabImage(1,2,32,32);
        laser[3] = spriteSheet.grabImage(1,3,32,32);
        laser[4] = spriteSheet.grabImage(1,4,32,32);

        enemy[0] = spriteSheet.grabImage(2,0,32,32);
        enemy[1] = spriteSheet.grabImage(2,1,32,32);
        enemy[2] = spriteSheet.grabImage(2,2,32,32);
        enemy[3] = spriteSheet.grabImage(2,3,32,32);
    }
}
