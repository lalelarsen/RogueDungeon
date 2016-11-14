/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects.Tiles;

import Components.BaseObject;
import Controllers.GameController;
import Controllers.SpriteController;
import enums.Walls;

/**
 *
 * @author Frederik
 */
public class WallTileLevelOne extends BaseObject {

    Walls wallE;

    //HER! set billeder
    public WallTileLevelOne(Walls w) {
        this.wallE = w;
        switch (w) {
            case E:
                img = SpriteController.loadSingleSpriteDungeon(16, 160, 16, 32);
                break;
            case E_S:
                img = SpriteController.loadSingleSpriteDungeon(112, 160, 16, 32);
                break;
            case E_SE_S:
                img = SpriteController.loadSingleSpriteDungeon(128, 0, 16, 32);
                break;
            case E_W:
                img = SpriteController.loadSingleSpriteDungeon(80, 160, 16, 32);
                break;
            case E_SE_S_SW_W:
                img = SpriteController.loadSingleSpriteDungeon(96, 32, 16, 32);
                break;
            case N:
                img = SpriteController.loadSingleSpriteDungeon(32, 160, 16, 32);
                break;
            case N_E:
                img = SpriteController.loadSingleSpriteDungeon(96, 160, 16, 32);
                break;
            case N_E_SE_S_SW_W_NW:
                img = SpriteController.loadSingleSpriteDungeon(80, 32, 16, 32);
                break;
            case N_NE_E:
                img = SpriteController.loadSingleSpriteDungeon(128, 32, 16, 32);
                break;
            case N_NE_E_SE_S_SW_W:
                img = SpriteController.loadSingleSpriteDungeon(112, 32, 16, 32);
                break;
            case N_NE_E_SE_S_W_NW:
                img = SpriteController.loadSingleSpriteDungeon(112, 0, 16, 32);
                break;
            case N_NE_E_S_SW_W_NW:
                img = SpriteController.loadSingleSpriteDungeon(80, 0, 16, 32);
                break;
            case N_NE_E_SE_S:
                img = SpriteController.loadSingleSpriteDungeon(48, 48, 16, 32);
                break;
            case N_NE_E_W_NW:
                img = SpriteController.loadSingleSpriteDungeon(96, 0, 16, 32);
                break;
            case N_S_SW_W_NW:
                img = SpriteController.loadSingleSpriteDungeon(64, 48, 16, 32);
                break;
            case N_S:
                img = SpriteController.loadSingleSpriteDungeon(64, 160, 16, 32);
                break;
            case N_W_NW:
                img = SpriteController.loadSingleSpriteDungeon(144, 32, 16, 32);
                break;
            case P:
                img = SpriteController.loadSingleSpriteDungeon(160, 160, 16, 32);
                break;
            case S:
                img = SpriteController.loadSingleSpriteDungeon(0, 160, 16, 32);
                break;
            case S_SW_W:
                img = SpriteController.loadSingleSpriteDungeon(144, 0, 16, 32);
                break;
            case S_W:
                img = SpriteController.loadSingleSpriteDungeon(128, 160, 16, 32);
                break;
            case W:
                img = SpriteController.loadSingleSpriteDungeon(48, 160, 16, 32);
                break;
            case W_N:
                img = SpriteController.loadSingleSpriteDungeon(144, 160, 16, 32);
                break;
            case N_E_SE_S:
                img = SpriteController.loadSingleSpriteDungeon(192, 160, 16, 32);
                break;
            case E_SE_S_W:
                img = SpriteController.loadSingleSpriteDungeon(208, 160, 16, 32);
                break;
            case N_S_SW_W:
                img = SpriteController.loadSingleSpriteDungeon(224, 160, 16, 32);
                break;
            case E_S_SW_W:
                img = SpriteController.loadSingleSpriteDungeon(240, 160, 16, 32);
                break;
            case N_S_W_NW:
                img = SpriteController.loadSingleSpriteDungeon(256, 160, 16, 32);
                break;
            case N_E_W_NW:
                img = SpriteController.loadSingleSpriteDungeon(272, 160, 16, 32);
                break;
            case N_NE_E_W:
                img = SpriteController.loadSingleSpriteDungeon(288, 160, 16, 32);
                break;
            case N_NE_E_S:
                img = SpriteController.loadSingleSpriteDungeon(304, 160, 16, 32);
                break;
            case N_E_S:
                img = SpriteController.loadSingleSpriteDungeon(320, 160, 16, 32);
                break;
            case E_S_W:
                img = SpriteController.loadSingleSpriteDungeon(336, 160, 16, 32);
                break;
            case N_S_W:
                img = SpriteController.loadSingleSpriteDungeon(352, 160, 16, 32);
                break;
            case N_E_W:
                img = SpriteController.loadSingleSpriteDungeon(368, 160, 16, 32);
                break;
            case N_NE_E_SE_S_W:
                img = SpriteController.loadSingleSpriteDungeon(192, 192, 16, 32);
                break;
            case N_E_S_SW_W_NW:
                img = SpriteController.loadSingleSpriteDungeon(208, 192, 16, 32);
                break;
            case N_NE_E_S_W_NW:
                img = SpriteController.loadSingleSpriteDungeon(224, 192, 16, 32);
                break;
            case N_E_SE_S_SW_W:
                img = SpriteController.loadSingleSpriteDungeon(240, 192, 16, 32);
                break;
            case N_NE_E_S_W:
                img = SpriteController.loadSingleSpriteDungeon(304, 192, 16, 32);
                break;
            case N_E_S_SW_W:
                img = SpriteController.loadSingleSpriteDungeon(272, 192, 16, 32);
                break;
            case N_E_S_W_NW:
                img = SpriteController.loadSingleSpriteDungeon(288, 192, 16, 32);
                break;
            case N_E_SE_S_W:
                img = SpriteController.loadSingleSpriteDungeon(256, 192, 16, 32);
                break;
            case N_NE_E_S_SW_W:
                img = SpriteController.loadSingleSpriteDungeon(336, 192, 16, 32);
                break;
            case N_E_SE_S_W_NW:
                img = SpriteController.loadSingleSpriteDungeon(320, 192, 16, 32);
                break;

        }
    }
}
