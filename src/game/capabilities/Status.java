package game.capabilities;


/**
 * Use this enum class to represent a status.
 * Example #1: if the player is sleeping, you can attack a Status.SLEEP to the player class
 * Created by:
 * @author Riordan D. Alfredo
 */
public enum Status {

    /**
     * To determine if other actors can attack the enemy.
     */
    HOSTILE_TO_ENEMY,
    /**
     * To determine if the actor is an enemy.
     */
    ENEMY

}
