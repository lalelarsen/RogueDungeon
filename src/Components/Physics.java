/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import Interfaces.Plottable;
import java.awt.Point;

/**
 *
 * @author frederik.larsen
 */
public class Physics {

    BaseObject body;
    public Point velocity = new Point(0,0);
    public Point acceleration = new Point (0,0);
    public boolean gravity = true;
    public boolean grounded = false;
    public boolean resistenceX = true;
    public boolean resistenceY = true;
    public boolean isSolid = false;
    int maxForceX = 12;
    int maxForceY = 12;
    
    public Physics(BaseObject body) {
        this.body = body;
    }

    public void applyForce(Point dir) {
        Point oldForce = getVelocity();
        Point newForce = new Point(oldForce.x + dir.x, oldForce.y + dir.y);
        if(newForce.x > maxForceX){newForce.x = maxForceX;}
        if(newForce.x < -maxForceX){newForce.x = -maxForceX;}
        if(newForce.y > maxForceY){newForce.y = maxForceY;}
        if(newForce.y < -maxForceY){newForce.y = -maxForceY;}
        setVelocity(newForce);
    }

    public Point update(){
        velocity.x += acceleration.x;
        velocity.y += acceleration.y;
        Point p = new Point(body.getCords().x + velocity.x,body.getCords().y + velocity.y);
        body.setCords(p.x,p.y);
        return p;
    }
    
    public Point getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Point acceleration) {
        this.acceleration = acceleration;
    }
    
    public Point getVelocity() {
        return velocity;
    }

    public void setVelocity(Point forceDir) {
        this.velocity = forceDir;
    }
    
    
}
