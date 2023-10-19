package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ListenMonologueAction;
import game.capabilities.Ability;
import game.capabilities.Status;
import game.monologues.MonologueOptions;

public class Blacksmith extends Actor {
    private MonologueOptions monologueOptions;

    public Blacksmith() {
        super("Blacksmith", 'B', 0);
        this.addCapability(Ability.UPGRADE_EQUIPMENT);
        this.monologueOptions = new MonologueOptions();
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Ability.LISTEN_STORY)) {
            this.addMonologueOptions(otherActor);
            actions.add(new ListenMonologueAction(monologueOptions,this));
        }
        return actions;
    }

    public void addMonologueOptions(Actor listener){
        this.monologueOptions.clearOption();
        monologueOptions.addOption("I used to be an adventurer like you, but then …. Nevermind, let’s get back to smithing.");
        monologueOptions.addOption("It’s dangerous to go alone. Take my creation with you on your adventure!");
        monologueOptions.addOption("Ah, it’s you. Let’s get back to make your weapons stronger.");
        if (listener.hasCapability(Ability.USE_GREATKNIFE)) {
            monologueOptions.addOption("Hey now, that’s a weapon from a foreign land that I have not seen for so long. I can upgrade it for you if you wish.");
        }
        if (listener.hasCapability(Status.BOSS_DEFEATED)) {
            monologueOptions.addOption("Somebody once told me that a sacred tree rules the land beyond the ancient woods until this day.");
        } else {
            monologueOptions.addOption("Beyond the burial ground, you’ll come across the ancient woods ruled by Abxervyer. Use my creation to slay them and proceed further!");
        }
    }
}