package game.weather;

public class WeatherControl {
    private String currentWeather;  // "sunny" or "rainy"
    private int turnCount;

    public WeatherControl() {
        this.currentWeather = "sunny";
        this.turnCount = 0;
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
        if ("sunny".equals(currentWeather)) {
            currentWeather = "rainy";
        } else {
            currentWeather = "sunny";
        }
    }
}
