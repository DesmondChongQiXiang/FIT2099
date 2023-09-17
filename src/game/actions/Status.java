package game.actions;

/**
 * Use this enum class to represent a status.
 * Example #1: if the player is sleeping, you can attack a Status.SLEEP to the player class
 * Created by:
 *
 * @version 1.0
 */
public enum Status {

    /**
     * Represents a hostile state towards enemies.
     * Entities with this status are actively hostile and may attack enemies.
     */
    HOSTILE_TO_ENEMY,

    /**
     * Represents being attacked by an enemy.
     * Entities with this status have been targeted or attacked by enemies.
     */
    ATTACKED_BY_ENEMY,
}
