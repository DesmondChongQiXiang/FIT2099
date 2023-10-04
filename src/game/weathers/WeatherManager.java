package game.weathers;

import edu.monash.fit2099.engine.displays.Display;

import java.util.ArrayList;

public class WeatherManager {
    Weather currentWeather;
    private ArrayList<WeatherControllable> forestEnemySpawnableGroundList;

    public WeatherManager(Weather currentWeather,ArrayList<WeatherControllable> forestEnemySpawnableGroundList){
        this.forestEnemySpawnableGroundList = forestEnemySpawnableGroundList;
        this.currentWeather = currentWeather;
    }

    public void switchWeather(Display display){
        if (currentWeather == Weather.SUNNY) {
            currentWeather = Weather.RAINY;
            display.println("The weather is now rainy...");
            }
        else {
            currentWeather = Weather.SUNNY;
            display.println("The weather is now sunny...");
        }
    }

    public void controlEnemy(Display display){
        for(WeatherControllable weatherControllable: forestEnemySpawnableGroundList){
            weatherControllable.updateWeatherMode(currentWeather,display);
        }
    }
}
