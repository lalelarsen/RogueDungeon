/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author frederik.larsen
 */
public class SquareHitbox extends Hitbox{

    public int width;
    public int height;
    ArrayList<Point> area = new ArrayList<Point>();
    
    public SquareHitbox(int width, int height, BaseObject body, Point p, boolean isTrigger, String id) {
        this.width = width;
        this.height = height;
        this.body = body;
        this.cords = p;
        this.isTrigger = isTrigger;
        this.id = id;
        setArea();
    }

    public Point getOverlappedSquare(SquareHitbox hb) {
        Point oPoint;
        int oWidth = 0;
        int oHeight = 0;
        int aX = this.getBody().getCords().x + cords.x;
        int aY = this.getBody().getCords().y + cords.y;
        int aHBX = hb.getBody().getCords().x + hb.cords.x;
        int aHBY = hb.getBody().getCords().y + hb.cords.y;
        
        if (aX < aHBX) {
            if (aY < aHBY) {
                oPoint = new Point(aHBX,aHBY);
                oWidth = aX + width - aHBX;
                oHeight = aY + height - aHBY;
            } else {
                oPoint = new Point(aHBX, aY);
                oWidth = aX + width - aHBX;
                if (aY + height < aHBY + hb.getHeight()) {
                    oHeight = this.getHeight();
                } else {
                    oHeight = aHBY + hb.getHeight() - aY;
                }
            }
        } else if (aY < aHBY) {
            oPoint = new Point(aX, aHBY);
            if (aX + width < aHBX + hb.getWidth()) {
                oWidth = this.getWidth();
            } else {
                oWidth = aHBX + hb.getWidth() - aX;
            }
            oHeight = aY + height - aHBY;
        } else {
            oPoint = new Point(aX,aY);
            if (aX + width < aHBX + hb.getWidth()) {
                oWidth = this.getWidth();
            } else {
                oWidth = aHBX + hb.getWidth() - aX;
            }
            if (aY + height < aHBY + hb.getHeight()) {
                oHeight = this.getHeight();
            } else {
                oHeight = aHBY + hb.getHeight() - aY;

            }
        }

        return new Point(oWidth, oHeight);
    }

    public void setArea() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                area.add(new Point(cords.x + x, cords.y + y));
            }
        }
    }

    public ArrayList<Point> getHitboxCords() {
        return area;
    }
    
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BaseObject getBody() {
        return body;
    }

    public void setBody(BaseObject body) {
        this.body = body;
    }

}
