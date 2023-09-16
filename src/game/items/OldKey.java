package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.utils.Ability;

/**
 * A class that represents an item which will be dropped when the enemy is defeated.
 * Actor can unlock the gate by using this item.
 *
 * @author Yoong Qian Xin
 */
public class OldKey extends Item {

  /**
   * Constructor.
   */
  public OldKey() {
    super("OldKey", '-', true);
    this.addCapability(Ability.OPEN_GATE);
  }


}
