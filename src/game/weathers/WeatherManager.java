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
     *
     */
    private WeatherManager() {
        this.currentWeather = Weather.RAINY;
        this.weatherControllableEntites = new ArrayList<>();
    }

    public static WeatherManager getInstance() {
        if (weatherManager == null) {
            weatherManager = new WeatherManager();
        }
        return weatherManager;
    }

    /**
     * Switches the current weather condition between sunny and rainy.
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
     * Updates the behavior or state of objects in the forestEnemySpawnableGroundList based on the current weather condition.
     *
     * @param display The display used to output information about the weather-related changes.
     */
    public void controlEnemy(Display display) {
        for (WeatherControllable weatherControllableSpawner : weatherControllableEntites) {
            weatherControllableSpawner.updateWeatherMode(currentWeather, display);
        }
    }

    public void registerWeatherControllable(WeatherControllable weatherControllable){
        this.weatherControllableEntites.add(weatherControllable);
    }

    public void removeWeatherControllable(WeatherControllable weatherControllable){
        this.weatherControllableEntites.remove(weatherControllable);
    }
}

