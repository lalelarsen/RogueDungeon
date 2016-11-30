/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import enums.HitboxType;

/**
 *
 * @author Frederik
 */
public class Hitbox {
    HitboxType type;
    public boolean isTrigger = false;
    
    public HitboxType getType() {
        return type;
    }

    public void setType(HitboxType type) {
        this.type = type;
    }
    
    
}
