/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Components.Sprite;
import static Controllers.SpriteController.loadSpriteRoll;
import enums.FourDir;
import enums.MoveStatus;
import enums.SpriteSheet;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author frederik.larsen
 */
public class SpriteManager {
    ArrayList<Sprite> sprites = new ArrayList();
    Enum status = null;
    BufferedImage img;
    
    public SpriteManager(Enum status){
        this.status = status;
        this.img = null;
    }
    
    public void addSprite(SpriteSheet sheet, FourDir dir, int x, int y,
            int width, int height, int wSpace, int hSpace, int amount, Enum status, long timeBetweenFrames){
        sprites.add(loadSpriteRoll(sheet, dir, x, y, width, height, wSpace, hSpace, amount, status, timeBetweenFrames));
    }
    
    public BufferedImage nextImage(){
        for (int i = 0; i < sprites.size(); i++) {
            if(status == sprites.get(i).getStatus()){
                img = sprites.get(i).getNextImage();
            }
        }
        return img;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }
    
    
}
