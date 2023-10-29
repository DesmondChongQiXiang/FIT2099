package game.capabilities;

/**
 * Enum representing various abilities that actors can possess in the game.
 * These abilities can be attached to actor classes to enable specific behaviors.
 *
 * Example usage:
 * - To indicate that a player can enter a special floor, attach Ability.ENTER_FLOOR to the player class.
 * - To check if an actor can unlock a gate with an old key, use Ability.UNLOCK_GATE capability.
 * - To allow an actor to buy items, attach Ability.BUYING to the actor class.
 * - To indicate that an actor can enter a void area, use Ability.ENTER_VOID.
 *
 * @author : MA_AppliedSession1_Group7
 *
 * @see game.actors.Player
 */
public enum Ability {

    /**
     * Ability indicating that the actor can enter a special floor.
     */
    ENTER_FLOOR,

    /**
     * Ability indicating that the actor can unlock a gate.
     */
    UNLOCK_GATE,

    /**
     * Ability indicating that the actor has the ability to buy items.
     */
    BUYING,

    /**
     * Ability indicating that the actor can enter a void area.
     */
    ENTER_VOID,

    /**
     * Ability indicating that the actor can upgrade their equipment.
     */
    UPGRADE_EQUIPMENT,

    /**
     * Ability indicating that the actor can listen to a story.
     */
    LISTEN_STORY,

    /**
     * Ability indicating that the actor can use a great knife as a weapon.
     */
    USE_GREATKNIFE,

    /**
     * Ability indicating that the actor can use a giant hammer as a weapon.
     */
    USE_GIANTHAMMER,
}
