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
import java.awt.Point;

/**
 *
 * @author Frederik
 */
public class WallTileLevelOne extends BaseObject {

    Walls wallE;

    //HER! set billeder
    public WallTileLevelOne(Walls w) {
        //NE addHitbox(36, 84, new Point(28, 0), false);

        //SE addHitbox(36, 88, new Point(28,44), false);
        //SE new addHitbox(36, 72, new Point(28,60), false);
        //SW addHitbox(36, 72, new Point(0, 60), false);
        //NW addHitbox(36, 84, new Point(0, 0), false);
        
        //NE_NW addHitbox(64, 84, new Point(0, 0), false);
        //NE_SE addHitbox(36, 128, new Point(28,0), false);
        //SE_SW addHitbox(64, 72, new Point(0,60), false);
        //SW_NW addHitbox(36, 128, new Point(0, 0), false);
        
        //N addHitbox(16, 60, new Point(24, 0), false);
        //E addHitbox(16, 28, new Point(48, 60), false);
        //W addHitbox(16, 28, new Point(0, 60), false);
        //S addHitbox(16, 60, new Point(24, 68), false);
        
        //N_S addHitbox(16, 128, new Point(24, 0), false);
        //E_W addHitbox(64, 28, new Point(0, 60), false);
        
        //Pillar addHitbox(32, 28, new Point(16, 60), false);
        this.wallE = w;
        switch (w) {
            case EMPTY:
                img = SpriteController.loadSingleSpriteDungeon(352 * 4, 192 * 4, 16 * 4, 32 * 4);
                break;
            case P:
                img = SpriteController.loadSingleSpriteDungeon(160 * 4, 160 * 4, 16 * 4, 32 * 4);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case N:
                img = SpriteController.loadSingleSpriteDungeon(32 * 4, 160 * 4, 16 * 4, 32 * 4);
                addHitbox(16, 60, new Point(24, 0), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case S:
                img = SpriteController.loadSingleSpriteDungeon(0 * 4, 160 * 4, 16 * 4, 32 * 4);
                addHitbox(16, 60, new Point(24, 68), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case E:
                img = SpriteController.loadSingleSpriteDungeon(16 * 4, 160 * 4, 16 * 4, 32 * 4);
                addHitbox(16, 28, new Point(48, 60), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case W:
                img = SpriteController.loadSingleSpriteDungeon(48 * 4, 160 * 4, 16 * 4, 32 * 4);
                addHitbox(16, 28, new Point(0, 60), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case E_S:
                img = SpriteController.loadSingleSpriteDungeon(112 * 4, 160 * 4, 16 * 4, 32 * 4);
                addHitbox(16, 60, new Point(24, 68), false);
                addHitbox(16, 28, new Point(48, 60), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case E_W:
                img = SpriteController.loadSingleSpriteDungeon(80 * 4, 160 * 4, 16 * 4, 32 * 4);
                addHitbox(64, 28, new Point(0, 60), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case N_E:
                img = SpriteController.loadSingleSpriteDungeon(96 * 4, 160 * 4, 16 * 4, 32 * 4);
                addHitbox(16, 28, new Point(48, 60), false);
                addHitbox(16, 60, new Point(24, 0), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case S_W:
                img = SpriteController.loadSingleSpriteDungeon(128 * 4, 160 * 4, 16 * 4, 32 * 4);
                addHitbox(16, 60, new Point(24, 68), false);
                addHitbox(16, 28, new Point(0, 60), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case W_N:
                img = SpriteController.loadSingleSpriteDungeon(144 * 4, 160 * 4, 16 * 4, 32 * 4);
                addHitbox(16, 28, new Point(0, 60), false);
                addHitbox(16, 60, new Point(24, 0), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case N_S:
                img = SpriteController.loadSingleSpriteDungeon(64 * 4, 160 * 4, 16 * 4, 32 * 4);
                addHitbox(16, 128, new Point(24, 0), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case E_SE_S:
                img = SpriteController.loadSingleSpriteDungeon(128 * 4, 0 * 4, 16 * 4, 32 * 4);
                addHitbox(36, 72, new Point(28, 60), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case N_NE_E:
                img = SpriteController.loadSingleSpriteDungeon(128 * 4, 32 * 4, 16 * 4, 32 * 4);
                addHitbox(36, 84, new Point(28, 0), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case S_SW_W:
                img = SpriteController.loadSingleSpriteDungeon(144 * 4, 0 * 4, 16 * 4, 32 * 4);
                addHitbox(36, 72, new Point(0, 60), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case N_W_NW:
                img = SpriteController.loadSingleSpriteDungeon(144 * 4, 32 * 4, 16 * 4, 32 * 4);
                addHitbox(36, 84, new Point(0, 0), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case N_E_S:
                img = SpriteController.loadSingleSpriteDungeon(320 * 4, 160 * 4, 16 * 4, 32 * 4);
                addHitbox(16, 60, new Point(24, 68), false);
                addHitbox(16, 28, new Point(48, 60), false);
                addHitbox(16, 60, new Point(24, 0), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case E_S_W:
                img = SpriteController.loadSingleSpriteDungeon(336 * 4, 160 * 4, 16 * 4, 32 * 4);
                addHitbox(16, 60, new Point(24, 68), false);
                addHitbox(64, 28, new Point(0, 60), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case N_S_W:
                img = SpriteController.loadSingleSpriteDungeon(352 * 4, 160 * 4, 16 * 4, 32 * 4);
                addHitbox(16, 60, new Point(24, 68), false);
                addHitbox(16, 28, new Point(0, 60), false);
                addHitbox(16, 60, new Point(24, 0), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case N_E_W:
                img = SpriteController.loadSingleSpriteDungeon(368 * 4, 160 * 4, 16 * 4, 32 * 4);
                addHitbox(64, 28, new Point(0, 60), false);
                addHitbox(16, 60, new Point(24, 0), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case N_E_SE_S:
                img = SpriteController.loadSingleSpriteDungeon(192 * 4, 160 * 4, 16 * 4, 32 * 4);
                addHitbox(36, 72, new Point(28, 60), false);
                addHitbox(16, 60, new Point(24, 0), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case E_SE_S_W:
                img = SpriteController.loadSingleSpriteDungeon(208 * 4, 160 * 4, 16 * 4, 32 * 4);
                addHitbox(36, 72, new Point(28, 60), false);
                addHitbox(16, 28, new Point(0, 60), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case N_S_SW_W:
                img = SpriteController.loadSingleSpriteDungeon(224 * 4, 160 * 4, 16 * 4, 32 * 4);
                addHitbox(36, 72, new Point(0, 60), false);
                addHitbox(16, 60, new Point(24, 0), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case E_S_SW_W:
                img = SpriteController.loadSingleSpriteDungeon(240 * 4, 160 * 4, 16 * 4, 32 * 4);
                addHitbox(36, 72, new Point(0, 60), false);
                addHitbox(16, 28, new Point(48, 60), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case N_S_W_NW:
                img = SpriteController.loadSingleSpriteDungeon(256 * 4, 160 * 4, 16 * 4, 32 * 4);
                addHitbox(36, 84, new Point(0, 0), false);
                addHitbox(16, 60, new Point(24, 68), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case N_E_W_NW:
                img = SpriteController.loadSingleSpriteDungeon(272 * 4, 160 * 4, 16 * 4, 32 * 4);
                addHitbox(36, 84, new Point(0, 0), false);
                addHitbox(16, 28, new Point(48, 60), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case N_NE_E_W:
                img = SpriteController.loadSingleSpriteDungeon(288 * 4, 160 * 4, 16 * 4, 32 * 4);
                addHitbox(36, 84, new Point(28, 0), false);
                addHitbox(16, 28, new Point(0, 60), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case N_NE_E_S:
                img = SpriteController.loadSingleSpriteDungeon(304 * 4, 160 * 4, 16 * 4, 32 * 4);
                addHitbox(36, 84, new Point(28, 0), false);
                addHitbox(16, 60, new Point(24, 68), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case N_NE_E_S_W:
                img = SpriteController.loadSingleSpriteDungeon(304 * 4, 192 * 4, 16 * 4, 32 * 4);
                addHitbox(16, 28, new Point(0, 60), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case N_E_S_SW_W:
                img = SpriteController.loadSingleSpriteDungeon(272 * 4, 192 * 4, 16 * 4, 32 * 4);
                addHitbox(16, 28, new Point(48, 60), false);
                addHitbox(16, 60, new Point(24, 0), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case N_E_S_W_NW:
                img = SpriteController.loadSingleSpriteDungeon(288 * 4, 192 * 4, 16 * 4, 32 * 4);
                addHitbox(16, 60, new Point(24, 68), false);
                addHitbox(16, 28, new Point(48, 60), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case N_E_SE_S_W:
                img = SpriteController.loadSingleSpriteDungeon(256 * 4, 192 * 4, 16 * 4, 32 * 4);
                addHitbox(16, 60, new Point(24, 0), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case N_NE_E_W_NW:
                img = SpriteController.loadSingleSpriteDungeon(96 * 4, 0 * 4, 16 * 4, 32 * 4);
                //TOP
                break;
            case N_NE_E_SE_S:
                img = SpriteController.loadSingleSpriteDungeon(48 * 4, 48 * 4, 16 * 4, 32 * 4);
                addHitbox(36, 128, new Point(28, 0), false);
                addHitbox(32, 28, new Point(16, 60), false);
                //RIGHT
                break;
            case E_SE_S_SW_W:
                img = SpriteController.loadSingleSpriteDungeon(96 * 4, 32 * 4, 16 * 4, 32 * 4);
                addHitbox(64, 72, new Point(0,60), false);
                //BOT
                break;
            case N_S_SW_W_NW:
                img = SpriteController.loadSingleSpriteDungeon(64 * 4, 48 * 4, 16 * 4, 32 * 4);
                addHitbox(36, 128, new Point(0, 0), false);
                addHitbox(32, 28, new Point(16, 60), false);
                //LEFT
                break;
            case N_NE_E_SE_S_W:
                img = SpriteController.loadSingleSpriteDungeon(192 * 4, 192 * 4, 16 * 4, 32 * 4);
                addHitbox(36, 128, new Point(28, 0), false);
                addHitbox(16, 28, new Point(0, 60), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case N_E_S_SW_W_NW:
                img = SpriteController.loadSingleSpriteDungeon(208 * 4, 192 * 4, 16 * 4, 32 * 4);
                addHitbox(36, 128, new Point(0, 0), false);
                addHitbox(16, 28, new Point(48, 60), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case N_NE_E_S_W_NW:
                img = SpriteController.loadSingleSpriteDungeon(224 * 4, 192 * 4, 16 * 4, 32 * 4);
                addHitbox(64, 84, new Point(0, 0), false);
                addHitbox(16, 60, new Point(24, 68), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case N_E_SE_S_SW_W:
                img = SpriteController.loadSingleSpriteDungeon(240 * 4, 192 * 4, 16 * 4, 32 * 4);
                addHitbox(64, 72, new Point(0,60), false);
                addHitbox(16, 60, new Point(24, 0), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case N_NE_E_S_SW_W:
                img = SpriteController.loadSingleSpriteDungeon(336 * 4, 192 * 4, 16 * 4, 32 * 4);
                addHitbox(36, 84, new Point(28, 0), false);
                addHitbox(36, 72, new Point(0, 60), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case N_E_SE_S_W_NW:
                img = SpriteController.loadSingleSpriteDungeon(320 * 4, 192 * 4, 16 * 4, 32 * 4);
                addHitbox(32, 28, new Point(16, 60), false);
                addHitbox(36, 72, new Point(28, 60), false);
                addHitbox(36, 84, new Point(0, 0), false);
                addHitbox(32, 28, new Point(16, 60), false);
                break;
            case N_E_SE_S_SW_W_NW:
                img = SpriteController.loadSingleSpriteDungeon(80 * 4, 32 * 4, 16 * 4, 32 * 4);
                addHitbox(36, 72, new Point(28, 60), false);
                addHitbox(36, 84, new Point(0, 0), false);
                break;
            case N_NE_E_SE_S_SW_W:
                img = SpriteController.loadSingleSpriteDungeon(112 * 4, 32 * 4, 16 * 4, 32 * 4);
                addHitbox(36, 84, new Point(28, 0), false);
                addHitbox(36, 72, new Point(0, 60), false);
                break;
            case N_NE_E_SE_S_W_NW:
                img = SpriteController.loadSingleSpriteDungeon(112 * 4, 0 * 4, 16 * 4, 32 * 4);
                addHitbox(36, 72, new Point(28, 60), false);
                addHitbox(36, 84, new Point(0, 0), false);
                break;
            case N_NE_E_S_SW_W_NW:
                img = SpriteController.loadSingleSpriteDungeon(80 * 4, 0 * 4, 16 * 4, 32 * 4);
                addHitbox(36, 84, new Point(28, 0), false);
                addHitbox(36, 72, new Point(0, 60), false);
                break;

        }
    }
}
