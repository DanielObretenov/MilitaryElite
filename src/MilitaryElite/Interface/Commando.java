package MilitaryElite.Interface;

import MilitaryElite.Enums.State;
import MilitaryElite.entities.Mission;

import java.util.Collection;

public interface Commando {

    void addMission(Mission mission);
    Collection<Mission> getMissions();

}
