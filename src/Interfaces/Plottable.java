/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author frederik.larsen
 */
public interface Plottable {
    
    public Point getCords();
    public Point nextPos();
    public void setCords(int x, int y);
    public void setImage(Image img);
    public Image getImage();
    
}
