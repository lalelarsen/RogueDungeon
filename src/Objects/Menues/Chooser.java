/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects.Menues;

import Components.BaseObject;
import Components.BaseObject;
import Interfaces.MenuInterface;
import Interfaces.PlayerOne;
import enums.FourDir;
import enums.MoveStatus;
import enums.SpriteSheet;
import java.awt.Point;
import javax.imageio.ImageIO;

/**
 *
 * @author Frederik
 */
public class Chooser extends BaseObject implements PlayerOne {

    MenuInterface m;
    Point[] options;
    int counter = 0;
    long lastPressed;

    public Chooser(MenuInterface m, SpriteSheet s) {
        this.m = m;
        options = m.getOptions();
        loadImage(s);
        setCords(options[counter].x, options[counter].y);
        lastPressed = System.currentTimeMillis();
    }

    public void loadImage(SpriteSheet s) {
        switch (s) {
            case POINTER:
                try {
                    setImage(ImageIO.read(this.getClass().getResourceAsStream("/pictures/Pointer.png")));
                } catch (Exception e) {
                }
                break;
        }
    }

    public boolean cooldownStatus() {
        boolean b = lastPressed + 100 < System.currentTimeMillis();
        if (b) {
            lastPressed = System.currentTimeMillis();
        }
        return b;
    }

    @Override
    public void up() {
        if (cooldownStatus()) {
            counter--;
            if (counter == -1) {
                counter = m.getOptions().length - 1;
            }
            setCords(options[counter].x, options[counter].y);
        }
    }

    @Override
    public void down() {
        if (cooldownStatus()) {
            counter++;
            if (counter == m.getOptions().length) {
                counter = 0;
            }
            setCords(options[counter].x, options[counter].y);
        }
    }

    @Override
    public void left() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void right() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void space() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enter() {
        switch (counter) {
            case 0:
                m.option1();
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }

    @Override
    public void nothing() {

    }

    @Override
    public void w() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void s() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void a() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void d() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
