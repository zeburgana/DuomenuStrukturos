package com.game.src.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Pug b0iiiii on 2017-10-02.
 */
public class KeyInput extends KeyAdapter {

    Game game;

    public KeyInput(Game game){
        this.game = game;
    }

    public void keyPressed(KeyEvent e){
        game.keyPressed(e);
    }
    public void keyReleased(KeyEvent e){
        game.keyReleased(e);
    }
}
