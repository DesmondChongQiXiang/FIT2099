package game.weathers;

import edu.monash.fit2099.engine.displays.Display;

import java.util.ArrayList;

/**
 * The WeatherManager class is responsible for managing the game's weather conditions and their effects on
 * objects that implement the WeatherControllable interface. It allows for switching between different weather
 * conditions and updating the behavior or state of objects in response to weather changes.
 *
 * @author MA_AppliedSession1_Group7
 */
public class WeatherManager {
    private static WeatherManager weatherManager;
    private Weather currentWeather;
    private ArrayList<WeatherControllable> weatherControllableEntites;

    /**
     * Constructor for the WeatherManager class.
     * Initializes the current weather to be rainy and creates an empty list of weather-controllable entities.
     */
    private WeatherManager() {
        this.currentWeather = Weather.RAINY;
        this.weatherControllableEntites = new ArrayList<>();
    }

    /**
     * Constructor for the WeatherManager class.
     * Initializes the current weather to be rainy and creates an empty list of weather-controllable entities.
     */
    public static WeatherManager getInstance() {
        if (weatherManager == null) {
            weatherManager = new WeatherManager();
        }
        return weatherManager;
    }

    /**
     * Switches the current weather condition between sunny and rainy.
     * Outputs a message indicating the weather change to the provided display.
     *
     * @param display The display used to output information about the weather change.
     */
    public void switchWeather(Display display) {
        if (currentWeather == Weather.SUNNY) {
            currentWeather = Weather.RAINY;
            display.println("The weather is now rainy...");
        } else {
            currentWeather = Weather.SUNNY;
            display.println("The weather is now sunny...");
        }
    }

    /**
     * Updates the behavior or state of objects implementing the WeatherControllable interface
     * based on the current weather condition.
     * Outputs information about the weather-related changes to the provided display.
     *
     * @param display The display used to output information about the weather-related changes.
     */
    public void controlEnemy(Display display) {
        for (WeatherControllable weatherControllableSpawner : weatherControllableEntites) {
            weatherControllableSpawner.updateWeatherMode(currentWeather, display);
        }
    }

    /**
     * Registers a weather-controllable entity to be managed by the WeatherManager.
     *
     * @param weatherControllable The entity implementing the WeatherControllable interface.
     */
    public void registerWeatherControllable(WeatherControllable weatherControllable){
        this.weatherControllableEntites.add(weatherControllable);
    }

    /**
    * Removes a weather-controllable entity from the list of managed entities.
    *
    * @param weatherControllable The entity to be removed.
    */
    public void removeWeatherControllable(WeatherControllable weatherControllable){
        this.weatherControllableEntites.remove(weatherControllable);
    }
}

