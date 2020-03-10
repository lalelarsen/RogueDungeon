/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import Components.SquareHitbox;
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
public class BaseObject implements Plottable, Comparable<BaseObject> {

    public Point pos = new Point(0, 0);
    public Image img = null;
    public Physics physics = null;
    public ArrayList<Hitbox> hitboxes = new ArrayList<Hitbox>();
    public SpriteManager SM;
    public int lastX = 0;
    public int lastY = 0;
    public boolean isActive = true;
    

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
    
    public void callUpdate(){
        
    }
    
    public void lowPrioUpdate(){
        
    }
    
    public void addSpriteManager(Enum status) {
        SM = new SpriteManager(status);
    }

    public SpriteManager getSpriteManager() {
        return SM;
    }

    public void addSquareHitbox(int width, int height, boolean isTrigger, String id) {
        SquareHitbox hb = new SquareHitbox(width, height, this,new Point(0,0), isTrigger, id);
        hitboxes.add(hb);
    }
    
    public void addSquareHitbox(int width, int height, Point p, boolean isTrigger, String id) {
        SquareHitbox hb = new SquareHitbox(width, height, this,p,isTrigger, id);
        hitboxes.add(hb);
    }

    public void addRoundHitbox(int radius, Point p, boolean isTrigger, String id){
        RoundHitbox hb = new RoundHitbox(p,radius, this, isTrigger, id);
        hitboxes.add(hb);
    }
    
    public void addRoundHitbox(int radius, boolean isTrigger, String id){
        RoundHitbox hb = new RoundHitbox(new Point(0,0),radius, this, isTrigger, id);
        hitboxes.add(hb);
    }
    
    public ArrayList<Hitbox> getHitboxes(){
        return hitboxes;
    }

    public void addPhysics() {
        physics = new Physics(this);
    }

    public Physics getPhysics() {
        return this.physics;
    }

    @Override
    public int compareTo(BaseObject o) {
        return this.getCords().y - o.getCords().y;
    }

    public Hitbox getHitbox(String id){
        for (int i = 0; i < hitboxes.size(); i++) {
            if(hitboxes.get(i).id.equals(id)){
                return hitboxes.get(i);
            }
        }
        return null;
    }
    
    public void triggered(String id,Hitbox self, Hitbox hb){
        
    }

	public void callHighUpdate() {
	}
    
    
}
