/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import Controllers.ObjectsController;
import Interfaces.PlayerOne;
import enums.FourDir;
import enums.MoveStatus;
import enums.SpriteSheet;

import java.awt.Point;

/**
 *
 * @author frederik.larsen
 */
public class GameScene {
    public ObjectsController OC;
    public PlayerOne p1;
    public BaseObject camera = new BaseObject();
    
    public GameScene(){
        OC = new ObjectsController();
    }
    public void frame10(){
        OC.lowPrioUnitUpdate();
        OC.updateUnits();
    };
    public void frame9(){};
    public void frame8(){};
    public void frame7(){};
    public void frame6(){};
    public void frame5(){};
    public void frame4(){
        OC.solidCollisionDetetection();
        OC.objectsUpdate();
    };
    public void frame3(){};
    public void frame2(){};
    public void frame1(){
        sceneUpdate();
        OC.highPrioUnitUpdate();
    };
    
    public Point getCameraPos(){
        return camera.getCords();
    }

    public void sceneUpdate(){

    }
}
