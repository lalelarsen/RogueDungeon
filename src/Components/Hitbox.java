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
public class Hitbox {

    public int width;
    public int height;
    BaseObject body;
    ArrayList<Point> area = new ArrayList<Point>();

    public Hitbox(int width, int height, BaseObject body) {
        this.width = width;
        this.height = height;
        this.body = body;
        setHitbox();
    }

    public Point getOverlapped(Hitbox hb) {
        Point oPoint;
        int oWidth = 0;
        int oHeight = 0;
        if (this.getBody().getCords().x < hb.getBody().getCords().x) {
            if (this.getBody().getCords().y < hb.getBody().getCords().y) {
                oPoint = hb.getBody().getCords();
                oWidth = this.getBody().getCords().x + width - hb.getBody().getCords().x;
                oHeight = this.getBody().getCords().y + height - hb.getBody().getCords().y;
            } else {
                oPoint = new Point(hb.getBody().getCords().x, this.getBody().getCords().y);
                oWidth = this.getBody().getCords().x + width - hb.getBody().getCords().x;
                if (this.getBody().getCords().y + height < hb.getBody().getCords().y + hb.getHeight()) {
                    oHeight = this.getHeight();
                } else {
                    oHeight = hb.getBody().getCords().y + hb.getHeight() - this.getBody().getCords().y;
                }
            }
        } else if (this.getBody().getCords().y < hb.getBody().getCords().y) {
            oPoint = new Point(this.getBody().getCords().x, hb.getBody().getCords().y);
            if (this.getBody().getCords().x + width < hb.getBody().getCords().x + hb.getWidth()) {
                oWidth = this.getWidth();
            } else {
                oWidth = hb.getBody().getCords().x + hb.getWidth() - this.getBody().getCords().x;
            }
            oHeight = this.getBody().getCords().y + height - hb.getBody().getCords().y;
        } else {
            oPoint = this.getBody().getCords();
            if (this.getBody().getCords().x + width < hb.getBody().getCords().x + hb.getWidth()) {
                oWidth = this.getWidth();
            } else {
                oWidth = hb.getBody().getCords().x + hb.getWidth() - this.getBody().getCords().x;
            }
            if (this.getBody().getCords().y + height < hb.getBody().getCords().y + hb.getHeight()) {
                oHeight = this.getHeight();
            } else {
                oHeight = hb.getBody().getCords().y + hb.getHeight() - this.getBody().getCords().y;

            }
        }
        return new Point(oWidth, oHeight);
    }

    public void setHitbox() {
        for (int x = 0; x < body.getCords().x + width; x++) {
            for (int y = 0; y < body.getCords().y + height; y++) {
                area.add(new Point(x, y));
            }
        }
    }

    public ArrayList<Point> getHitboxCords() {
        ArrayList<Point> hitboxCords = new ArrayList();
        for (int i = 0; i < area.size(); i++) {
            hitboxCords.add(new Point(body.getCords().x + area.get(i).x, body.getCords().y + area.get(i).y));
        }
        return hitboxCords;
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
