/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects.Menues.MainMenu;

import Objects.Menues.Chooser;
import Components.GameScene;
import enums.SpriteSheet;

/**
 *
 * @author Frederik
 */
public class MenuScene extends GameScene{
    MainMenu mm;
    Chooser c;
    public MenuScene(){
        mm = new MainMenu();
        c = new Chooser(mm,SpriteSheet.POINTER);
        OC.units.add(mm);
        OC.units.add(c);
        p1 = c;
    }
}
