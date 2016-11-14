/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Components.BaseObject;
import Interfaces.Plottable;
import enums.FourDir;
import enums.PlayerStatus;
import enums.SpriteSheet;
import java.awt.Point;



/**
 *
 * @author frederik.larsen
 */
public class Wall extends BaseObject implements Plottable{
    public Wall(){
        addSpriteManager(PlayerStatus.NORTH);
        addPhysics();
        addHitbox(16, 16, new Point(90,0),false);
        addHitbox(16, 16, new Point(20,-30),true);
        getPhysics().gravity = false;
        getPhysics().immovable = true;
        getSpriteManager().addSprite(SpriteSheet.DUNGEON, FourDir.RIGHT, 0, 0, 16, 16, 0, 0, 1, PlayerStatus.NORTH);
    }
}
