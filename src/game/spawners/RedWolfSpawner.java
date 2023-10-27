package game.spawners;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.actors.enemies.RedWolf;
import game.weathers.Weather;
import game.weathers.WeatherControllable;
import game.weathers.WeatherManager;
import java.util.ArrayList;

/**
 * Spawner for generating instances of the Red Wolf.
 */
public class RedWolfSpawner implements Spawner,WeatherControllable{
    protected ArrayList<Enemy> enemyList;
    private int spawnRate;
    public RedWolfSpawner(){
        spawnRate = 30;
        this.enemyList = new ArrayList<>();
    }

    @Override
    public void spawn(Location location) {
        if (Math.random() <= ((double) spawnRate / 100) && !location.containsAnActor()) {
            RedWolf redWolf = new RedWolf();
            location.addActor(redWolf);
            WeatherManager.getInstance().registerWeatherControllable(redWolf);
            enemyList.add(redWolf);
        }
    }

    /**
     * Updates the Red Wolf spawning rate based on the current weather conditions and informs any associated ForestEnemies.
     *
     * @param weather The current weather.
     * @param display The display interface to show weather-related messages.
     */
    @Override
    public void updateWeatherMode(Weather weather, Display display) {
        if (weather == Weather.SUNNY){
            spawnRate = 30;
            display.println("The red wolves are becoming less active.");
        }
        else if (weather == Weather.RAINY){
            spawnRate = 45;
            display.println("The red wolves are becoming more active.");
        }
    }

    @Override
    public void reset(Location location) {
        for (Enemy enemy : enemyList){
            enemy.reset(location);
        }
    }
}
