/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects.Tiles;

import Components.BaseObject;
import Controllers.SpriteController;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Frederik
 */
public class FloorTileLevelOne extends BaseObject {

    public FloorTileLevelOne() {
        img = SpriteController.loadSingleSpriteDungeon(176*4, 160*4, 16*4, 32*4);
    }
}
