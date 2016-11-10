package engine;

import Controllers.GameController;
import Controllers.SpriteController;
import Objects.Generator;
import java.awt.Point;

public class Engine {

    public static void main(String[] args) {
        GameController GC = new GameController();
        GC.StartGame();
//        SpriteController sp = new SpriteController();
//        Generator g = new Generator();
//        Thread t = new Thread(g);
//        t.start();
//        try {
//        Thread.sleep(2000l);
//            
//        } catch (Exception e) {
//        }
//        for (int i = 0; i < g.maxX; i++) {
//            System.out.println("");
//            for (int j = 0; j < g.maxY; j++) {
//                Point p = new Point(i,j);
//                if(g.placedTiles.contains(p)){
//                    System.out.print(" T ");
//                } else if(g.placedWalls.contains(p)){
//                    System.out.print(" W ");
//                } else {
//                    System.out.print(" - ");
//                }
//            }
//            
//        }
//        System.out.println("");
//        for (int i = 0; i < g.maxX; i++) {
//            System.out.println("");
//            for (int j = 0; j < g.maxY; j++) {
//                if(g.wallSpots[i][j] != null){
//                    System.out.print(" W ");
//                } else {
//                    System.out.print(" - ");
//                }
//            }
//        }
    }
    
}
