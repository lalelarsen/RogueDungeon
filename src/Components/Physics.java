/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import Interfaces.Plottable;
import Objects.GameObject;
import java.awt.Point;

/**
 *
 * @author frederik.larsen
 */
public class Physics {

    GameObject body;
    public boolean gravity = true;
    public boolean grounded = false;
    public boolean resistenceX = true;
    public boolean resistenceY = true;
    public boolean isSolid = false;
    int maxForceX = 12;
    int maxForceY = 12;
    
    public Physics(GameObject body) {
        this.body = body;
    }

    public void applyForce(Point dir) {
        Point oldForce = body.getForceDir();
        Point newForce = new Point(oldForce.x + dir.x, oldForce.y + dir.y);
        if(newForce.x > maxForceX){newForce.x = maxForceX;}
        if(newForce.x < -maxForceX){newForce.x = -maxForceX;}
        if(newForce.y > maxForceY){newForce.y = maxForceY;}
        if(newForce.y < -maxForceY){newForce.y = -maxForceY;}
        body.setForceDir(newForce);
    }
    
}
