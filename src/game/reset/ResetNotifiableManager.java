package game.reset;

import java.util.ArrayList;

/**
 * The `ResetNotifiableManager` class is responsible for managing entities that need to be notify reset during the game.
 * It provides a centralized mechanism to register, remove, and notify reset events for various entities.
 */
public class ResetNotifiableManager {
    private static ResetNotifiableManager resetNotifiableManager;
    private ArrayList<ResetNotifiable> resetNotifiableEntities;
    private ResetNotifiableManager(){
        this.resetNotifiableEntities = new ArrayList<>();
    }

    /**
     * Get the instance of the `ResetNotifiableManager` using the Singleton pattern.
     *
     * @return The `ResetNotifiableManager` instance.
     */
    public static ResetNotifiableManager getInstance() {
        if (resetNotifiableManager == null) {
            resetNotifiableManager = new ResetNotifiableManager();
        }
        return resetNotifiableManager;
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
