/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Components.GameScene;
import Controllers.ObjectsController;
import Objects.MainCharacter;
import java.util.ArrayList;
import Interfaces.Plottable;
import Components.BaseObject;

/**
 *
 * @author frederik.larsen
 */
public class SceneOne extends GameScene{
    public MainCharacter Hero;
    public Wall w;
    public SceneOne(){
        System.out.println("runned");
        Hero = new MainCharacter();
        w = new Wall();
        Hero.setCords(50, 270);
        w.setCords(30, 240);
        OC.units.add(Hero);
        OC.units.add(w);
        p1 = Hero;
        
    }
    
    
}
