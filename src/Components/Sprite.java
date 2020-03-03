/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author frederik.larsen
 */
public class Sprite {

    BufferedImage[] images;
    int counter = 0;
    int speedCounter = 0;
    int speed = 10; //higher = slower
    long lastTimeStamp = 0;
    long timeBetweenFrames = 400;
    Enum status;
    Date date;

    public Sprite(BufferedImage[] images, Enum status, long timeBetweenFrames) {
        this.images = images;
        this.status = status;
        // this.timeBetweenFrames = timeBetweenFrames;
        date = new Date();
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
    
    // public BufferedImage getNextImage() {
    //     BufferedImage curr = images[counter];
    //     speedCounter++;
    //     if (speedCounter == speed) {
    //         counter++;
    //         speedCounter = 0;
    //     }
    //     if (counter == images.length) {
    //         counter = 0;
    //     }
    //     return curr;

    // }
    
    public BufferedImage getNextImage() {
        date = new Date();
        if(timeBetweenFrames < date.getTime()-lastTimeStamp){
            counter++;
            if (counter == images.length) {
                counter = 0;
            }
            lastTimeStamp = date.getTime();
            return images[counter];
        }
        return images[counter];
    }

    public void reset(){
        counter = 0;
        speedCounter = 0;
    }

}
