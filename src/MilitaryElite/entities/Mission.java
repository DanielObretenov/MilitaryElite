package MilitaryElite.entities;

import MilitaryElite.Enums.State;

public class Mission {
    private String codeName;
    private State state;
    public Mission(String codeName, String state){
        this.codeName = codeName;
        setState(state);
    }

    public String getCodeName() {
        return codeName;
    }

    public State getState() {
        return state;
    }

    public void setState(String state) {
        try {
            this.state = State.valueOf(state);
        }catch (Exception e){
            throw new IllegalArgumentException("Not a valid state");
        }
    }

    public void completeMission(){
        this.state = State.finished;
    }

    @Override
    public String toString() {
        return String.format("  Code Name: %s State: %s",codeName,state);
    }
}
