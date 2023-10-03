package game.weathers;

import java.util.ArrayList;
import java.util.List;

public class WeatherControl {

    private List<String> weatherList;
    private int turnCount;
    private String currentWeather;

    public WeatherControl() {
        this.weatherList = new ArrayList<String>();
        weatherList.add("SUNNY");
        weatherList.add("RAINY");
        this.turnCount = 0;
        this.currentWeather = weatherList.get(0);
    }

    public String getCurrentWeather() {
        return currentWeather;
    }

    public void tick() {
        turnCount++;
        if (turnCount % 3 == 0) {
            switchWeather();
        }
    }

    private void switchWeather() {
        if (currentWeather == "SUNNY"){
            currentWeather = weatherList.get(1);
        }else {
            currentWeather = weatherList.get(0);
        }
    }
}
