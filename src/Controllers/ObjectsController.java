/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Components.BaseObject;
import Objects.MainCharacter;
import Objects.Wall;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author frederik.larsen
 */
public class ObjectsController {

    public ArrayList<BaseObject> units = new ArrayList();

    public ObjectsController() {

    }

    public void objectsUpdate() {
        for (int i = 0; i < units.size(); i++) {
            BaseObject currGO = units.get(i);
            if (currGO.getPhysics() != null) {
                updatePhysics(currGO);
            }
        }
    }

    public void solidCollisionDetetection() {
        //System.out.println(units.size());
        for (int j = 0; j < units.size(); j++) {
            BaseObject MainBaseObject = units.get(j);
            //System.out.println(MainBaseObject.getClass().getName());
            if (MainBaseObject.getPhysics() != null && MainBaseObject.getHitbox() != null) {
                if (!MainBaseObject.getPhysics().isSolid) {
                    for (int i = 0; i < units.size(); i++) {
                        BaseObject SecondBaseObject = units.get(i);
                        if (!MainBaseObject.equals(SecondBaseObject)) {
                            if (MainBaseObject.getHitbox() != null && SecondBaseObject.getHitbox() != null) {
                                if (MainBaseObject.getCords().x < SecondBaseObject.getCords().x + SecondBaseObject.getHitbox().width && MainBaseObject.getCords().x + MainBaseObject.getHitbox().width > SecondBaseObject.getCords().x && MainBaseObject.getCords().y < SecondBaseObject.getCords().y + SecondBaseObject.getHitbox().height && MainBaseObject.getCords().y + MainBaseObject.getHitbox().height > SecondBaseObject.getCords().y) {
                                    Point aPoint = MainBaseObject.getHitbox().getOverlapped(SecondBaseObject.getHitbox());

                                    if (aPoint.x < aPoint.y) {
                                        if (MainBaseObject.getCords().x > SecondBaseObject.getCords().x) {
                                            MainBaseObject.setCords(MainBaseObject.getCords().x + aPoint.x, MainBaseObject.getCords().y);
                                            MainBaseObject.getPhysics().setVelocity(new Point(0, MainBaseObject.getPhysics().getVelocity().y));
                                        } else {
                                            MainBaseObject.setCords(MainBaseObject.getCords().x - aPoint.x, MainBaseObject.getCords().y);
                                            MainBaseObject.getPhysics().setVelocity(new Point(0, MainBaseObject.getPhysics().getVelocity().y));
                                        }
                                    } else if (MainBaseObject.getCords().y > SecondBaseObject.getCords().y) {
                                        MainBaseObject.setCords(MainBaseObject.getCords().x, MainBaseObject.getCords().y + aPoint.y);
                                        MainBaseObject.getPhysics().setVelocity(new Point(MainBaseObject.getPhysics().getVelocity().x, 0));
                                    } else {
                                        MainBaseObject.setCords(MainBaseObject.getCords().x, MainBaseObject.getCords().y - aPoint.y);
                                        //MainBaseObject.getPhysics().gravity = false;
                                        MainBaseObject.getPhysics().setVelocity(new Point(MainBaseObject.getPhysics().getVelocity().x, 0));
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void updatePhysics(BaseObject currGO) {
        if (currGO.getPhysics().resistenceX) {
            if (currGO.getPhysics().getVelocity().x < 2 && currGO.getPhysics().getVelocity().x > -2) {
                currGO.getPhysics().getVelocity().x = 0;
            } else {
                int dirX = 0;
                if (currGO.getPhysics().getVelocity().x != 0) {
                    dirX = -currGO.getPhysics().getVelocity().x / 2;
                }
                currGO.getPhysics().applyForce(new Point(dirX, 0));
            }
        }
        if (currGO.getPhysics().gravity) {
            currGO.getPhysics().applyForce(new Point(0, 2));
        } else if (currGO.getPhysics().resistenceY) {
            if (currGO.getPhysics().getVelocity().y < 2 && currGO.getPhysics().getVelocity().y > -2) {
                currGO.getPhysics().getVelocity().y = 0;
            } else {
                int dirY = 0;
                if (currGO.getPhysics().getVelocity().y != 0) {
                    dirY = -currGO.getPhysics().getVelocity().y / 2;
                }
                currGO.getPhysics().applyForce(new Point(0, dirY));
            }
        }
    }

}
