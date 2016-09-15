/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Controllers.ObjectsController;

/**
 *
 * @author frederik.larsen
 */
public class Scene {
    public ObjectsController OC;
    public Scene(){
        OC = new ObjectsController();
    }
    public void frame1(){OC.bounce();};
    public void frame2(){};
    public void frame3(){};
    public void frame4(){};
    public void frame5(){};
    public void frame6(){};
    public void frame7(){};
    public void frame8(){};
    public void frame9(){};
    public void frame10(){OC.updateGravAndResis();};
}
