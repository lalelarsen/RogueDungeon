/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Components.BaseObject;
import Components.GameScene;
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
    public Wall w;

    public SceneOne() {
        Hero = new MainCharacter();
        w = new Wall();
        Hero.setCords(50, 270);
        Hero.addHitbox(20, 20, new Point(100,100),false);
        w.setCords(30, 240);
        p1 = Hero;
        camera = Hero;
        
        Generator g = new Generator(OC.units);
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Future<ArrayList<BaseObject>> future = pool.submit(g);
        
        while (!future.isDone()) {
            System.out.println(future.isDone());
            try {

                OC.units.addAll(future.get());
            } catch (Exception e) {
                
            }
        }
        OC.units.add(Hero);
        OC.units.add(w);

    }

}
