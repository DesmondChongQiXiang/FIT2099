package game.utils;

/**
 * Use this enum to represent abilities.
 * Example #1: if the player is capable jumping over walls, you can attach Ability.WALL_JUMP to the player class
 *
 * Modified by:
 * @author Yoong Qian Xin
 */
public enum Ability {

  /**
   * To indicate that the actor can enter the floor.
   */
  ENTER_FLOOR,

  /**
   * To indicate if the actor has an old key to unlock the gate.
   */
  OPEN_GATE,

  /**
   * To indicate that the actor can travel to another game map.
   */
  TRAVEL,

  /**
   * To indicate that the weapon has a special skill.
   */
  WEAPON_SPECIAL_SKILL,


}
