package game;

import edu.monash.fit2099.engine.positions.GameMap;

import java.util.ArrayList;
import java.util.HashMap;

public class ResetManager {
    private ArrayList<Resettable> resettableEntities;
    private HashMap<String,GameMap> gameMapHashMap;
    public ResetManager(ArrayList<Resettable> resettableEntities,HashMap<String, GameMap> gameMapHashMap){
        this.resettableEntities = resettableEntities;
        this.gameMapHashMap = gameMapHashMap;
    }
    public void resetGame() {
        for(Resettable resettableEntity: resettableEntities){
            resettableEntity.reset();
        }
        for(GameMap map:gameMapHashMap.values()){
            map.tick();
        }
    }
}
