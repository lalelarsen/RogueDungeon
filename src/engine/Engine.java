package engine;

import Controllers.GameController;
import Objects.Generator;
import java.awt.Point;

public class Engine {

    public static void main(String[] args) {
//        GameController GC = new GameController();
//        GC.StartGame();
        Generator g = new Generator();
        Thread t = new Thread(g);
        t.start();
        try {
        Thread.sleep(2000l);
            
        } catch (Exception e) {
        }
        for (int i = 0; i < 40; i++) {
            System.out.println("");
            for (int j = 0; j < 40; j++) {
                Point p = new Point(i,j);
                if(g.placedTiles.contains(p)){
                    System.out.print(" T ");
                } else if(g.placedWalls.contains(p)){
                    System.out.print(" W ");
                } else {
                    System.out.print(" - ");
                }
            }
            
        }
    }
    
}
