package game.spawners;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.ForestKeeper;
import game.weathers.Weather;
import game.weathers.WeatherControllable;
import game.weathers.WeatherManager;

/**
 * The `ForestKeeperSpawner` class is responsible for spawning instances of the ForestKeeper enemy actor
 * at specific locations within the game world. It also implements the WeatherControllable interface to
 * update the spawn rate and behavior of Forest Keepers based on the current weather conditions.
 */
public class ForestKeeperSpawner extends Spawner implements WeatherControllable {
    /**
     * Constructs a `ForestKeeperSpawner` with a default spawn rate and an empty list of enemy actors.
     */
    public ForestKeeperSpawner() {
        super(15);
    }

    /**
     * Spawns an instance of the ForestKeeper enemy actor at the specified location within the game world.
     * The spawn rate may be influenced by weather conditions.
     *
     * @param location The location where the ForestKeeper should be spawned.
     */
    @Override
    public void spawn(Location location) {
        if (Math.random() <= ((double) spawnRate / 100) && !location.containsAnActor()) {
            ForestKeeper forestKeeper = createEnemy();
            location.addActor(forestKeeper);
            WeatherManager.getInstance().registerWeatherControllable(forestKeeper);
            enemyList.add(forestKeeper);
        }
    }

    /**
     * Updates the spawn rate and behavior of Forest Keepers based on the current weather conditions.
     * It adjusts the spawn rate and provides feedback based on different weather states.
     *
     * @param weather The current weather in the game.
     * @param display The display interface used to print messages about weather-related changes.
     */
    @Override
    public void updateWeatherMode(Weather weather, Display display) {
        if (weather == Weather.SUNNY) {
            spawnRate = 30;
            display.println("The forest keepers are becoming more active.");
        } else if (weather == Weather.RAINY) {
            spawnRate = 15;
            display.println("The forest keepers are becoming less active.");
        }
    }

    /**
     * Creates and returns a new instance of the ForestKeeper enemy actor.
     *
     * @return The ForestKeeper enemy actor created by this spawner.
     */
    @Override
    public ForestKeeper createEnemy() {
        return new ForestKeeper();
    }
}

