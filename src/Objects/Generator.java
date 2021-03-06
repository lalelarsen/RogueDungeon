/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Components.BaseObject;
import Objects.Tiles.FloorTileLevelOne;
import Objects.Tiles.WallTileLevelOne;
import enums.TileTypes;
import enums.Walls;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 *
 * @author Frederik
 */
public class Generator implements Callable<ArrayList<ArrayList<BaseObject>>> {

    int AmountOfTiles = 50;
    public int maxX = 40;
    public int maxY = 40;
    public TileTypes[][] tileSpots = new TileTypes[maxX][maxY];
    public ArrayList<Point> placedTiles = new ArrayList<Point>();
    public ArrayList<Point> placedWalls = new ArrayList<Point>();
    public ArrayList<BaseObject> wallTiles = new ArrayList<BaseObject>();
    public ArrayList<BaseObject> floorTiles = new ArrayList<BaseObject>();
    public ArrayList<BaseObject> spawnTiles = new ArrayList<BaseObject>();
    ArrayList<BaseObject> mainList;

    Point Pos = new Point(maxX / 2, maxY / 2);

    public Generator() {
        
    }

    @Override
    public ArrayList<ArrayList<BaseObject>> call() {
        for (int i = 0; i < AmountOfTiles; i++) {
            i--;
            if (tileSpots[Pos.x][Pos.y] == null) {
                tileSpots[Pos.x][Pos.y] = TileTypes.FLOOR;
                placedTiles.add(Pos);
                i++;
            }
            Random rand = new Random();
            int n = rand.nextInt(100) + 1;
            if (n < 40) {
                Pos = new Point(Pos.x + 1, Pos.y);

            } else if (n < 80) {
                Pos = new Point(Pos.x - 1, Pos.y);

            } else if (n < 90) {
                Pos = new Point(Pos.x, Pos.y + 1);

            } else {
                Pos = new Point(Pos.x, Pos.y - 1);

            }
        }

        // System.out.println("hallo");
        // for (int i = 0; i < maxX; i++) {
        //     System.out.println("");
        //     for (int j = 0; j < maxY; j++) {
        //         Point p = new Point(i, j);
        //         if (tileSpots[j][i] == TileTypes.FLOOR) {
        //             System.out.print(" T ");
        //         } else if (tileSpots[j][i] == TileTypes.WALL) {
        //             System.out.print(" W ");
        //         } else {
        //             System.out.print(" - ");
        //         }
        //     }

        // }

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
                placedTiles.add(new Point(curr.x + 1, curr.y));
                tileSpots[curr.x + 1][curr.y] = TileTypes.FLOOR;
            }
            if (soloHor) {
                placedTiles.add(new Point(curr.x, curr.y + 1));
                tileSpots[curr.x][curr.y + 1] = TileTypes.FLOOR;
            }
        }

        for (int i = 0; i < placedTiles.size(); i++) {
            Point curr = placedTiles.get(i);
            for (int j = -1; j < 2; j++) {
                for (int k = -1; k < 2; k++) {
                    Point tmp = new Point(curr.x + j, curr.y + k);
                    if (!placedTiles.contains(tmp)) {
                        placedWalls.add(tmp);
                        tileSpots[tmp.x][tmp.y] = TileTypes.WALL;
                    }
                }
            }
        }

        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                Point p = new Point(i, j);
                if (tileSpots[j][i] == TileTypes.FLOOR) {
                    FloorTileLevelOne f = new FloorTileLevelOne();
                    f.setCords(j * 64, i * 128);
                    floorTiles.add(f);
                    spawnTiles.add(f);
                } else if (tileSpots[j][i] == TileTypes.WALL) {
                    WallTileLevelOne w = wallDef(new Point(j,i));
                    w.setCords(j * 64, i * 128);
                    wallTiles.add(w);
                    FloorTileLevelOne f = new FloorTileLevelOne();
                    f.setCords(j * 64, i * 128);
                    floorTiles.add(f);
                } else {
                    WallTileLevelOne w = new WallTileLevelOne(Walls.EMPTY);
                    w.setCords(j * 64, i * 128);
                    wallTiles.add(w);
                }
            }

        }
//
//        for (int i = 0; i < placedTiles.size(); i++) {
//            Point curr = placedTiles.get(i);
//            FloorTileLevelOne f = new FloorTileLevelOne();
//            f.setCords(curr.x * 16, curr.y * 32);
//            tiles.add(f);
//        }
//
//        for (int i = 0; i < placedWalls.size(); i++) {
//            Point curr = placedWalls.get(i);
//            WallTileLevelOne f = wallDef(placedWalls.get(i));
//            f.setCords(curr.x * 16, curr.y * 32);
//            tiles.add(f);
//
//        }
        
        ArrayList<ArrayList<BaseObject>> result = new ArrayList();
        result.add(wallTiles);
        result.add(floorTiles);
        result.add(spawnTiles);
        
        return result;
    }

    public WallTileLevelOne wallDef(Point p) {
        Boolean N = false;
        Boolean S = false;
        Boolean E = false;
        Boolean W = false;
        Boolean NW = false;
        Boolean NE = false;
        Boolean SW = false;
        Boolean SE = false;

        if (tileSpots[p.x][p.y - 1] == TileTypes.WALL || tileSpots[p.x][p.y - 1] == null) {
            N = true;
        }
        if (tileSpots[p.x][p.y + 1] == TileTypes.WALL || tileSpots[p.x][p.y + 1] == null) {
            S = true;
        }
        if (tileSpots[p.x + 1][p.y] == TileTypes.WALL || tileSpots[p.x + 1][p.y] == null) {
            E = true;
        }
        if (tileSpots[p.x - 1][p.y] == TileTypes.WALL || tileSpots[p.x - 1][p.y] == null) {
            W = true;
        }

        if (tileSpots[p.x - 1][p.y - 1] == TileTypes.WALL || tileSpots[p.x - 1][p.y - 1] == null) {
            NW = true;
        }
        if (tileSpots[p.x + 1][p.y - 1] == TileTypes.WALL || tileSpots[p.x + 1][p.y - 1] == null) {
            NE = true;
        }
        if (tileSpots[p.x - 1][p.y + 1] == TileTypes.WALL || tileSpots[p.x - 1][p.y + 1] == null) {
            SW = true;
        }
        if (tileSpots[p.x + 1][p.y + 1] == TileTypes.WALL || tileSpots[p.x + 1][p.y + 1] == null) {
            SE = true;
        }

        WallTileLevelOne wall = new WallTileLevelOne(Walls.P);
        if (N) {
            wall = new WallTileLevelOne(Walls.N);
        }
        if (S) {
            wall = new WallTileLevelOne(Walls.S);
        }
        if (E) {
            wall = new WallTileLevelOne(Walls.E);
        }
        if (W) {
            wall = new WallTileLevelOne(Walls.W);
        }
        if (E) {
            wall = new WallTileLevelOne(Walls.E);
        }
        if (N && E) {
            wall = new WallTileLevelOne(Walls.N_E);
        }
        if (N && S) {
            wall = new WallTileLevelOne(Walls.N_S);
        }
        if (E && S) {
            wall = new WallTileLevelOne(Walls.E_S);
        }
        if (E && W) {
            wall = new WallTileLevelOne(Walls.E_W);
        }
        if (S && W) {
            wall = new WallTileLevelOne(Walls.S_W);
        }
        if (W && N) {
            wall = new WallTileLevelOne(Walls.W_N);
        }
        if (N && NE && E) {
            wall = new WallTileLevelOne(Walls.N_NE_E);
        }
        if (N && W && NW) {
            wall = new WallTileLevelOne(Walls.N_W_NW);
        }
        if (S && SW && W) {
            wall = new WallTileLevelOne(Walls.S_SW_W);
        }
        if (E && SE && S) {
            wall = new WallTileLevelOne(Walls.E_SE_S);
        }
        if (N && E && S) {
            wall = new WallTileLevelOne(Walls.N_E_S);
        }
        if (E && S && W) {
            wall = new WallTileLevelOne(Walls.E_S_W);
        }
        if (N && S && W) {
            wall = new WallTileLevelOne(Walls.N_S_W);
        }
        if (N && E && W) {
            wall = new WallTileLevelOne(Walls.N_E_W);
        }
        if (N && E && SE && S) {
            wall = new WallTileLevelOne(Walls.N_E_SE_S);
        }
        if (E && SE && S && W) {
            wall = new WallTileLevelOne(Walls.E_SE_S_W);
        }
        if (E && S && SW && W) {
            wall = new WallTileLevelOne(Walls.E_S_SW_W);
        }
        if (N && S && W && NW) {
            wall = new WallTileLevelOne(Walls.N_S_W_NW);
        }
        if (N && E && W && NW) {
            wall = new WallTileLevelOne(Walls.N_E_W_NW);
        }
        if (N && NE && E && W) {
            wall = new WallTileLevelOne(Walls.N_NE_E_W);
        }
        if (N && NE && E && S) {
            wall = new WallTileLevelOne(Walls.N_NE_E_S);
        }
        if (N && S && SW && W) {
            wall = new WallTileLevelOne(Walls.N_S_SW_W);
        }
        if (N && NE && E && S && W) {
            wall = new WallTileLevelOne(Walls.N_NE_E_S_W);
        }
        if (N && E && SE && S && W) {
            wall = new WallTileLevelOne(Walls.N_E_SE_S_W);
        }
        if (N && E && S && SW && W) {
            wall = new WallTileLevelOne(Walls.N_E_S_SW_W);
        }
        if (N && E && S && W && NW) {
            wall = new WallTileLevelOne(Walls.N_E_S_W_NW);
        }
        if (E && SE && S && SW && W) {
            wall = new WallTileLevelOne(Walls.E_SE_S_SW_W);
        }
        if (N && NE && E && SE && S) {
            wall = new WallTileLevelOne(Walls.N_NE_E_SE_S);
        }
        if (N && NE && E && W && NW) {
            wall = new WallTileLevelOne(Walls.N_NE_E_W_NW);
        }
        if (N && S && SW && W && NW) {
            wall = new WallTileLevelOne(Walls.N_S_SW_W_NW);
        }
        if (N && E && S && SW && W && NW) {
            wall = new WallTileLevelOne(Walls.N_E_S_SW_W_NW);
        }
        if (N && NE && E && SE && S && W) {
            wall = new WallTileLevelOne(Walls.N_NE_E_SE_S_W);
        }
        if (N && NE && E && S && W && NW) {
            wall = new WallTileLevelOne(Walls.N_NE_E_S_W_NW);
        }
        if (N && E && SE && S && SW && W) {
            wall = new WallTileLevelOne(Walls.N_E_SE_S_SW_W);
        }
        if (N && NE && E && S && SW && W) {
            wall = new WallTileLevelOne(Walls.N_NE_E_S_SW_W);
        }
        if (N && E && SE && S && W && NW) {
            wall = new WallTileLevelOne(Walls.N_E_SE_S_W_NW);
        }
        if (N && E && SE && S && SW && W && NW) {
            wall = new WallTileLevelOne(Walls.N_E_SE_S_SW_W_NW);
        }
        if (N && NE && E && SE && S && SW && W) {
            wall = new WallTileLevelOne(Walls.N_NE_E_SE_S_SW_W);
        }
        if (N && NE && E && SE && S && W && NW) {
            wall = new WallTileLevelOne(Walls.N_NE_E_SE_S_W_NW);
        }
        if (N && NE && E && S && SW && W && NW) {
            wall = new WallTileLevelOne(Walls.N_NE_E_S_SW_W_NW);
        }
        if (N && NE && E && SE && S && SW && W && NW) {
            System.out.println("something went wrong");
        }

        return wall;
    }

}
