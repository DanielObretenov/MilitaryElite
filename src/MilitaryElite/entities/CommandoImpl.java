package MilitaryElite.entities;

import MilitaryElite.Enums.Corp;
import MilitaryElite.Enums.State;
import MilitaryElite.Interface.Commando;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private List<Mission> missions;
    public CommandoImpl(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary, corp);
        this.missions = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public List<Mission> getMissions() {
        return Collections.unmodifiableList(this.missions);
    }

    //Missions:
    //  Code Name: Freedom State: inProgress
    @Override
    public String toString() {
        return super.toString() + "\r\n" + "Missions:";
    }
}
