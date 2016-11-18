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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

public class MainPanel extends JPanel {

    public GameScene SC = null;
    public static Point camera = new Point(0,0);
    public static int viewX = 800;
    public static int viewY = 600;
    int WorldX = 1600;
    int WorldY = 1200;
    int offSetMaxX = WorldX - viewX;
    int offSetMaxY = WorldY - viewY;
    int offSetMinX = 0;
    int offSetMinY = 0;
    int camX = 0;
    int camY = 0;

    public static void updateCameraCord(Point p){
        camera = p;
    }
    
    public MainPanel(KeyListener KL, GameScene SC) {
        initComponents();
        this.setFocusable(true);
        this.addKeyListener(KL);
        this.SC = SC;
        this.setPreferredSize(new Dimension(viewX,viewY));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        camX = camera.x-viewX/2;
        camY = camera.y-viewY/2;
        g.translate(-camX, -camY);
        for (int i = 0; i < SC.OC.units.size(); i++) {
            BaseObject currObject = SC.OC.units.get(i);
            Point point = currObject.nextPos();
            if (currObject.getSpriteManager() == null) {
                g.drawImage(currObject.getImage(), point.x, point.y, null);
            } else {
                Image img = null;
                try {
                    img = currObject.getSpriteManager().nextImage();

                } catch (Exception e) {
                    System.out.println(currObject.getClass().getName() + " har intet billede");
                }
                g.drawImage(img, point.x, point.y, null);
            }
            g.setColor(Color.red);
            for (int j = 0; j < currObject.getHitboxes().size(); j++) {
                g.drawRect(currObject.getCords().x + currObject.getHitboxes().get(j).cords.x, currObject.getCords().y + currObject.getHitboxes().get(j).cords.y, currObject.getHitboxes().get(j).width, currObject.getHitboxes().get(j).height);
            }

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
