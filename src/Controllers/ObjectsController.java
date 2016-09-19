/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Objects.Block;
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
    public Block block = new Block();

    public ObjectsController() {
        block.setCords(300, 300);
        Hero.setCords(50, 50);
        units.add(Hero);
        units.add(block);
    }

    public void bounce() {
        for (int i = 0; i < units.size(); i++) {
            GameObject currGO = units.get(i);
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
            GameObject currGO = units.get(i);
            updateGravAndResis(currGO);
        }
    }
    int c = 0;

    public void solidCollisionDetetection() {
        for (int j = 0; j < units.size(); j++) {
            GameObject go = units.get(j);
            if (!go.getPhysics().isSolid) {
                for (int i = 0; i < units.size(); i++) {
                    GameObject currGO = units.get(i);
                    if (!go.equals(currGO)) {
                        if (go.getCords().x < currGO.getCords().x + currGO.width && go.getCords().x + go.width > currGO.getCords().x && go.getCords().y < currGO.getCords().y + currGO.height && go.getCords().y + go.height > currGO.getCords().y) {
                            ArrayList<Integer> xCords = new ArrayList();
                            ArrayList<Integer> yCords = new ArrayList();
                            ArrayList<Point> goHB = go.getHitboxCords();
                            ArrayList<Point> currGoHB = currGO.getHitboxCords();
                            for (int k = 0; k < goHB.size(); k++) {
                                for (int l = 0; l < currGoHB.size(); l++) {
                                    if (goHB.get(k).equals(currGoHB.get(l))) {
                                        if (!xCords.contains(goHB.get(k).x)) {
                                            xCords.add(goHB.get(k).x);
                                        }
                                        if (!yCords.contains(goHB.get(k).y)) {
                                            yCords.add(goHB.get(k).y);
                                        }
                                    }
                                }
                            }
                            if (xCords.size() < yCords.size()) {
                                if (go.getCords().x > currGO.getCords().x) {
                                    go.setCords(go.getCords().x + xCords.size(), go.getCords().y);
                                    go.setForceDir(new Point(0,go.getForceDir().y));
                                } else {
                                    go.setCords(go.getCords().x - xCords.size(), go.getCords().y);
                                    go.setForceDir(new Point(0,go.getForceDir().y));
                                }
                            } else if (go.getCords().y > currGO.getCords().y) {
                                go.setCords(go.getCords().x, go.getCords().y + yCords.size());
                                go.setForceDir(new Point(go.getForceDir().x,0));
                            } else {
                                go.setCords(go.getCords().x, go.getCords().y - yCords.size());
                                go.setForceDir(new Point(go.getForceDir().x,0));
                            }
                        }
                    }
                }
            }
        }
    }

    public void updateGravAndResis(GameObject currGO) {
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
