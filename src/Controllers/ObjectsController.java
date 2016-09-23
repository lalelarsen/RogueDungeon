/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Objects.Block;
import Components.BaseObject;
import Objects.MainCharacter;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author frederik.larsen
 */
public class ObjectsController {

    public ArrayList<BaseObject> units = new ArrayList();
    public MainCharacter Hero = new MainCharacter();
    public Block block = new Block();
    public Block block2 = new Block();

    public ObjectsController() {
        block.setCords(300, 300);
        block2.setCords(40, 350);
        Hero.setCords(50, 50);
        units.add(Hero);
        units.add(block);
        units.add(block2);
    }

    public void bounce() {
        for (int i = 0; i < units.size(); i++) {
            BaseObject currGO = units.get(i);
            if (currGO.getCords().y > 150) {
                currGO.getPhysics().gravity = false;
                currGO.setForceDir(new Point(currGO.getForceDir().x, 0));
                currGO.setCords(currGO.getCords().x, currGO.lastY);
                //currGO.getPhysics().applyForce(new Point(0, (-Math.abs(currGO.getForceDir().y) * 2) + 2));
            }
            if (currGO.getCords().y < 149) {
                currGO.getPhysics().gravity = true;

            }
        }
    }

    public void objectsUpdate() {
        for (int i = 0; i < units.size(); i++) {
            BaseObject currGO = units.get(i);
            updateGravAndResis(currGO);
        }
    }
    int c = 0;

    public void solidCollisionDetetection() {
        for (int j = 0; j < units.size(); j++) {
            BaseObject MainBaseObject = units.get(j);
            if (!MainBaseObject.getPhysics().isSolid) {
                for (int i = 0; i < units.size(); i++) {
                    BaseObject SecondBaseObject = units.get(i);
                    if (!MainBaseObject.equals(SecondBaseObject)) {
                        if (MainBaseObject.getCords().x < SecondBaseObject.getCords().x + SecondBaseObject.getHitbox().width && MainBaseObject.getCords().x + MainBaseObject.getHitbox().width > SecondBaseObject.getCords().x && MainBaseObject.getCords().y < SecondBaseObject.getCords().y + SecondBaseObject.getHitbox().height && MainBaseObject.getCords().y + MainBaseObject.getHitbox().height > SecondBaseObject.getCords().y) {
//                            ArrayList<Integer> xCords = new ArrayList();
//                            ArrayList<Integer> yCords = new ArrayList();
//                            ArrayList<Point> goHB = go.getHitbox().getHitboxCords();
//                            ArrayList<Point> currGoHB = currGO.getHitbox().getHitboxCords();
//
//                            for (int k = 0; k < goHB.size(); k++) {
//                                for (int l = 0; l < currGoHB.size(); l++) {
//                                    if (goHB.get(k).equals(currGoHB.get(l))) {
//                                        if (!xCords.contains(goHB.get(k).x)) {
//                                            xCords.add(goHB.get(k).x);
//                                        }
//                                        if (!yCords.contains(goHB.get(k).y)) {
//                                            yCords.add(goHB.get(k).y);
//                                        }
//                                    }
//                                }
//                            }
                            Point aPoint = MainBaseObject.getHitbox().getOverlapped(SecondBaseObject.getHitbox());
                            
                            if (aPoint.x < aPoint.y) {
                                if (MainBaseObject.getCords().x > SecondBaseObject.getCords().x) {
                                    MainBaseObject.setCords(MainBaseObject.getCords().x + aPoint.x, MainBaseObject.getCords().y);
                                    MainBaseObject.setForceDir(new Point(0, MainBaseObject.getForceDir().y));
                                } else {
                                    MainBaseObject.setCords(MainBaseObject.getCords().x - aPoint.x, MainBaseObject.getCords().y);
                                    MainBaseObject.setForceDir(new Point(0, MainBaseObject.getForceDir().y));
                                }
                            } else if (MainBaseObject.getCords().y > SecondBaseObject.getCords().y) {
                                MainBaseObject.setCords(MainBaseObject.getCords().x, MainBaseObject.getCords().y + aPoint.y);
                                MainBaseObject.setForceDir(new Point(MainBaseObject.getForceDir().x, 0));
                            } else {
                                MainBaseObject.setCords(MainBaseObject.getCords().x, MainBaseObject.getCords().y - aPoint.y);
                                //MainBaseObject.getPhysics().gravity = false;
                                MainBaseObject.setForceDir(new Point(MainBaseObject.getForceDir().x, 0));
                            }
                        }
                    }
                }
            }
        }
    }

    public void updateGravAndResis(BaseObject currGO) {
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
        if (currGO.getPhysics().gravity && !currGO.getPhysics().grounded) {
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
