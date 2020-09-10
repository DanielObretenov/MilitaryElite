package MilitaryElite.entities;
import MilitaryElite.Interface.LieutenantGeneral;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private List<PrivateImpl> priv;
    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.priv = new ArrayList<>();
    }
    @Override
    public void addPrivate(PrivateImpl priv) {
        this.priv.add(priv);
    }

    @Override
    public String toString() {
        priv = priv.stream().sorted((x,y) -> y.getId() - x.getId()).collect(Collectors.toList());
        String privates = "";
        for (PrivateImpl aPrivate : priv) {
            privates = privates.concat("\r\n" +  "  " + aPrivate.toString());
        }
        return super.toString() + "\r\n" + "Privates:" + privates ;
    }
}
