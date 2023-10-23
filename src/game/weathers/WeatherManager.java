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
    private Weather currentWeather;
    private ArrayList<WeatherControllableSpawner> weatherControllableSpawnerSpawnerList;
    private ArrayList<WeatherControllableEnemy> weatherControllableSpawnerEnemyList;

    /**
     * Constructor for the WeatherManager class.
     *
     * @param currentWeather The initial weather condition in the game.
     * @param weatherControllableSpawnerSpawnerList A list of objects that implement WeatherControllable and are affected
     *                                       by weather conditions.
     */
    public WeatherManager(Weather currentWeather, ArrayList<WeatherControllableSpawner> weatherControllableSpawnerSpawnerList) {
        this.weatherControllableSpawnerSpawnerList = weatherControllableSpawnerSpawnerList;
        this.currentWeather = currentWeather;
        this.weatherControllableSpawnerEnemyList = new ArrayList<>();
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
        for (WeatherControllableSpawner weatherControllableSpawner : weatherControllableSpawnerSpawnerList) {
            weatherControllableSpawner.updateWeatherMode(currentWeather, display, weatherControllableSpawnerEnemyList);
        }
        for(WeatherControllableEnemy weatherControllableSpawnerEnemy : weatherControllableSpawnerEnemyList){
            weatherControllableSpawnerEnemy.updateWeatherMode(currentWeather,display);
        }
        weatherControllableSpawnerEnemyList.clear();
    }
}

