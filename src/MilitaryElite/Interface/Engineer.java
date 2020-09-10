package MilitaryElite.Interface;
import MilitaryElite.entities.Repair;

import java.util.Collection;
import java.util.Collections;

public interface Engineer {
    void addRepair(Repair repair);
    Collection<Repair> getRepair();
}
