package game.spawners;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.ForestKeeper;
import game.weathers.Weather;
import game.weathers.WeatherControllableEnemy;
import game.weathers.WeatherControllableSpawner;
import java.util.ArrayList;

/**
 * Spawner for generating instances of the ForestKeeper.
 */
public class ForestKeeperSpawner extends Spawner implements WeatherControllableSpawner {

    private ArrayList<ForestKeeper> forestKeeperList;
    public ForestKeeperSpawner(){
        super(15);
        forestKeeperList = new ArrayList<>();
    }

    @Override
    public void spawn(Location location) {
        if (Math.random() <= ((double) spawnRate / 100) && !location.containsAnActor()) {
            ForestKeeper forestKeeper = createEnemy();
            location.addActor(forestKeeper);
            forestKeeperList.add(forestKeeper);
            enemyList.add(forestKeeper);
        }
    }

    @Override
    public ForestKeeper createEnemy() {
        return new ForestKeeper();
    }

    /**
     * Updates the spawn rate and behavior of Forest Keepers based on the current weather conditions.
     *
     * @param weather The current weather in the game.
     * @param display The display interface used to print messages about weather-related changes.
     */
    @Override
    public void updateWeatherMode(Weather weather, Display display, ArrayList<WeatherControllableEnemy> weatherControllableSpawnerEnemyList) {
        if(weather == Weather.SUNNY){
            super.setSpawnRate(30);
            display.println("The forest keepers are becoming more active.");
        }
        else if(weather == Weather.RAINY){
            super.setSpawnRate(15);
            display.println("The forest keepers are becoming less active.");
        }
        weatherControllableSpawnerEnemyList.addAll(forestKeeperList);
    }

    @Override
    public void resetAction(Location location) {
        super.resetAction(location);
        forestKeeperList.clear();
    }
}
