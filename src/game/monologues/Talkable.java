package game.monologues;

import edu.monash.fit2099.engine.actors.Actor;
import java.util.ArrayList;

public interface Talkable {
    final ArrayList<String> monologueOptions = new ArrayList<>();

    void addMonologueOptions(Actor listener);

    String chooseOption();
}
