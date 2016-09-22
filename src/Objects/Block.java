/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Components.BaseObject;
import Interfaces.Plottable;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author frederik.larsen
 */
public class Block extends BaseObject implements Plottable{

    public Block() {
        String path = "block.png";
        File fil = new File(path);
        BufferedImage imgg = null;
        //Get Image from path
        try {
            imgg = ImageIO.read(fil);
        } catch (IOException e) {
            System.out.println("The image was not loaded.");
        }
        addPhysics();
        addHitbox(imgg.getHeight(), imgg.getWidth());
        getPhysics().gravity = false;
        getPhysics().isSolid = true;
        img = imgg;
    }
    
    
}
