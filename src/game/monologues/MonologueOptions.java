package game.monologues;

import java.util.ArrayList;
import java.util.Random;

public class MonologueOptions {
    private ArrayList<String> monologueOptions;

    public MonologueOptions(){
        monologueOptions = new ArrayList<>();
    }

    public void addOption(String option){
        monologueOptions.add(option);
    }

    public String chooseOption(){
        Random rand = new Random();
        String chosenMessage = monologueOptions.get(rand.nextInt(monologueOptions.size()));
        return String.format("\"%s\"",chosenMessage);
    }

    public void clearOption(){
        monologueOptions.clear();
    }
}
