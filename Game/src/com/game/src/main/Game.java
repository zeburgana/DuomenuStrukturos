package com.game.src.main;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

public class Game extends Canvas implements Runnable{

    public static final int WIDTH = 320;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 2;
    public static String TITLE = "2D space Immigrants";

    private boolean running = false;
    private Thread thread;

    private BufferedImage spriteSheet = null;
    private BufferedImage background = null;

    private Player player;
    private int enemyCount = 5;
    private int enemyKilled = 0;
    private Controller controller;
    boolean isShooting = false;

    public LinkedList<Entity> ent;
    public LinkedList<EnemyEntity> Eent;

    private Textures tex;

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
            spriteSheet = loader.loadImage("C:\\Users\\Pug b0iiiii\\IdeaProjects\\Game\\res/SpriteSheet.png");
            background = loader.loadImage("C:\\Users\\Pug b0iiiii\\IdeaProjects\\Game\\res/Background.png");
        }catch(IOException e){
            e.printStackTrace();
        }
        tex = new Textures(this);
        addKeyListener(new KeyInput(this));
        player = new Player(WIDTH*SCALE/2,HEIGHT*SCALE-25, tex);
        controller = new Controller(tex);

        controller.createEnemy(11);

        ent = controller.GetF();
        Eent = controller.GetE();

//        controller.createEnemy(11);
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
        g.drawImage(background, 0, 0, null);


        player.render(g);
        controller.render(g);

        g.dispose();
        bs.show();
    }

    public int getEnemyCount() {
        return enemyCount;
    }

    public void setEnemyCount(int enemyCount) {
        this.enemyCount = enemyCount;
    }

    public int getEnemyKilled() {
        return enemyKilled;
    }

    public void setEnemyKilled(int enemyKilled) {
        this.enemyKilled = enemyKilled;
    }

    public BufferedImage getSpriteSheet(){
        return spriteSheet;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        switch(key){
            case KeyEvent.VK_RIGHT:player.setVelX(3);break;
            case KeyEvent.VK_LEFT:player.setVelX(-3);break;
            case KeyEvent.VK_UP:player.setVelY(-3);break;
            case KeyEvent.VK_DOWN:player.setVelY(3);break;
            case KeyEvent.VK_Z:
                if(!isShooting)
                    controller.addEntity(new Laser(player.getX(), player.getY(), tex, this));
                isShooting = true;
                break;
//            case KeyEvent.VK_Q:enemy=new Enemy(20,20,tex);break;
        }

    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        switch(key){
            case KeyEvent.VK_RIGHT:
                if(player.getVelX()>0)
                    player.setVelX(0);
                break;
            case KeyEvent.VK_LEFT:
                if(player.getVelX()<0)
                    player.setVelX(0);
                break;
            case KeyEvent.VK_UP:
                if(player.getVelY()<0)
                    player.setVelY(0);
                break;
            case KeyEvent.VK_DOWN:
                if(player.getVelY()>0)
                    player.setVelY(0);
                break;
            case KeyEvent.VK_Z:
                isShooting = false;
                break;
        }
    }
}
