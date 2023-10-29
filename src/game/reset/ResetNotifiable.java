package game.reset;

/**
 * The `ResetNotifiable` interface is implemented by entities that can be notified and reset
 * when a reset event occurs in the game.
 */
public interface ResetNotifiable {

    /**
     * Notifies the implementing entity that a reset event has occurred.
     */
    void notifyReset();
}
