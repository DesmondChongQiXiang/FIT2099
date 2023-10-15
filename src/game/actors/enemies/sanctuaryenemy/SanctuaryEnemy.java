package game.actors.enemies.sanctuaryenemy;

import game.actors.enemies.Enemy;
import game.capabilities.Ability;
import game.items.Runes;

public abstract class SanctuaryEnemy extends Enemy {

    /**
     * Constructor for creating an enemy actor.
     *
     * @param name            The name of the enemy.
     * @param displayChar     Character to represent the enemy in the UI.
     * @param hitPoints       Enemy's starting number of hit points.
     * @param runesDropped The number of runes this enemy drops when defeated.
     */
    public SanctuaryEnemy(String name, char displayChar, int hitPoints, Runes runesDropped) {
        super(name, displayChar, hitPoints, runesDropped);
        this.addCapability(Ability.ENTER_VOID);
    }


}
