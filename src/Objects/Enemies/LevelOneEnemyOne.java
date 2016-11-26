/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects.Enemies;

import Components.BaseObject;
import Controllers.GameController;
import enums.FourDir;
import enums.MoveStatus;
import enums.SpriteSheet;
import java.awt.Point;

/**
 *
 * @author Frederik
 */
public class LevelOneEnemyOne extends BaseObject {

    BaseObject Target;
    double distanceToTarget = 0;
    public int speed = 2;

    public LevelOneEnemyOne() {

        addPhysics();
        addHitbox(56, 64, new Point(4, 0), false);
        addSpriteManager(MoveStatus.IDLE);
        getSpriteManager().addSprite(SpriteSheet.BLUEKNIGHTANIM_HIGHRES, FourDir.RIGHT, 160, 32, 64, 64, 64, 0, 2, MoveStatus.SOUTH);
        getSpriteManager().addSprite(SpriteSheet.BLUEKNIGHTANIM_HIGHRES, FourDir.RIGHT, 160, 160, 64, 64, 64, 0, 2, MoveStatus.EAST);
        getSpriteManager().addSprite(SpriteSheet.BLUEKNIGHTANIM_HIGHRES, FourDir.RIGHT, 160, 416, 64, 64, 64, 0, 2, MoveStatus.NORTH);
        getSpriteManager().addSprite(SpriteSheet.BLUEKNIGHTANIM_HIGHRES, FourDir.RIGHT, 160, 672, 64, 64, 64, 0, 2, MoveStatus.WEST);
        getSpriteManager().addSprite(SpriteSheet.BLUEKNIGHTANIM_HIGHRES, FourDir.RIGHT, 32, 32, 64, 64, 0, 0, 1, MoveStatus.IDLE);
    }

    @Override
    public void callUpdate() {
        if (Target == null) {
            Target = GameController.getCurrScene().OC.findObject("MainCharacter").get(0);
        }
        if (distanceToTarget < 300) {
            if (Target.getCords().y > getCords().y) {
                setCords(getCords().x, getCords().y + speed);
                getSpriteManager().setStatus(MoveStatus.SOUTH);
            } else {
                setCords(getCords().x, getCords().y - speed);
                getSpriteManager().setStatus(MoveStatus.NORTH);
            }
            if (Target.getCords().x > getCords().x) {
                setCords(getCords().x + speed, getCords().y);
                getSpriteManager().setStatus(MoveStatus.SOUTH);
            } else {
                setCords(getCords().x - speed, getCords().y);
                getSpriteManager().setStatus(MoveStatus.NORTH);
            }
        } else {
            getSpriteManager().setStatus(MoveStatus.IDLE);
        }
    }

    @Override
    public void lowPrioUpdate() {
        distanceToTarget = Math.sqrt(((Target.getCords().x - getCords().x) * (Target.getCords().x - getCords().x)) + ((Target.getCords().y - getCords().y) * (Target.getCords().y - getCords().y)));
    }

}
