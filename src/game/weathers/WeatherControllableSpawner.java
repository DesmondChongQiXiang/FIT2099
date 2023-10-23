package game.weathers;

import edu.monash.fit2099.engine.displays.Display;

import java.util.ArrayList;

/**
 * The WeatherControllable interface is implemented by objects in the game that can be affected by weather conditions.
 * Objects that implement this interface can respond to changes in the game's weather, such as updating their behavior
 * or state based on the current weather conditions.
 *
 * @author MA_AppliedSession1_Group7
 */
public interface WeatherControllableSpawner {

    /**
     * Updates the behavior or state of an object based on the current weather conditions.
     *
     * @param weather The current weather condition in the game.
     * @param display The display used to output information about the weather-related changes.
     */
    void updateWeatherMode(Weather weather, Display display, ArrayList<WeatherControllableEnemy> weatherControllableSpawnerEnemyList);
}

