/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Components.BaseObject;
import Components.Hitbox;
import Components.Physics;
import Components.Sprite;
import Components.SquareHitbox;
import Controllers.GameController;
import static Controllers.SpriteController.loadSpriteRoll;
import Interfaces.PlayerOne;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import Interfaces.Plottable;
import enums.FourDir;
import enums.MoveStatus;
import enums.SpriteSheet;
import java.util.Date;

/**
 *
 * @author frederik.larsen
 */
public class MainCharacter extends BaseObject implements Plottable, PlayerOne {

    public int speed = 1;
    public int hitCooldown = 1;
    public long lastHit = 0;

    public MainCharacter() {
        lastHit = System.currentTimeMillis();
        addSpriteManager(MoveStatus.NORTH);
       getSpriteManager().addSprite(SpriteSheet.KNIGHTANIM, FourDir.RIGHT, 40, 8, 16, 16,16,0, 2, MoveStatus.SOUTH, 16);
       getSpriteManager().addSprite(SpriteSheet.KNIGHTANIM, FourDir.RIGHT, 40, 40, 16, 16,16,0, 2, MoveStatus.EAST, 16);
       getSpriteManager().addSprite(SpriteSheet.KNIGHTANIM, FourDir.RIGHT, 40, 104, 16, 16,16,0, 2, MoveStatus.NORTH, 16);
       getSpriteManager().addSprite(SpriteSheet.KNIGHTANIM, FourDir.RIGHT, 40, 168, 16, 16,16,0, 2, MoveStatus.WEST, 16);
       getSpriteManager().addSprite(SpriteSheet.KNIGHTANIM, FourDir.RIGHT, 8, 8, 16, 16, 0, 0, 1, MoveStatus.IDLE, 16);

        // getSpriteManager().addSprite(SpriteSheet.KNIGHTANIM_HIGHRES, FourDir.RIGHT, 160, 32, 64, 64, 64, 0, 2, MoveStatus.SOUTH);
        // getSpriteManager().addSprite(SpriteSheet.KNIGHTANIM_HIGHRES, FourDir.RIGHT, 160, 160, 64, 64, 64, 0, 2, MoveStatus.EAST);
        // getSpriteManager().addSprite(SpriteSheet.KNIGHTANIM_HIGHRES, FourDir.RIGHT, 160, 416, 64, 64, 64, 0, 2, MoveStatus.NORTH);
        // getSpriteManager().addSprite(SpriteSheet.KNIGHTANIM_HIGHRES, FourDir.RIGHT, 160, 672, 64, 64, 64, 0, 2, MoveStatus.WEST);
        // getSpriteManager().addSprite(SpriteSheet.KNIGHTANIM_HIGHRES, FourDir.RIGHT, 32, 32, 64, 64, 0, 0, 1, MoveStatus.IDLE);
        // getSpriteManager().addSprite(SpriteSheet.FRED, FourDir.DOWN, 128, 0, 32, 32, 0, 0, 2, MoveStatus.SOUTH);
        // getSpriteManager().addSprite(SpriteSheet.FRED, FourDir.DOWN, 160, 160, 64, 64, 64, 0, 2, MoveStatus.EAST);
        // getSpriteManager().addSprite(SpriteSheet.FRED, FourDir.DOWN, 160, 416, 64, 64, 64, 0, 2, MoveStatus.NORTH);
        // getSpriteManager().addSprite(SpriteSheet.FRED, FourDir.DOWN, 160, 672, 64, 64, 64, 0, 2, MoveStatus.WEST);
        // getSpriteManager().addSprite(SpriteSheet.FRED, FourDir.DOWN, 32, 32, 64, 64, 0, 0, 1, MoveStatus.IDLE);

        addPhysics();
        //getPhysics().setAcceleration(new Point(1,1));
//        addSquareHitbox(56, 64,new Point(4,0),false);
        addRoundHitbox(32, new Point(32, 32), false, "");
//        addRoundHitbox(32, true, "new");
        addSquareHitbox(60, 60, true, "new");
        getHitbox("new").Deactivate();

        getPhysics().gravity = false;

    }

    @Override
    public void callUpdate() {
        // setCords(getCords().x + speed, getCords().y - speed);
        // getSpriteManager().setStatus(MoveStatus.SOUTH);
    }

    @Override
    public void triggered(String mess, Hitbox self, Hitbox hb) {
        if (!hb.body.getClass().getSimpleName().equals("WallTileLevelOne")) {
            if (self.cords.y == -40) {
                hb.body.getPhysics().applyForce(new Point(0, -7));

            }
            if (self.cords.y == 40) {
                hb.body.getPhysics().applyForce(new Point(0, +7));

            }
            if (self.cords.x == 40) {
                hb.body.getPhysics().applyForce(new Point(+7, 0));

            }
            if (self.cords.x == -40) {
                hb.body.getPhysics().applyForce(new Point(-7, 0));

            }
        }
    }

    @Override
    public void lowPrioUpdate() {
        if (lastHit + 250 < System.currentTimeMillis()) {
            Hitbox curr = getHitbox("new");
            curr.Deactivate();
        }
    }

    public void stop() {

    }

    @Override
    public void up() {
        //physics.applyForce(new Point(0, -1));
        setCords(getCords().x, getCords().y - speed);
        getSpriteManager().setStatus(MoveStatus.NORTH);
    }

    @Override
    public void down() {
        //physics.applyForce(new Point(0, 1));
        setCords(getCords().x, getCords().y + speed);
        getSpriteManager().setStatus(MoveStatus.SOUTH);
    }

    @Override
    public void left() {
        //physics.applyForce(new Point(-1, 0));
        setCords(getCords().x - speed, getCords().y);
        getSpriteManager().setStatus(MoveStatus.WEST);
    }

    @Override
    public void right() {
        //physics.applyForce(new Point(1, 0));
        setCords(getCords().x + speed, getCords().y);
        getSpriteManager().setStatus(MoveStatus.EAST);
    }

    @Override
    public void space() {
        getHitbox(null);
    }

    @Override
    public void enter() {
        getHitbox("new").Deactivate();
    }

    @Override
    public void nothing() {
        getSpriteManager().setStatus(MoveStatus.IDLE);
    }

    @Override
    public void w() {
        if (lastHit + hitCooldown * 1000 < System.currentTimeMillis()) {
            SquareHitbox curr = (SquareHitbox) getHitbox("new");
            curr.setCords(new Point(32 - 5, -40));
            curr.width = 10;
            curr.height = 60;
            curr.Activate();
            lastHit = System.currentTimeMillis();
        }
    }

    @Override
    public void s() {
        if (lastHit + hitCooldown * 1000 < System.currentTimeMillis()) {
            SquareHitbox curr = (SquareHitbox) getHitbox("new");
            curr.setCords(new Point(32 - 5, 40));
            curr.width = 10;
            curr.height = 60;
            curr.Activate();
            lastHit = System.currentTimeMillis();
        }
    }

    @Override
    public void a() {
        if (lastHit + hitCooldown * 1000 < System.currentTimeMillis()) {
            SquareHitbox curr = (SquareHitbox) getHitbox("new");
            curr.setCords(new Point(-40, 32 - 5));
            curr.width = 60;
            curr.height = 10;
            curr.Activate();
            lastHit = System.currentTimeMillis();
        }
    }

    @Override
    public void d() {
        if (lastHit + hitCooldown * 1000 < System.currentTimeMillis()) {
            SquareHitbox curr = (SquareHitbox) getHitbox("new");
            curr.setCords(new Point(40, 32 - 5));
            curr.width = 60;
            curr.height = 10;
            curr.Activate();
            lastHit = System.currentTimeMillis();
        }
    }

}
