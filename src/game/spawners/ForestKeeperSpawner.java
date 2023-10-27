package game.spawners;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.actors.enemies.ForestKeeper;
import game.weathers.Weather;
import game.weathers.WeatherControllable;
import game.weathers.WeatherManager;

import java.util.ArrayList;

/**
 * Spawner for generating instances of the ForestKeeper.
 */
public class ForestKeeperSpawner implements Spawner, WeatherControllable{
    protected ArrayList<Enemy> enemyList;
    private int spawnRate;

    public ForestKeeperSpawner(){
        spawnRate = 15;
        enemyList = new ArrayList<>();
    }

    @Override
    public void spawn(Location location) {
        if (Math.random() <= ((double) spawnRate / 100) && !location.containsAnActor()) {
            ForestKeeper forestKeeper = new ForestKeeper();
            location.addActor(forestKeeper);
            WeatherManager.getInstance().registerWeatherControllable(forestKeeper);
            enemyList.add(forestKeeper);
        }
    }

    /**
     * Updates the spawn rate and behavior of Forest Keepers based on the current weather conditions.
     *
     * @param weather The current weather in the game.
     * @param display The display interface used to print messages about weather-related changes.
     */
    @Override
    public void updateWeatherMode(Weather weather, Display display) {
        if(weather == Weather.SUNNY){
            spawnRate = 30;
            display.println("The forest keepers are becoming more active.");
        }
        else if(weather == Weather.RAINY){
            spawnRate = 15;
            display.println("The forest keepers are becoming less active.");
        }
    }

    @Override
    public void reset(Location location) {
        for (Enemy enemy : enemyList){
            enemy.reset(location);
        }
    }
}
