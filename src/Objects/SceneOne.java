/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Components.BaseObject;
import Components.GameScene;
import Objects.Enemies.LevelOneEnemyOne;
import Objects.Tiles.LadderTileLevelOne;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static java.util.concurrent.Executors.callable;
import java.util.concurrent.Future;

/**
 *
 * @author frederik.larsen
 */
public class SceneOne extends GameScene {

    public MainCharacter Hero;
    public LadderTileLevelOne lad;
    public int numberOffEnemies = 1;
    public ArrayList<BaseObject> spawnList = new ArrayList();
    Random rand = new Random();
    CameraObject CO;

    public SceneOne() {
        Hero = new MainCharacter();
//        Hero.addSquareHitbox(20, 20, new Point(60,30),true);
        OC.units.add(Hero);

        p1 = Hero;
        // camera = Hero;


        Generator g = new Generator();
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Future<ArrayList<ArrayList<BaseObject>>> future = pool.submit(g);

        while (!future.isDone()) {
//            System.out.println("loading");
        }
        try {
            OC.units.addAll(future.get().get(0));
            OC.bgUnits.addAll(future.get().get(1));
            spawnList = future.get().get(2);
        } catch (Exception e) {
            System.err.println("Something went wrong2");
        }
        
        ArrayList<Point> spawnPoints = new ArrayList();
        for (int i = 0; i < spawnList.size(); i++) {
            spawnPoints.add(spawnList.get(i).pos);
        }
        
        
        CO = new CameraObject();
        int n1 = rand.nextInt(spawnPoints.size() - 1);
        Point p1 = new Point(spawnPoints.get(n1).x, spawnPoints.get(n1).y);
        CO.setCords(p1.x, p1.y);
        OC.units.add(CO);


        for (int i = 0; i < numberOffEnemies; i++) {
            LevelOneEnemyOne enemyTest = new LevelOneEnemyOne();
            int n = rand.nextInt(spawnPoints.size() - 1);
            Point p = new Point(spawnPoints.get(n).x, spawnPoints.get(n).y);
            enemyTest.setCords(p.x, p.y + 8 * 4);
            spawnPoints.remove(n);
            OC.units.add(enemyTest);
        }

        int n = rand.nextInt(spawnPoints.size() - 1);
        Point p = new Point(spawnPoints.get(n).x, spawnPoints.get(n).y);
        lad = new LadderTileLevelOne();
        lad.setCords(p.x, p.y+8*4);
        OC.units.add(lad);

        int n2 = rand.nextInt(spawnPoints.size() - 1);
        Point p2 = new Point(spawnPoints.get(n2).x, spawnPoints.get(n2).y);
        Hero.setCords(p2.x, p2.y+8*4);

    }

    @Override
    public void sceneUpdate() {
        CO.updateCameraPos();
        camera.pos = CO.pos;
    }
}
