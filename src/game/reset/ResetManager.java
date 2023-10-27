package game.reset;

import java.util.ArrayList;

public class ResetManager {
    private static ResetManager resetManager;
    private ArrayList<ResetNotifiable> resetNotifiableEntities;
    private ResetManager(){
        this.resetNotifiableEntities = new ArrayList<>();
    }

    public static ResetManager getInstance() {
        if (resetManager == null) {
            resetManager = new ResetManager();
        }
        return resetManager;
    }

    public void run() {
        for(ResetNotifiable resetNotifiableEntity : resetNotifiableEntities){
            resetNotifiableEntity.notifyReset();
        }
    }

    public void registerResetNotifiable(ResetNotifiable resetNotifiable){
        this.resetNotifiableEntities.add(resetNotifiable);
    }

    public void removeResetNotifiable(ResetNotifiable resetNotifiable){
        this.resetNotifiableEntities.remove(resetNotifiable);
    }
}
