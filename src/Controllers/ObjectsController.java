/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Components.BaseObject;
import Components.Hitbox;
import Components.RoundHitbox;
import Components.SquareHitbox;
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
    public ArrayList<BaseObject> bgUnits = new ArrayList();

    public ObjectsController() {

    }

    public void objectsUpdate() {
        for (int i = 0; i < units.size(); i++) {
            BaseObject currGO = units.get(i);
            if (currGO.getPhysics() != null && currGO.isActive) {
                updatePhysics(currGO);
            }
        }
    }

    public void solidCollisionDetetection() {
        for (int j = 0; j < units.size(); j++) {
            BaseObject MainBaseObject = units.get(j);
            if (MainBaseObject.getPhysics() != null && !MainBaseObject.getHitboxes().isEmpty() && MainBaseObject.isActive) {
                if (!MainBaseObject.getPhysics().immovable) {
                    for (int i = 0; i < units.size(); i++) {
                        BaseObject SecondBaseObject = units.get(i);
                        if (SecondBaseObject.isActive) {
                            if (!MainBaseObject.equals(SecondBaseObject)) {
                                if (!SecondBaseObject.getHitboxes().isEmpty()) {
                                    for (int k = 0; k < MainBaseObject.getHitboxes().size(); k++) {
//                                    if (!MainBaseObject.getHitboxes().get(k).isTrigger) {
                                        Hitbox MainHB = MainBaseObject.getHitboxes().get(k);
                                        for (int l = 0; l < SecondBaseObject.getHitboxes().size(); l++) {
//                                            if (!SecondBaseObject.getHitboxes().get(l).isTrigger) {
                                            Hitbox SecondHB = SecondBaseObject.getHitboxes().get(l);

                                            if (MainHB.getClass().getSimpleName().equals("SquareHitbox") && SecondHB.getClass().getSimpleName().equals("SquareHitbox")) {
                                                squareHitboxOnSquareHitbox((SquareHitbox) MainHB, (SquareHitbox) SecondHB);
                                            } else if (MainHB.getClass().getSimpleName().equals("RoundHitbox") && SecondHB.getClass().getSimpleName().equals("SquareHitbox")) {
                                                circleHitboxOnSquareHitbox((RoundHitbox) MainHB, (SquareHitbox) SecondHB);
                                            } else if (MainHB.getClass().getSimpleName().equals("SquareHitbox") && SecondHB.getClass().getSimpleName().equals("RoundHitbox")) {

                                            } else if (MainHB.getClass().getSimpleName().equals("RoundHitbox") && SecondHB.getClass().getSimpleName().equals("RoundHitbox")) {
                                                circleHitboxOnCircleHitbox((RoundHitbox) MainHB, (RoundHitbox) SecondHB);
                                            }
//                                            }
                                        }
//                                    }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void circleHitboxOnSquareHitbox(RoundHitbox mainHB, SquareHitbox SecondHB) {
        int thisX = mainHB.body.getCords().x + mainHB.cords.x - mainHB.radius;
        int thisY = mainHB.body.getCords().y + mainHB.cords.y - mainHB.radius;

        if (thisX < SecondHB.getBody().getCords().x + SecondHB.cords.x + SecondHB.width && thisX + mainHB.radius * 2 > SecondHB.getBody().getCords().x + SecondHB.cords.x && thisY < SecondHB.getBody().getCords().y + SecondHB.cords.y + SecondHB.height && thisY + mainHB.radius * 2 > SecondHB.getBody().getCords().y + SecondHB.cords.y) {
            if (!mainHB.isTrigger && !SecondHB.isTrigger) {
                Point p = mainHB.getOffsetSquare(SecondHB);
                mainHB.body.setCords(mainHB.body.getCords().x + p.x, mainHB.body.getCords().y + p.y);
            } else if (mainHB.isTrigger || SecondHB.isTrigger) {
                mainHB.triggered(SecondHB);
                SecondHB.triggered(mainHB);
            }
        }
    }

    public void squareHitboxOnSquareHitbox(SquareHitbox MainHB, SquareHitbox SecondHB) {

        if (MainHB.getBody().getCords().x + MainHB.cords.x < SecondHB.getBody().getCords().x + SecondHB.cords.x + SecondHB.width && MainHB.getBody().getCords().x + MainHB.cords.x + MainHB.width > SecondHB.getBody().getCords().x + SecondHB.cords.x && MainHB.getBody().getCords().y + MainHB.cords.y < SecondHB.getBody().getCords().y + SecondHB.cords.y + SecondHB.height && MainHB.getBody().getCords().y + MainHB.cords.y + MainHB.height > SecondHB.getBody().getCords().y + SecondHB.cords.y) {
            if (!MainHB.isTrigger && !SecondHB.isTrigger) {
                Point aPoint = MainHB.getOverlappedSquare(SecondHB);
                if (aPoint.x < aPoint.y) {
                    if (MainHB.getBody().getCords().x + MainHB.cords.x > SecondHB.getBody().getCords().x + SecondHB.cords.x) {
                        MainHB.getBody().setCords(MainHB.getBody().getCords().x + aPoint.x, MainHB.getBody().getCords().y);
//                            MainHB.getBody().getPhysics().setVelocity(new Point(0, MainHB.getBody().getPhysics().getVelocity().y));
                    } else {
                        MainHB.getBody().setCords(MainHB.getBody().getCords().x - aPoint.x, MainHB.getBody().getCords().y);
//                            MainHB.getBody().getPhysics().setVelocity(new Point(0, MainHB.getBody().getPhysics().getVelocity().y));
                    }
                } else if (MainHB.getBody().getCords().y + MainHB.cords.y > SecondHB.getBody().getCords().y + SecondHB.cords.y) {
                    MainHB.getBody().setCords(MainHB.getBody().getCords().x, MainHB.getBody().getCords().y + aPoint.y);
//                        MainHB.getBody().getPhysics().setVelocity(new Point(MainHB.getBody().getPhysics().getVelocity().x, 0));
                } else {
                    MainHB.getBody().setCords(MainHB.getBody().getCords().x, MainHB.getBody().getCords().y - aPoint.y);
//                        MainHB.getBody().getPhysics().setVelocity(new Point(MainHB.getBody().getPhysics().getVelocity().x, 0));
                }

            } else if (MainHB.isTrigger || SecondHB.isTrigger) {
                MainHB.triggered(SecondHB);
                SecondHB.triggered(MainHB);
            }
        }
    }

    public void circleHitboxOnCircleHitbox(RoundHitbox MainHB, RoundHitbox SecondHB) {

        int thisX = MainHB.body.getCords().x + MainHB.cords.x;
        int thisY = MainHB.body.getCords().y + MainHB.cords.y;
        int targetX = SecondHB.body.getCords().x + SecondHB.cords.x;
        int targetY = SecondHB.body.getCords().y + SecondHB.cords.y;
        double dis = Math.sqrt(((targetX - thisX) * (targetX - thisX)) + ((targetY - thisY) * (targetY - thisY)));
        if (dis <= MainHB.radius + SecondHB.radius) {
            if (!MainHB.isTrigger && !SecondHB.isTrigger) {
                int offset = MainHB.getOffsetRound(SecondHB, dis);
                if (thisX > targetX) {
                    if (thisY > targetY) {
                        MainHB.body.setCords(MainHB.body.getCords().x + offset, MainHB.body.getCords().y + offset);

                    } else {
                        MainHB.body.setCords(MainHB.body.getCords().x + offset, MainHB.body.getCords().y - offset);

                    }
                } else {
                    if (thisY > targetY) {
                        MainHB.body.setCords(MainHB.body.getCords().x - offset, MainHB.body.getCords().y + offset);

                    } else {
                        MainHB.body.setCords(MainHB.body.getCords().x - offset, MainHB.body.getCords().y - offset);

                    }
                }

            } else if (MainHB.isTrigger || SecondHB.isTrigger) {
                MainHB.triggered(SecondHB);
                SecondHB.triggered(MainHB);
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

    public void updateUnits() {
        for (int i = 0; i < units.size(); i++) {
            if (units.get(i).isActive) {
                units.get(i).callUpdate();
            }
        }
    }

    public void lowPrioUnitUpdate() {
//        System.out.println("------------------------");
        for (int i = 0; i < units.size(); i++) {
            if(!units.get(i).getClass().getSimpleName().equals("WallTileLevelOne")){
//                System.out.println(units.get(i).getClass().getSimpleName());
            }
            if (units.get(i).isActive) {
                units.get(i).lowPrioUpdate();
            }
        }
    }

    public ArrayList<BaseObject> findObject(String name) {
        ArrayList<BaseObject> list = new ArrayList();
        for (int i = 0; i < units.size(); i++) {
            if (units.get(i).getClass().getSimpleName().equals(name)) {
                list.add(units.get(i));
            }
        }
        return list;
    }

//    public void solidCollisionDetetection() {
//        for (int j = 0; j < units.size(); j++) {
//            BaseObject MainBaseObject = units.get(j);
//            if (MainBaseObject.getPhysics() != null && MainBaseObject.getHitbox() != null) {
//                for (int i = 0; i < units.size(); i++) {
//                    BaseObject SecondBaseObject = units.get(i);
//                    if (!MainBaseObject.equals(SecondBaseObject)) {
//                        if (MainBaseObject.getHitbox() != null && SecondBaseObject.getHitbox() != null) {
//                            if (MainBaseObject.getCords().x < SecondBaseObject.getCords().x + SecondBaseObject.getHitbox().width && MainBaseObject.getCords().x + MainBaseObject.getHitbox().width > SecondBaseObject.getCords().x && MainBaseObject.getCords().y < SecondBaseObject.getCords().y + SecondBaseObject.getHitbox().height && MainBaseObject.getCords().y + MainBaseObject.getHitbox().height > SecondBaseObject.getCords().y) {
//                                Point aPoint = MainBaseObject.getHitbox().getOverlapped(SecondBaseObject.getHitbox());
//
//                                if (aPoint.x < aPoint.y) {
//                                    if (MainBaseObject.getCords().x > SecondBaseObject.getCords().x) {
//                                        MainBaseObject.setCords(MainBaseObject.getCords().x + aPoint.x, MainBaseObject.getCords().y);
//                                        MainBaseObject.getPhysics().setVelocity(new Point(0, MainBaseObject.getPhysics().getVelocity().y));
//                                    } else {
//                                        MainBaseObject.setCords(MainBaseObject.getCords().x - aPoint.x, MainBaseObject.getCords().y);
//                                        MainBaseObject.getPhysics().setVelocity(new Point(0, MainBaseObject.getPhysics().getVelocity().y));
//                                    }
//                                } else if (MainBaseObject.getCords().y > SecondBaseObject.getCords().y) {
//                                    MainBaseObject.setCords(MainBaseObject.getCords().x, MainBaseObject.getCords().y + aPoint.y);
//                                    MainBaseObject.getPhysics().setVelocity(new Point(MainBaseObject.getPhysics().getVelocity().x, 0));
//                                } else {
//                                    MainBaseObject.setCords(MainBaseObject.getCords().x, MainBaseObject.getCords().y - aPoint.y);
//                                    //MainBaseObject.getPhysics().gravity = false;
//                                    MainBaseObject.getPhysics().setVelocity(new Point(MainBaseObject.getPhysics().getVelocity().x, 0));
//                                }
//
//                            }
//                        }
//                    }
//                }
//
//            }
//        }
//    }
//    public void solidCollisionDetetection() {
//        for (int j = 0; j < units.size(); j++) {
//            BaseObject MainBaseObject = units.get(j);
//            if (MainBaseObject.getPhysics() != null && !MainBaseObject.getHitboxes().isEmpty()) {
//                if (!MainBaseObject.getPhysics().immovable) {
//                    for (int i = 0; i < units.size(); i++) {
//                        BaseObject SecondBaseObject = units.get(i);
//                        if (!MainBaseObject.equals(SecondBaseObject)) {
//                            if (!SecondBaseObject.getHitboxes().isEmpty()) {
//                                for (int k = 0; k < MainBaseObject.getHitboxes().size(); k++) {
//                                    if (!MainBaseObject.getHitboxes().get(k).isTrigger) {
//                                        SquareHitbox MainHB = MainBaseObject.getHitboxes().get(k);
//                                        for (int l = 0; l < SecondBaseObject.getHitboxes().size(); l++) {
//                                            SquareHitbox SecondHB = SecondBaseObject.getHitboxes().get(l);
//                                            if (!SecondBaseObject.getHitboxes().get(l).isTrigger) {
//                                                if (MainBaseObject.getCords().x + MainHB.cords.x < SecondBaseObject.getCords().x + SecondHB.cords.x + SecondHB.width && MainBaseObject.getCords().x + MainHB.cords.x + MainHB.width > SecondBaseObject.getCords().x + SecondHB.cords.x && MainBaseObject.getCords().y + MainHB.cords.y < SecondBaseObject.getCords().y + SecondHB.cords.y + SecondHB.height && MainBaseObject.getCords().y + MainHB.cords.y + MainHB.height > SecondBaseObject.getCords().y + SecondHB.cords.y) {
//                                                    Point aPoint = MainHB.getOverlapped(SecondHB);
//                                                    if (aPoint.x < aPoint.y) {
//                                                        if (MainBaseObject.getCords().x + MainHB.cords.x > SecondBaseObject.getCords().x + SecondHB.cords.x) {
//                                                            MainBaseObject.setCords(MainBaseObject.getCords().x + aPoint.x, MainBaseObject.getCords().y);
//                                                            MainBaseObject.getPhysics().setVelocity(new Point(0, MainBaseObject.getPhysics().getVelocity().y));
//                                                        } else {
//                                                            MainBaseObject.setCords(MainBaseObject.getCords().x - aPoint.x, MainBaseObject.getCords().y);
//                                                            MainBaseObject.getPhysics().setVelocity(new Point(0, MainBaseObject.getPhysics().getVelocity().y));
//                                                        }
//                                                    } else if (MainBaseObject.getCords().y + MainHB.cords.y > SecondBaseObject.getCords().y + SecondHB.cords.y) {
//                                                        MainBaseObject.setCords(MainBaseObject.getCords().x, MainBaseObject.getCords().y + aPoint.y);
//                                                        MainBaseObject.getPhysics().setVelocity(new Point(MainBaseObject.getPhysics().getVelocity().x, 0));
//                                                    } else {
//                                                        MainBaseObject.setCords(MainBaseObject.getCords().x, MainBaseObject.getCords().y - aPoint.y);
//                                                        MainBaseObject.getPhysics().setVelocity(new Point(MainBaseObject.getPhysics().getVelocity().x, 0));
//                                                    }
//
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
}
