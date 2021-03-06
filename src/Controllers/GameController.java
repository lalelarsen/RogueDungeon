/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Components.BaseObject;
import Components.GameScene;
import Interfaces.PlayerOne;
import Objects.Menues.MainMenu.MenuScene;
import Objects.SceneOne;
import Panels.MainPanel;
import enums.MoveStatus;
import enums.Scenes;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.HashSet;
import javax.swing.JFrame;

/**
 *
 * @author frederik.larsen
 */
public class GameController {

    static GameScene currScene;
    KeyboardController KC = new KeyboardController();
    static MainPanel mp;
    int FRAMES60_PER_SECOND = 2;
    int counter1 = 1;
    int counter2 = 1;
    int counter3 = 1;
    int counter4 = 1;
    int counter5 = 1;
    int counter6 = 1;
    int counter7 = 1;
    int counter8 = 1;
    int counter9 = 1;
    int counter10 = 1;
    long lastTimeStamp = 0;
    long timeBetweenFrames = 2;
    Date date;
    

    public void StartGame() {
        SpriteController sController = new SpriteController();
        currScene = new MenuScene();
        //currScene = new SceneOne();
        mp = new MainPanel(KC, currScene);
        JFrame frame = new JFrame("Test");
        //frame.setLayout(new BorderLayout());
        frame.add(mp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        run(mp);
    }

    public void run(MainPanel mp) {
        while (true) {
            mp.repaint();
            
            date = new Date();
            if(timeBetweenFrames < date.getTime()-lastTimeStamp){
                lastTimeStamp = date.getTime();
                
                currScene.frame1();
                MainPanel.camera = currScene.getCameraPos();
                //manage the keys currently pressed
                manageKeys();
                if(counter2 == 2){
                    currScene.frame2(); 
                    counter2 = 0;
                }
                if(counter3 == 3){
                    currScene.frame3(); 
                    counter3 = 0;
                }
                if(counter4 == 4){
                    currScene.frame4(); 
                    counter4 = 0;
                }
                if(counter5 == 5){
                    currScene.frame5(); 
                    counter5 = 0;
                }
                if(counter6 == 6){
                    currScene.frame6(); 
                    counter6 = 0;
                }
                if(counter7 == 7){
                    currScene.frame7(); 
                    counter7 = 0;
                }
                if(counter8 == 8){
                    currScene.frame8(); 
                    counter8 = 0;
                }
                if(counter9 == 9){
                    currScene.frame9(); 
                    counter9 = 0;
                }
                if(counter10 == 10){
                    
                    currScene.frame10(); 
                    counter10 = 0;
                }
                counter1++;
                counter2++;
                counter3++;
                counter4++;
                counter5++;
                counter6++;
                counter7++;
                counter8++;
                counter9++; 
                counter10++;
            }
            
            // try {
            //     Thread.sleep(FRAMES60_PER_SECOND);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
        }
    }

    private void manageKeys() {
        //get the currently pressed keys from the KeyboardController
        HashSet<Integer> currentKeys = KeyboardController.getActiveKeys();

        if (currentKeys.contains(KeyEvent.VK_RIGHT)) {
            //move right
            currScene.p1.right();
        }
        if (currentKeys.contains(KeyEvent.VK_LEFT)) {
            //move left
            currScene.p1.left();
        } 
        if (currentKeys.contains(KeyEvent.VK_DOWN)) {
            //move down
            currScene.p1.down();
        }
        if (currentKeys.contains(KeyEvent.VK_UP)) {
            //move up
            currScene.p1.up();
        }
        if(currentKeys.contains(KeyEvent.VK_ENTER)){
            currScene.p1.enter();
        }
        if(currentKeys.contains(KeyEvent.VK_SPACE)){
            currScene.p1.space();
        }
        if(currentKeys.contains(KeyEvent.VK_W)){
            currScene.p1.w();
        }
        if(currentKeys.contains(KeyEvent.VK_S)){
            currScene.p1.s();
        }
        if(currentKeys.contains(KeyEvent.VK_D)){
            currScene.p1.d();
        }
        if(currentKeys.contains(KeyEvent.VK_A)){
            currScene.p1.a();
        }
        if (currentKeys.isEmpty()) {
            //if the player is not pressing keys, the protagonist stands still
            currScene.p1.nothing();
        }

    }
    
    public static void updateCameraCords(Point p){
        mp.updateCameraCord(p);
    }
    
    public static GameScene getCurrScene(){
        return currScene;
    }
    
    public static void changeScene(Scenes e){
        switch(e){
            case MainMenu:
                
                break;
            case LevelOne:
                GameScene gs  = new SceneOne();
                currScene = gs;
                mp.SC = gs;
                break;
        }
    }
}
