/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Components.BaseObject;
import Objects.Tiles.FloorTileLevelOne;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 *
 * @author Frederik
 */
public class Generator implements Runnable {

    int AmountOfTiles = 50;
    BaseObject[][] tileSpots = new BaseObject[40][40];
    public ArrayList<Point> placedTiles = new ArrayList();
    public ArrayList<Point> placedWalls = new ArrayList();
    public ArrayList<BaseObject> tiles = new ArrayList();
    
    Point Pos = new Point(20, 20);

    @Override
    public void run() {
        for (int i = 0; i < AmountOfTiles; i++) {
            i--;
            if (tileSpots[Pos.x][Pos.y] == null) {
                placedTiles.add(Pos);
                i++;
            }
            Random rand = new Random();
            int n = rand.nextInt(100) + 1;
            if (n < 25) {
                Pos = new Point(Pos.x + 1, Pos.y);

            } else if (n < 50) {
                Pos = new Point(Pos.x - 1, Pos.y);

            } else if (n < 75) {
                Pos = new Point(Pos.x, Pos.y + 1);

            } else {
                Pos = new Point(Pos.x, Pos.y - 1);

            }
        }
        for (int i = 0; i < AmountOfTiles; i++) {
            Point curr = placedTiles.get(i);
            boolean soloHor = true;
            boolean soloVer = true;

            for (int j = 0; j < AmountOfTiles; j++) {
                Point currHor = placedTiles.get(j);
                if (currHor.x == curr.x + 1 && currHor.y == curr.y || currHor.x == curr.x - 1 && currHor.y == curr.y) {
                    soloVer = false;
                }
            }
            for (int j = 0; j < AmountOfTiles; j++) {
                Point currVer = placedTiles.get(j);
                if (currVer.x == curr.x && currVer.y == curr.y + 1 || currVer.x == curr.x && currVer.y == curr.y - 1) {
                    soloHor = false;
                }
            }

            if (soloVer) {
                placedTiles.add(new Point(curr.x+1,curr.y));
            }
            if (soloHor) {
                placedTiles.add(new Point(curr.x,curr.y+1));
            }
        }
        for (int i = 0; i < placedTiles.size(); i++) {
            Point curr = placedTiles.get(i);
            for (int j = -1; j < 2; j++) {
                for (int k = -1; k < 2; k++) {
                    Point tmp = new Point(curr.x + j,curr.y + k);
                    if(!placedTiles.contains(tmp)){
                        placedWalls.add(tmp);
                    }
                }
            }
        }
        for (int i = 0; i < placedTiles.size(); i++) {
            Point curr = placedTiles.get(i);
            FloorTileLevelOne f = new FloorTileLevelOne();
            f.setCords(i*16, i*32);
        }
        
            
    }

}
