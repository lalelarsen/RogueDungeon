/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Components.Physics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import Interfaces.Plottable;

/**
 *
 * @author frederik.larsen
 */
public class MainCharacter extends GameObject implements Plottable{
    
    public MainCharacter(){
        String path = "C:\\Users\\frederik.larsen\\Pictures\\stickman.png";
        File fil = new File(path);
        BufferedImage imgg = null;
        //Get Image from path
        try {
            imgg = ImageIO.read(fil);
        } catch (IOException e) {
            System.out.println("The image was not loaded.");
        }
        
        addPhysics();
        getPhysics().gravity = true;
        height = imgg.getHeight();
        width = imgg.getWidth();
        img = imgg;
    }
    
    public void move(int dir) {
        Point currPoint = getCords();
        switch(dir){
            case 37:
                physics.applyForce(new Point(-1,0));
                //setCords(currPoint.x - speed, currPoint.y);
                break;
            case 38:
                physics.applyForce(new Point(0,-1));
                //setCords(currPoint.x, currPoint.y-speed);
                break;
            case 39:
                physics.applyForce(new Point(1,0));
                //setCords(currPoint.x + speed, currPoint.y);
                break;
            case 40:
                physics.applyForce(new Point(0,1));
                //setCords(currPoint.x, currPoint.y+speed);
                break;
            
        }
    }
    
    public void stop() {
        
    }
    
}
