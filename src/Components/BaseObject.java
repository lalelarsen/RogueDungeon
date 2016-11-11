/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import Components.Hitbox;
import Components.Physics;
import static Controllers.SpriteController.loadSpriteRoll;
import Controllers.SpriteManager;
import Interfaces.Plottable;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author frederik.larsen
 */
public class BaseObject implements Plottable {

    public Point pos = new Point(0, 0);
    public Image img;
    public Physics physics = null;
    public Hitbox hitbox = null;
    public ArrayList<Hitbox> hitboxes = new ArrayList<Hitbox>();
    public SpriteManager SM;
    public int lastX = 0;
    public int lastY = 0;

    @Override
    public void setCords(int x, int y) {
        Point p = new Point(x, y);
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
    public Point nextPos() {
//        Point newPos = new Point(pos.x + physics.getVelocity().x + physics.getAcceleration().x, pos.y + physics.getVelocity().y + physics.getAcceleration().y);
//        setCords(newPos.x, newPos.y);
//        return newPos;
        if(physics == null){
            return getCords();
        }
        return physics.update();
    }

    @Override
    public Point getCords() {
        return pos;
    }

    public void addSpriteManager(Enum status) {
        SM = new SpriteManager(status);
    }

    public SpriteManager getSpriteManager() {
        return SM;
    }

    public void addHitbox(int width, int height) {
        Hitbox hb = new Hitbox(height, width, this,new Point(0,0));
        hitboxes.add(hb);
    }
    
    public void addHitbox(int width, int height, Point p) {
        Hitbox hb = new Hitbox(height, width, this,p);
        hitboxes.add(hb);
    }

    public ArrayList<Hitbox> getHitboxes(){
        return hitboxes;
    }
    
    public Hitbox getHitbox() {
        return this.hitbox;
    }

    public void addPhysics() {
        physics = new Physics(this);
    }

    public Physics getPhysics() {
        return this.physics;
    }

}
