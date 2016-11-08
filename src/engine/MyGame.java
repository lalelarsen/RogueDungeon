/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import Components.BaseObject;
import Components.GameScene;
import Controllers.KeyboardController;
import Controllers.SpriteController;
import Objects.SceneOne;
import enums.PlayerStatus;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.HashSet;

/**
 *
 * @author frederik.larsen
 */
public class MyGame extends Canvas implements Runnable {

    public boolean running = false;
    private Thread thread;
    KeyboardController KC;
    GameScene currScene;
    SpriteController SC;
    
    public MyGame(){
        KC = new KeyboardController();
        SC = new SpriteController();
        currScene = new SceneOne();
    }
    
    public synchronized void start() {
        if (running) {
            return;
        }

        running = true;
        thread = new Thread(this);
        thread.start();

    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while (running) {
            manageKeys();
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
                updates = 0;
            }
        }
    }
    
    private void tick(){
        for (int i = 0; i < currScene.OC.units.size(); i++) {
            BaseObject currObject = currScene.OC.units.get(i);
            currObject.nextPos();
            currScene.OC.updatePhysics(currObject);
        }
    }
    
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        ////
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        for (int i = 0; i < currScene.OC.units.size(); i++) {
            BaseObject currObject = currScene.OC.units.get(i);
            Image img = null;
            try {
                img = currObject.getSpriteManager().nextImage();
                
            } catch (Exception e) {
                System.out.println(currObject.getClass().getName() + " har intet billede");
            }
            g.drawImage(img, currObject.getCords().x, currObject.getCords().y, null);
        }
        ////
        g.dispose();
        bs.show();
        this.setFocusable(true);
    }

    private void manageKeys() {
        //get the currently pressed keys from the KeyboardController
        HashSet<Integer> currentKeys = KeyboardController.getActiveKeys();

//        if (currentKeys.contains(KeyEvent.VK_RIGHT)) {
//            currScene.OC.Hero.move(KeyEvent.VK_RIGHT);
//        }
//        if (currentKeys.contains(KeyEvent.VK_LEFT)) {
//            //move left
//            currScene.OC.Hero.move(KeyEvent.VK_LEFT);
//        } 
//        if (currentKeys.contains(KeyEvent.VK_DOWN)) {
//            //move left
//            currScene.OC.Hero.move(KeyEvent.VK_DOWN);
//        }
//        if (currentKeys.contains(KeyEvent.VK_UP)) {
//            //move left
//            currScene.OC.Hero.move(KeyEvent.VK_UP);
//        }
//        if(currentKeys.contains(KeyEvent.VK_SPACE)){
//            currScene.OC.Hero.move(KeyEvent.VK_SPACE);
//            currScene.OC.Hero.getPhysics().gravity = true;
//        }
//        if (currentKeys.isEmpty()) {
//            //if the player is not pressing keys, the protagonist stands still
//            currScene.OC.Hero.getSpriteManager().setStatus(PlayerStatus.IDLE);
//        }

    }
    
//    public static void main(String[] args) {
//        MyGame mg = new MyGame();
//        new Window(800, 600, "The Corigin", mg);
//    }
}
