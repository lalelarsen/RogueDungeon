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

public class MainPanel extends JPanel {
    
    SceneOne SC;
    BufferedImage background;
    int xSize;
    int ySize;
    int xStartPoint;
    int yStartPoint;
    
    public MainPanel(KeyListener KL,SceneOne SC) {
        initComponents();
        this.setFocusable(true);
        this.addKeyListener(KL);
        this.SC = SC;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < SC.OC.units.size(); i++) {
            BaseObject currObject = SC.OC.units.get(i);
            Point point = currObject.nextPos();
            Image img = currObject.getImage();
            g.drawImage(img, point.x, point.y, null);
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(1200, 900));

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
