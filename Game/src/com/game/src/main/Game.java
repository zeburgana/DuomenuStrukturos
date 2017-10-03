package com.game.src.main;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Game extends Canvas implements Runnable{

    public static final int WIDTH = 320;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 2;
    public static String TITLE = "2D space Immigrants";

    private boolean running = false;
    private Thread thread;

    private BufferedImage spriteSheet = null;

    private Player player;
    private Controller controller;
    boolean isShooting = false;

    public static void main(String[] args) {
        Game game = new Game();

        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.start();
    }

    public void init(){
        requestFocus();
        BufferedImageLoader loader = new BufferedImageLoader();
        try{
            spriteSheet = loader.loadImage("res\\SpriteSheet.png");
        }catch(IOException e){
            e.printStackTrace();
        }

        addKeyListener(new KeyInput(this));
        player = new Player(200,200,this);
        controller = new Controller(this);
    }

    private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);

    private synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);

    }

    public void run() {
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000/amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();
        while(running){
            long now = System.nanoTime();
            delta+=(now - lastTime)/ns;
            lastTime = now;
            if(delta>=1)
            {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;
            if(System.currentTimeMillis() - timer >1000){
                timer +=1000;
                System.out.println(updates + "<- ticks  fps ->" + frames);
                updates = frames = 0;
            }
        }
        stop();
    }

    private void tick(){
        player.tick();
        controller.tick();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, getWidth(),getHeight(),this);
        player.render(g);
        controller.render(g);

        g.dispose();
        bs.show();
    }

    public BufferedImage getSpriteSheet(){
        return spriteSheet;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT)
            player.setVelX(3);
        else
            if(key == KeyEvent.VK_LEFT)
                player.setVelX(-3);
        else
            if(key == KeyEvent.VK_UP)
                player.setVelY(-3);
        else
            if(key == KeyEvent.VK_DOWN)
                player.setVelY(3);
        else
            if(key == KeyEvent.VK_Z)
            {
                if(!isShooting)
                    controller.addBullet(new Bullet(player.getX(), player.getY(),this));
                isShooting = true;
            }

    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        switch(key){
            case KeyEvent.VK_RIGHT: player.setVelX(0); break;
            case KeyEvent.VK_LEFT: player.setVelX(0); break;
            case KeyEvent.VK_UP: player.setVelY(0); break;
            case KeyEvent.VK_DOWN: player.setVelY(0); break;
            case KeyEvent.VK_Z: isShooting = false; break;
        }


//        if(key == KeyEvent.VK_RIGHT)
//            player.setVelX(0);
//        if(key == KeyEvent.VK_LEFT)
//            player.setVelX(0);
//        if(key == KeyEvent.VK_UP)
//            player.setVelY(0);
//        if(key == KeyEvent.VK_DOWN)
//            player.setVelY(0);
//        if(key == KeyEvent.VK_Z){
//            isShooting = false;
        }
    }
}
