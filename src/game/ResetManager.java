package game;

import edu.monash.fit2099.engine.positions.GameMap;

import java.util.ArrayList;
import java.util.HashMap;

public class ResetManager {
    private ArrayList<Reset> resetEntities;
    private HashMap<String,GameMap> gameMapHashMap;
    public ResetManager(ArrayList<Reset> resetEntities, HashMap<String, GameMap> gameMapHashMap){
        this.resetEntities = resetEntities;
        this.gameMapHashMap = gameMapHashMap;
    }
    public void resetGame() {
        for(Reset resetEntity : resetEntities){
            resetEntity.reset();
        }
        for(GameMap map:gameMapHashMap.values()){
            map.tick();
        }
    }
}
