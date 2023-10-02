package game.capabilities;

/**
 * Use this enum to represent abilities.
 * Example #1: if the player is capable jumping over walls, you can attach Ability.WALL_JUMP to the player class
 */
public enum Ability {

    /**
     * To indicate that the actor can enter the floor.
     */
    ENTER_FLOOR,

    /**
     * To indicate if the actor has an old key to unlock the gate.
     */
    UNLOCK_GATE,

    LOCKED_GATE,

    /**
     * To indicate that the actor has the ability to buy items.
     */
    BUYING,

    /**
     * To indicate that the actor can enter the floor.
     */
    ENTER_VOID,
}
