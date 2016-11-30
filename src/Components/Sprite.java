/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author frederik.larsen
 */
public class Sprite {

    BufferedImage[] images;
    int counter = 0;
    int speedCounter = 0;
    int speed = 10; //higher = slower
    Enum status;

    public Sprite(BufferedImage[] images, Enum status) {
        this.images = images;
        this.status = status;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }
    public BufferedImage getCurrImage(){
        return images[counter];
    }
    
    public BufferedImage getNextImage() {
        BufferedImage curr = images[counter];
        speedCounter++;
        if (speedCounter == speed) {
            counter++;
            speedCounter = 0;
        }
        if (counter == images.length) {
            counter = 0;
        }
        return curr;

    }
    
    public void reset(){
        counter = 0;
        speedCounter = 0;
    }

}
