package game.spawners;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.actors.enemies.RedWolf;
import game.weathers.Weather;
import game.weathers.WeatherControllable;
import game.weathers.WeatherManager;

/**
 * The `RedWolfSpawner` class is responsible for spawning instances of the RedWolf enemy actor at specific locations within
 * the game world. It also adjusts the spawn rate of Red Wolves based on current weather conditions.
 */
public class RedWolfSpawner implements Spawner,WeatherControllable {
    private int spawnRate;
    /**
     * Constructs a `RedWolfSpawner` with an initial spawn rate of 30%.
     */
    public RedWolfSpawner() {
        this.spawnRate = 30;
    }

    /**
     * Spawns an instance of the RedWolf enemy actor at the specified location within the game world, if the spawn conditions are met.
     *
     * @param location The location where the RedWolf should be spawned.
     * @return a Red Wolf that has been spawned.
     */
    @Override
    public Enemy spawn(Location location) {
        if (Math.random() <= ((double) spawnRate / 100) && !location.containsAnActor()) {
            RedWolf redWolf = new RedWolf();
            location.addActor(redWolf);
            WeatherManager.getInstance().registerWeatherControllable(redWolf);
            return redWolf;
        }
        return null;
    }

    /**
     * Updates the Red Wolf spawning rate based on the current weather conditions and informs any associated ForestEnemies.
     *
     * @param weather The current weather in the game.
     * @param display The display interface used to show weather-related messages.
     */
    @Override
    public void updateWeatherMode(Weather weather, Display display) {
        if (weather == Weather.SUNNY) {
            spawnRate = 30;
            display.println("The red wolves are becoming less active.");
        } else if (weather == Weather.RAINY) {
            spawnRate = 45;
            display.println("The red wolves are becoming more active.");
        }
    }
}
