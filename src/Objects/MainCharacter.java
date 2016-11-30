/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Components.BaseObject;
import Components.Physics;
import Components.Sprite;
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
import javafx.scene.chart.PieChart;

/**
 *
 * @author frederik.larsen
 */
public class MainCharacter extends BaseObject implements Plottable, PlayerOne {


    public int speed = 4;

    public MainCharacter() {

        addSpriteManager(MoveStatus.NORTH);
//        getSpriteManager().addSprite(SpriteSheet.KNIGHTANIM, FourDir.RIGHT, 40, 8, 16, 16,16,0, 2, PlayerStatus.SOUTH);
//        getSpriteManager().addSprite(SpriteSheet.KNIGHTANIM, FourDir.RIGHT, 40, 40, 16, 16,16,0, 2, PlayerStatus.EAST);
//        getSpriteManager().addSprite(SpriteSheet.KNIGHTANIM, FourDir.RIGHT, 40, 104, 16, 16,16,0, 2, PlayerStatus.NORTH);
//        getSpriteManager().addSprite(SpriteSheet.KNIGHTANIM, FourDir.RIGHT, 40, 168, 16, 16,16,0, 2, PlayerStatus.WEST);
//        getSpriteManager().addSprite(SpriteSheet.KNIGHTANIM, FourDir.RIGHT, 8, 8, 16, 16, 0, 0, 1, PlayerStatus.IDLE);

        getSpriteManager().addSprite(SpriteSheet.KNIGHTANIM_HIGHRES, FourDir.RIGHT, 160, 32, 64, 64, 64, 0, 2, MoveStatus.SOUTH);
        getSpriteManager().addSprite(SpriteSheet.KNIGHTANIM_HIGHRES, FourDir.RIGHT, 160, 160, 64, 64, 64, 0, 2, MoveStatus.EAST);
        getSpriteManager().addSprite(SpriteSheet.KNIGHTANIM_HIGHRES, FourDir.RIGHT, 160, 416, 64, 64, 64, 0, 2, MoveStatus.NORTH);
        getSpriteManager().addSprite(SpriteSheet.KNIGHTANIM_HIGHRES, FourDir.RIGHT, 160, 672, 64, 64, 64, 0, 2, MoveStatus.WEST);
        getSpriteManager().addSprite(SpriteSheet.KNIGHTANIM_HIGHRES, FourDir.RIGHT, 32, 32, 64, 64, 0, 0, 1, MoveStatus.IDLE);

        addPhysics();
        //getPhysics().setAcceleration(new Point(1,1));
//        addSquareHitbox(56, 64,new Point(4,0),false);
        addRoundHitbox(32, new Point(32,32), false);
        
        
        getPhysics().gravity = false;


    }

    public void stop() {

    }

    @Override
    public void up() {
        //physics.applyForce(new Point(0, -1));
        setCords(getCords().x, getCords().y-speed);
        getSpriteManager().setStatus(MoveStatus.NORTH);
    }

    @Override
    public void down() {
        //physics.applyForce(new Point(0, 1));
        setCords(getCords().x, getCords().y+speed);
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
        
    }

    @Override
    public void enter() {
        
    }

    @Override
    public void nothing() {
        getSpriteManager().setStatus(MoveStatus.IDLE);
    }

}
