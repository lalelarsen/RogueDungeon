/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import enums.HitboxType;
import java.awt.Point;

/**
 *
 * @author Frederik
 */
public class Hitbox {

    HitboxType type;
    public boolean isTrigger = false;
    public boolean isActive = true;
    public BaseObject body;
    public Point cords;
    
    public String id = "";

    public HitboxType getType() {
        return type;
    }

    public void setType(HitboxType type) {
        this.type = type;
    }

    public void triggered(Hitbox hb) {
        if (isActive && hb.isActive) {
            body.triggered(id,this,hb);
        }
    }

    public void Activate() {
        isActive = true;
    }

    public void Deactivate() {
        isActive = false;
    }

    public void setCords(Point cords) {
        this.cords = cords;
    }
    
    

}
