package MilitaryElite.entities;

import MilitaryElite.Interface.Engineer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {

    private List<Repair> repairs;
    public EngineerImpl(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary, corp);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public List<Repair> getRepair() {
        return Collections.unmodifiableList(this.repairs);
    }

    @Override
    public String toString() {
        return super.toString() + "\r\n" + "Repairs:";
    }
}
