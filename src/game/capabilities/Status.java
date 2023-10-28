package game.capabilities;

/**
 * Enum representing different status conditions that actors can have in the game.
 * These statuses can be attached to actor classes to influence their behavior or interactions.
 *
 * Example usage:
 * - To indicate that a player is sleeping, attach Status.SLEEP to the player class.
 * - To determine if an actor can attack another actor, use Status.HOSTILE_TO_ENEMY capability.
 * - To identify an enemy actor, use Status.ENEMY.
 *
 * @author : MA_AppliedSession1_Group7
 *
 * @see game.actors.Player
 */
public enum Status {

    /**
     * Status indicating that an actor is hostile and can attack enemies.
     */
    HOSTILE_TO_ENEMY,

    /**
     * Status indicating that an actor is an enemy.
     */
    ENEMY,

    /**
     * Status indicating that a boss has been defeated.
     */
    BOSS_DEFEATED,
}
