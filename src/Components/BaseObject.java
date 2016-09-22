/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import Components.Hitbox;
import Components.Physics;
import Interfaces.Plottable;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author frederik.larsen
 */
public class BaseObject implements Plottable {
    
    public Point pos = new Point(0,0);
    public Image img;
    public Physics physics;
    public Hitbox hitbox;
    public int speed = 5;
    public Point forceDir = new Point(0,0);
    public int lastX = 0;
    public int lastY = 0;
    
    @Override
    public void setCords(int x, int y) {
        Point p = new Point(x,y);
        lastX = this.pos.x;
        lastY = this.pos.y;
        this.pos = p;
    }

    @Override
    public void setImage(Image img) {
        this.img = img;
    }

    @Override
    public Image getImage() {
        return img;
    }

    @Override
    public Point nextPos(){
        Point newPos = new Point(pos.x + forceDir.x, pos.y + forceDir.y);
        setCords(newPos.x, newPos.y);
        return newPos;
    }
    
    @Override
    public Point getCords() {
        return pos;
    }
    
    public void addHitbox(int width,int height){
        hitbox = new Hitbox(height,width,this);
    }
    
    public Hitbox getHitbox(){
        return this.hitbox;
    }
    
    public void addPhysics(){
         physics = new Physics(this);
    }
    
    public Physics getPhysics(){
        return this.physics;
    }
    
    public Point getForceDir() {
        return forceDir;
    }

    public void setForceDir(Point forceDir) {
        this.forceDir = forceDir;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    
    
}
