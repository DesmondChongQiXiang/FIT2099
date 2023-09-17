package game.actions;

/**
 * This enum represents various abilities that can be attached to game entities or characters.
 * Abilities define specific actions or capabilities that entities can possess.
 *
 * Example #1: To allow a player to enter certain floors, you can attach Ability.ENABLE_ENTER_FLOOR to the player class.
 * Example #2: To enable a character to unlock locked gates, you can attach Ability.UNLOCK_LOCKED_GATE to the character class.
 *
 * @author Ong Chong How
 * @version 1.0
 */
public enum Ability {

    /**
     * Represents the ability to enter specific floors or areas.
     * Attach this ability to entities to enable them to access restricted areas.
     */
    ENABLE_ENTER_FLOOR,

    /**
     * Represents the ability to unlock locked gates or obstacles.
     * Attach this ability to entities to allow them to open locked passages.
     */
    UNLOCK_LOCKED_GATE,
}
