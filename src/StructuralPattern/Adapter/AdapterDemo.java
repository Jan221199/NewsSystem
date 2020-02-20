package StructuralPattern.Adapter;

public class AdapterDemo {

    public static void main(String[] args) {
        Service service = new Service();
        AdapterInterface adapterInterface = new Adatper(service);
        adapterInterface.saySomething();
    }
}
