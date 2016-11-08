/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Components.Sprite;
import enums.FourDir;
import enums.SpriteSheet;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author frederik.larsen
 */
public class SpriteController {

    ArrayList<Sprite> sprites = new ArrayList();
    public static BufferedImage dungeon;
    public static BufferedImage knightAnim;
    public static BufferedImage knightAnimHiRes;

    public SpriteController() {
        try {
            dungeon = ImageIO.read(this.getClass().getResourceAsStream("/pictures/dungeon_sheet.png"));
            knightAnim = ImageIO.read(this.getClass().getResourceAsStream("/pictures/knightanim3.png"));
            knightAnimHiRes = ImageIO.read(this.getClass().getResourceAsStream("/pictures/knightanim3_HiRes.png"));
        } catch (IOException e) {
            System.out.println("The image was not loaded.");
        }
    }

    public static void loadPictures(){
        try {
            dungeon = ImageIO.read(new File("/pictures/dungeon_sheet.png"));
            knightAnim = ImageIO.read(new File("/pictures/knightanim3.png"));
            knightAnimHiRes = ImageIO.read(new File("/pictures/knightanim3_HiRes.png"));
        } catch (IOException e) {
            System.out.println("The image was not loaded.");
        }
    }
    
    public static Sprite loadSpriteRoll(SpriteSheet sheet, FourDir dir, int x, int y, int width, int height, int wSpace, int hSpace, int amount, Enum status) {
        BufferedImage[] images = new BufferedImage[amount];
        BufferedImage curr = null;
        
        switch (sheet) {
            case DUNGEON:
                curr = dungeon;
                break;
            case KNIGHTANIM:
                curr = knightAnim;
                break;
            case KNIGHTANIM_HIGHRES:
                curr = knightAnimHiRes;
                break;
        }
        for (int i = 0; i < amount; i++) {
            images[i] = curr.getSubimage(x, y, width, height);
            switch (dir) {
                case DOWN:
                    break;
                case RIGHT:
                    x = x + width + wSpace;
                    break;
            }
        }
        Sprite s = new Sprite(images, status);
        return s;
    }

    public static BufferedImage loadSingleSpriteDungeon(int x, int y, int width, int height) {

        return dungeon.getSubimage(x, y, width, height);
    }
}
