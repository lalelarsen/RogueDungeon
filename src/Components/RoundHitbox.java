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
 * @author Frederik
 */
public class RoundHitbox extends Hitbox {

    public Point cords;
    public int radius;
    public BaseObject body;
    ArrayList<Point> area = new ArrayList<Point>();

    public RoundHitbox(Point p, int radius, BaseObject body, boolean isTrigger) {
        this.cords = p;
        this.radius = radius;
        this.body = body;
        this.isTrigger = isTrigger;
    }

    public int getOffsetRound(RoundHitbox hb, double dist) {

        int radii = radius + hb.radius;
        double offsetVal = Math.floor(radii / dist);

        return (int) offsetVal;
    }

    public Point getOffsetSquare(SquareHitbox hb) {

        int sqX = hb.getBody().getCords().x + hb.cords.x;
        int sqY = hb.getBody().getCords().y + hb.cords.y;
        int thisX = body.getCords().x + this.cords.x;
        int thisY = body.getCords().y + this.cords.y;
        int offsetX = 0;
        int offsetY = 0;

        if (thisX > sqX + hb.width && thisX - this.radius < sqX + hb.width) {

            if (thisY > sqY + hb.height && thisY - this.radius < sqY + hb.height) {
                if (thisY < sqY + hb.height + this.radius / 2) {
                    offsetX = sqX + hb.width - (thisX - radius);
                } else if (thisX < sqX + hb.width + this.radius / 2) {
                    offsetY = sqY + hb.height - (thisY - radius);
                }
            } else if (thisY < sqY && thisY + this.radius > sqY) {
                if (thisY > sqY - this.radius / 2) {
                    offsetX = sqX + hb.width - (thisX - radius);
                } else if (thisX < sqX + hb.width + this.radius / 2) {
                    offsetY = 0 - (thisY + radius - sqY);
                }
            } else {
                offsetX = sqX + hb.width - (thisX - radius);
            }
        } else if (thisX < sqX && thisX + this.radius > sqX) {
            if (thisY > sqY + hb.height && thisY - this.radius < sqY + hb.height) {
                if (thisY < sqY + hb.height + this.radius / 2) {
                    offsetX = 0 - (thisX + radius - sqX);
                } else if (thisX > sqX - this.radius / 2) {
                    offsetY = sqY + hb.height - (thisY - radius);
                }
            } else if (thisY < sqY && thisY + this.radius > sqY) {
                if (thisY > sqY - this.radius / 2) {
                    offsetX = 0 - (thisX + radius - sqX);
                } else if (thisX > sqX - this.radius / 2) {
                    offsetY = 0 - (thisY + radius - sqY);
                }
            } else {
                offsetX = 0 - (thisX + radius - sqX);
            }
        } else {
            if (thisY > sqY + hb.height && thisY - this.radius < sqY + hb.height) {
                offsetY = sqY + hb.height - (thisY - radius);
            } else if (thisY < sqY && thisY + this.radius > sqY) {
                offsetY = 0 - (thisY + radius - sqY);
            }
        }

        return new Point(offsetX, offsetY);
    }

}
