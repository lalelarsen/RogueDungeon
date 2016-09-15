/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Objects.GameObject;
import Objects.MainCharacter;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author frederik.larsen
 */
public class ObjectsController {

    public ArrayList<GameObject> units = new ArrayList();
    public MainCharacter Hero = new MainCharacter();

    public ObjectsController() {
        Hero.setCords(50, 50);
        units.add(Hero);
    }

    public void bounce() {
        for (int i = 0; i < units.size(); i++) {
            GameObject currGO = units.get(i);
            if (currGO.getCords().y > 150) {
                currGO.getPhysics().gravity =false;
                currGO.setForceDir(new Point(currGO.getForceDir().x,0));
                currGO.setCords(currGO.getCords().x, currGO.lastY);
                //currGO.getPhysics().applyForce(new Point(0, (-Math.abs(currGO.getForceDir().y) * 2) + 2));
            }
            if (currGO.getCords().y < 149) {
                System.out.println("op");
                currGO.getPhysics().gravity =true;
               
            } 
            System.out.println(currGO.getCords() + " last: "  + currGO.lastY);
        }
    }

    public void updateGravAndResis() {
        for (int i = 0; i < units.size(); i++) {
            GameObject currGO = units.get(i);
            if (currGO.getPhysics().resistenceX) {
                if (currGO.getForceDir().x < 2 && currGO.getForceDir().x > -2) {
                    currGO.getForceDir().x = 0;
                } else {
                    int dirX = 0;
                    if (currGO.getForceDir().x < 0) {
                        dirX = -currGO.getForceDir().x / 2;
                    }
                    if (currGO.getForceDir().x > 0) {
                        dirX = -currGO.getForceDir().x / 2;
                    }
                    currGO.getPhysics().applyForce(new Point(dirX, 0));
                }
            }
            if (currGO.getPhysics().gravity) {
                currGO.getPhysics().applyForce(new Point(0, 2));
            } else if (currGO.getPhysics().resistenceY) {
                if (currGO.getForceDir().y < 2 && currGO.getForceDir().y > -2) {
                    currGO.getForceDir().y = 0;
                } else {
                    int dirY = 0;
                    if (currGO.getForceDir().y < 0) {
                        dirY = -currGO.getForceDir().y / 2;
                    }
                    if (currGO.getForceDir().y > 0) {
                        dirY = -currGO.getForceDir().y / 2;
                    }
                    currGO.getPhysics().applyForce(new Point(0, dirY));
                }
            }
        }
    }
}
