/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import Objects.SceneOne;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;
import Interfaces.Plottable;
import Components.BaseObject;
import Components.GameScene;
import Components.RoundHitbox;
import Components.SquareHitbox;
import Settings.Settings;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.Collections;

public class MainPanel extends JPanel {

    public GameScene SC = null;
    public static Point camera = new Point(0, 0);
    public int scale;
    public static int viewX = 0;
    public static int viewY = 0;
//    int WorldX = 1600;
//    int WorldY = 1200;
//    int offSetMaxX = WorldX - viewX;
//    int offSetMaxY = WorldY - viewY;
//    int offSetMinX = 0;
//    int offSetMinY = 0;
    int camX = 0;
    int camY = 0;
    
    public static void updateCameraCord(Point p) {
        camera = p;
    }

    public MainPanel(KeyListener KL, GameScene SC) {
        initComponents();
        // Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension screenSize = new Dimension();
        screenSize.setSize(1600, 1200);
        viewX = screenSize.width;
        viewY = screenSize.height;
        this.setFocusable(true);
        this.addKeyListener(KL);
        this.SC = SC;
        this.setLocation(0, 0);
        this.setPreferredSize(screenSize);
        this.scale = Settings.getScale();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        camX = camera.x - viewX / 2 + 100;
        camY = camera.y - viewY / 2 + 100;
        g.translate(-camX, -camY);
        Collections.sort(SC.OC.units);
        for (int i = 0; i < SC.OC.bgUnits.size(); i++) {
            BaseObject currObject = SC.OC.bgUnits.get(i);
            Point point = currObject.nextPos();
            if (currObject.getSpriteManager() == null) {
                g.drawImage(currObject.getImage(), point.x, point.y, currObject.getImage().getWidth(null)*scale,currObject.getImage().getHeight(null)*scale,null);
            } else {
                Image img = null;
                try {
                    img = currObject.getSpriteManager().nextImage();

                } catch (Exception e) {
                    System.out.println(currObject.getClass().getName() + " har intet billede");
                    e.printStackTrace();
                }

                g.drawImage(img, point.x, point.y, img.getWidth(null)*scale,img.getHeight(null)*scale,null);
            }
        }

        for (int i = 0; i < SC.OC.units.size(); i++) {
            BaseObject currObject = SC.OC.units.get(i);
            if (currObject.isActive) {
                Point point = currObject.nextPos();

                if (currObject.getSpriteManager() == null) {
                    g.drawImage(currObject.getImage(), point.x, point.y, currObject.getImage().getWidth(null)*scale,currObject.getImage().getHeight(null)*scale,null);
                } else {
                    Image img = null;
                    try {
                        img = currObject.getSpriteManager().nextImage();

                    } catch (Exception e) {
                        System.out.println(currObject.getClass().getName() + " har intet billede");
                    }
                    g.drawImage(img, point.x, point.y, img.getWidth(null)*scale,img.getHeight(null)*scale,null);
                }
            }
            //draw hitboxes
            // g.setColor(Color.red);
            // for (int j = 0; j < currObject.getHitboxes().size(); j++) {
            //     if (currObject.getHitboxes().get(j).getClass().getSimpleName().equals("SquareHitbox")) {
            //         SquareHitbox sh = (SquareHitbox) currObject.getHitboxes().get(j);
            //         if (sh.isActive) {
            //             g.drawRect(currObject.getCords().x + sh.cords.x, currObject.getCords().y + sh.cords.y, sh.width, sh.height);
            //         }
            //     }
            //     if (currObject.getHitboxes().get(j).getClass().getSimpleName().equals("RoundHitbox")) {
            //         RoundHitbox rh = (RoundHitbox) currObject.getHitboxes().get(j);
            //         if (rh.isActive) {
            //             g.drawOval(currObject.getCords().x + rh.cords.x - rh.radius, currObject.getCords().y + rh.cords.y - rh.radius, rh.radius * 2, rh.radius * 2);
            //         }
            //     }
            // }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(600, 900));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
