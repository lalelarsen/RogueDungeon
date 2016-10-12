/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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
    ArrayList<Object> sprites = new ArrayList();
    
    public SpriteController(){
        
    }
    
    public void loadDungeon(){
        String path = "dungeon_sheet.png";
        File fil = new File(path);
        BufferedImage img = null;
        //Get Image from path
        try {
            img = ImageIO.read(fil);
        } catch (IOException e) {
            System.out.println("The image was not loaded.");
        }
        //64,112
        
        
    }
    
    public static BufferedImage loadSingleSprite(){
        String path = "C:\\Users\\frederik.larsen\\OneDrive\\Java\\2D art\\dungeon_sheet.png";
        File fil = new File(path);
        BufferedImage img = null;
        //Get Image from path
        try {
            img = ImageIO.read(fil);
        } catch (IOException e) {
            System.out.println("The image was not loaded.");
        }
        return img.getSubimage(64, 112, 16, 16);
    }
}
