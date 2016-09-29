/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

/**
 *
 * @author frederik.larsen
 */
public class KeyboardController implements KeyListener{
    private static HashSet<Integer> activeKeys;
 
    public KeyboardController(){
        activeKeys = new HashSet<Integer>();
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        activeKeys.add(e.getKeyCode());
    }
 
    @Override
    public void keyReleased(KeyEvent e) {
        activeKeys.remove(e.getKeyCode());
    }
 
    @Override
    public void keyTyped(KeyEvent e) {
    }
     
    public static HashSet<Integer> getActiveKeys(){
        return activeKeys;
    }
     

}
