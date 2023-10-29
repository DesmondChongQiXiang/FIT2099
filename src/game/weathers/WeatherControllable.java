package game.weathers;

import edu.monash.fit2099.engine.displays.Display;

/**
 * The WeatherControllable interface defines methods for objects that can be affected by changes in weather conditions.
 * Classes implementing this interface can specify how they respond to different weather modes.
 *
 * @author MA_AppliedSession1_Group7
 */
public interface WeatherControllable {
    /**
     * Updates the behavior or state of an object based on the current weather condition.
     *
     * @param weather The current weather mode.
     * @param display The display used to output information about the weather-related changes.
     */
    void updateWeatherMode(Weather weather, Display display);
}
