/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Components.BaseObject;
import Components.GameScene;
import Objects.Enemies.LevelOneEnemyOne;
import java.awt.Point;
import java.util.ArrayList;
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
    public LevelOneEnemyOne enemy1;
    public LevelOneEnemyOne enemy2;
    public LevelOneEnemyOne enemy3;
    public LevelOneEnemyOne enemy4;
    public LevelOneEnemyOne enemy5;
    public LevelOneEnemyOne enemy6;
    public LevelOneEnemyOne enemy7;
    public LevelOneEnemyOne enemy8;
    public LevelOneEnemyOne enemy9;
    public LevelOneEnemyOne enemy10;
    

    public SceneOne() {
        Hero = new MainCharacter();
        Hero.setCords(50, 270);
//        Hero.addSquareHitbox(20, 20, new Point(60,30),true);
        OC.units.add(Hero);
        
        p1 = Hero;
        camera = Hero;
        
        Generator g = new Generator();
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Future<ArrayList<ArrayList<BaseObject>>> future = pool.submit(g);
        
        while (!future.isDone()) {
            System.out.println("loading");
            try {
                OC.units.addAll(future.get().get(0));
                OC.bgUnits.addAll(future.get().get(1));
            } catch (Exception e) {
                
            }
        }
        
        enemy1 = new LevelOneEnemyOne();
        enemy1.setCords(20, 20);
        OC.units.add(enemy1);
        
        enemy2 = new LevelOneEnemyOne();
        enemy2.setCords(50, 20);
        OC.units.add(enemy2);
        enemy3 = new LevelOneEnemyOne();
        enemy3.setCords(80, 20);
        OC.units.add(enemy3);
        enemy4 = new LevelOneEnemyOne();
        enemy4.setCords(110, 20);
        OC.units.add(enemy4);
        enemy5 = new LevelOneEnemyOne();
        enemy5.setCords(140, 20);
        OC.units.add(enemy5);
        enemy6 = new LevelOneEnemyOne();
        enemy6.setCords(170, 20);
        OC.units.add(enemy6);
        enemy7 = new LevelOneEnemyOne();
        enemy7.setCords(200, 20);
        OC.units.add(enemy7);
        enemy8 = new LevelOneEnemyOne();
        enemy8.setCords(230, 20);
        OC.units.add(enemy8);
        enemy9 = new LevelOneEnemyOne();
        enemy9.setCords(260, 20);
        OC.units.add(enemy9);
        enemy10 = new LevelOneEnemyOne();
        enemy10.setCords(290, 20);
        OC.units.add(enemy10);

    }

}
