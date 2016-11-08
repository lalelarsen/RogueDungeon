/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects.Menues.MainMenu;

import Components.BaseObject;
import Controllers.GameController;
import Interfaces.MenuInterface;
import enums.Scenes;
import java.awt.Point;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Frederik
 */
public class MainMenu extends BaseObject implements MenuInterface {

    //options

    Point[] options = {new Point(0, 100), new Point(0, 200), new Point(0, 300)};

    public MainMenu() {
        setCords(0, 0);
        try {
            setImage(ImageIO.read(this.getClass().getResourceAsStream("/pictures/MainMenu.png")));
        } catch (Exception e) {
        }
    }
    
    @Override
    public Point[] getOptions() {
        return options;
    }

    @Override
    public void option1() {
        GameController.changeScene(Scenes.LevelOne);
    }

    @Override
    public void option2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void option3() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void option4() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void option5() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void option6() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
