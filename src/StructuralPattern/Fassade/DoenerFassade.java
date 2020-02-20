package StructuralPattern.Fassade;

public class DoenerFassade {

    private DoenerKebap doenerkebap;
    private Lamacun lamacun;

    public DoenerFassade(){
        doenerkebap = new DoenerKebap();
        lamacun = new Lamacun();
    }


    public void baueDoenerUndLamacun(){
        doenerkebap.fuelle();
        lamacun.rolle();
    }

}
