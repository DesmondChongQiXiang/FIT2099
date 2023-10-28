package game.reset;

import java.util.ArrayList;

/**
 * The `ResetManager` class is responsible for managing entities that need to be reset during the game.
 * It provides a centralized mechanism to register, remove, and notify reset events for various entities.
 */
public class ResetManager {
    private static ResetManager resetManager;
    private ArrayList<ResetNotifiable> resetNotifiableEntities;
    private ResetManager(){
        this.resetNotifiableEntities = new ArrayList<>();
    }

    /**
     * Get the instance of the `ResetManager` using the Singleton pattern.
     *
     * @return The `ResetManager` instance.
     */
    public static ResetManager getInstance() {
        if (resetManager == null) {
            resetManager = new ResetManager();
        }
        return resetManager;
    }

    /**
     * Runs the reset process by notifying all registered reset notifiable entities.
     */
    public void run() {
        for(ResetNotifiable resetNotifiableEntity : resetNotifiableEntities){
            resetNotifiableEntity.notifyReset();
        }
    }

    /**
     * Register an entity to be notified and reset when a reset event occurs.
     *
     * @param resetNotifiable The entity that should be registered.
     */
    public void registerResetNotifiable(ResetNotifiable resetNotifiable){
        this.resetNotifiableEntities.add(resetNotifiable);
    }

    /**
     * Remove a registered reset notifiable entity from the manager.
     *
     * @param resetNotifiable The entity to be removed from the manager.
     */
    public void removeResetNotifiable(ResetNotifiable resetNotifiable){
        this.resetNotifiableEntities.remove(resetNotifiable);
    }
}
