/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects.Enemies;

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
public class LevelOneEnemyOne extends BaseObject {

    BaseObject Target;
    double distanceToTarget = 0;
    int chaseRange = 100;
    public int speed = 2;
    int hp = 5;
    long lastHitted = 0;

    public LevelOneEnemyOne() {
        addPhysics();
        getPhysics().gravity = false;
//        addSquareHitbox(56, 64, new Point(4, 0), false);
        addRoundHitbox(32, new Point(32, 32), false, "");
//        addRoundHitbox(40, new Point(32,32), true, "hallo");
        addSpriteManager(MoveStatus.IDLE);
        getSpriteManager().addSprite(SpriteSheet.BLUEKNIGHTANIM_HIGHRES, FourDir.RIGHT, 160, 32, 64, 64, 64, 0, 2, MoveStatus.SOUTH);
        getSpriteManager().addSprite(SpriteSheet.BLUEKNIGHTANIM_HIGHRES, FourDir.RIGHT, 160, 160, 64, 64, 64, 0, 2, MoveStatus.EAST);
        getSpriteManager().addSprite(SpriteSheet.BLUEKNIGHTANIM_HIGHRES, FourDir.RIGHT, 160, 416, 64, 64, 64, 0, 2, MoveStatus.NORTH);
        getSpriteManager().addSprite(SpriteSheet.BLUEKNIGHTANIM_HIGHRES, FourDir.RIGHT, 160, 672, 64, 64, 64, 0, 2, MoveStatus.WEST);
        getSpriteManager().addSprite(SpriteSheet.BLUEKNIGHTANIM_HIGHRES, FourDir.RIGHT, 32, 32, 64, 64, 0, 0, 1, MoveStatus.IDLE);
    }

    public void loseHP(int hp){
        if(lastHitted + 1000 < System.currentTimeMillis()){
            this.hp = this.hp - hp;
            lastHitted = System.currentTimeMillis();
        }
    }
    
    @Override
    public void callUpdate() {
        if (Target == null) {
            Target = GameController.getCurrScene().OC.findObject("MainCharacter").get(0);
        }
        if (distanceToTarget < chaseRange) {
            if (Target.getCords().x > getCords().x + 10) {
                setCords(getCords().x + speed, getCords().y);
                getSpriteManager().setStatus(MoveStatus.EAST);

            } else if (Target.getCords().x + 10 < getCords().x) {
                setCords(getCords().x - speed, getCords().y);
                getSpriteManager().setStatus(MoveStatus.WEST);

            }
            if (Target.getCords().y > getCords().y + 10) {
                setCords(getCords().x, getCords().y + speed);
                getSpriteManager().setStatus(MoveStatus.SOUTH);

            } else if (Target.getCords().y + 10 < getCords().y) {
                setCords(getCords().x, getCords().y - speed);
                getSpriteManager().setStatus(MoveStatus.NORTH);

            }
        } else {
            getSpriteManager().setStatus(MoveStatus.IDLE);
        }
    }

    @Override
    public void lowPrioUpdate() {
        if (Target == null) {
            Target = GameController.getCurrScene().OC.findObject("MainCharacter").get(0);
        }
        distanceToTarget = Math.sqrt(((Target.getCords().x - getCords().x) * (Target.getCords().x - getCords().x)) + ((Target.getCords().y - getCords().y) * (Target.getCords().y - getCords().y)));
        if(hp < 1){
            isActive = false;
        }
    }

    @Override
    public void triggered(String id, Hitbox selv, Hitbox hb){
        if(hb.id.equals("new")){
            loseHP(1);
        }
    }
}
