package MilitaryElite.entities;

import MilitaryElite.Enums.Corp;
import MilitaryElite.Enums.State;
import MilitaryElite.Interface.SpecialisedSoldier;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corp corp;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary);
        setCorp(corp);
    }

    @Override
    public Corp getCorps() {
        return this.corp;
    }

    public void setCorp(String corp) {
        try {
            this.corp = Corp.valueOf(corp);
        }catch (Exception e){
            throw new IllegalArgumentException("Not a valid Corp");
        }
    }

    @Override
    public String toString() {
        String corps = "Corps: " + this.corp;
        return super.toString() + "\r\n" + corps;
    }
}
