/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Components.BaseObject;
import Components.Hitbox;
import Controllers.GameController;
import enums.FourDir;
import enums.MoveStatus;
import enums.SpriteSheet;
import java.awt.Point;

/**
 *
 * @author Frederik
 */
public class CameraObject extends BaseObject {

    BaseObject Target;
    double distanceToTarget = 0;
    int chaseRange = 300;
    public int speed = 1;
    int hp = 3;
    long lastHitted = 0;

    public CameraObject() {
        addRoundHitbox(32, new Point(32, 32), true, "");
    }
    
    @Override
    public void callUpdate() {
        
    }

    @Override
    public void lowPrioUpdate() {
        if (Target == null) {
            Target = GameController.getCurrScene().OC.findObject("MainCharacter").get(0);
        }
        distanceToTarget = Math.sqrt(((Target.getCords().x - getCords().x) * (Target.getCords().x - getCords().x)) + ((Target.getCords().y - getCords().y) * (Target.getCords().y - getCords().y)));
        
    }

    public void updateCameraPos(){
        
    }
    
    @Override
    public void callHighUpdate() {
        if (Target == null) {
            Target = GameController.getCurrScene().OC.findObject("MainCharacter").get(0);
        }
        if (distanceToTarget < chaseRange) {
            if (Target.getCords().x > getCords().x + 10) {
                setCords(getCords().x + speed, getCords().y);
    
            } else if (Target.getCords().x + 10 < getCords().x) {
                setCords(getCords().x - speed, getCords().y);
    
            }
            if (Target.getCords().y > getCords().y + 10) {
                setCords(getCords().x, getCords().y + speed);
    
            } else if (Target.getCords().y + 10 < getCords().y) {
                setCords(getCords().x, getCords().y - speed);
    
            }
        }
    }
}
