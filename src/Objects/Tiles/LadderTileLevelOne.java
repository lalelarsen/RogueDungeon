/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects.Tiles;

import Components.BaseObject;
import Components.Hitbox;
import Controllers.GameController;
import enums.FourDir;
import enums.Scenes;
import enums.SpriteSheet;
import enums.ioStatus;
import java.awt.Point;

/**
 *
 * @author Frederik
 */
public class LadderTileLevelOne extends BaseObject {

    public boolean isON = false;

    public LadderTileLevelOne() {
        addRoundHitbox(16, new Point(32, 32), true, "ladder");
        addRoundHitbox(16, new Point(32, 32), false, "");
        addSpriteManager(ioStatus.OFF);
        getSpriteManager().addSprite(SpriteSheet.DUNGEON, FourDir.RIGHT, 128 * 4, 96 * 4, 16 * 4, 16 * 4, 0, 0, 1, ioStatus.OFF);
        getSpriteManager().addSprite(SpriteSheet.DUNGEON, FourDir.RIGHT, 208 * 4, 96 * 4, 16 * 4, 16 * 4, 0, 0, 2, ioStatus.ON);
    }

    @Override
    public void lowPrioUpdate() {
        if (isON) {
            getSpriteManager().setStatus(ioStatus.ON);
        } else {
            int counter = 0;
            for (int i = 0; i < GameController.getCurrScene().OC.units.size(); i++) {
                if (GameController.getCurrScene().OC.units.get(i).getClass().getSimpleName().equals("LevelOneEnemyOne")) {
                    if (!GameController.getCurrScene().OC.units.get(i).isActive) {
                        counter++;
                    }
                }
            }
            if(counter == 6){
                isON = true;
            }
        }
    }
    
    @Override
    public void triggered(String mess, Hitbox self, Hitbox hb){
        if(isON){
            if(hb.body.getClass().getSimpleName().equals("MainCharacter")){
                GameController.changeScene(Scenes.LevelOne);
            }
        }
    }
}
