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



/**
 *
 * @author frederik.larsen
 */
public class Wall extends BaseObject implements Plottable{
    public Wall(){
        addSpriteManager(PlayerStatus.NORTH);
        addPhysics();
        addHitbox(64, 64);
        getPhysics().gravity = false;
        
        getSpriteManager().addSprite(SpriteSheet.DUNGEON, FourDir.RIGHT, 0, 0, 16, 16, 0, 0, 1, PlayerStatus.NORTH);
    }
}
