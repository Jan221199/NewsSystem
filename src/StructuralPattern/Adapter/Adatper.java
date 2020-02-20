package StructuralPattern.Adapter;

public class Adatper implements AdapterInterface {

    Service service;

    public Adatper(Service service){
        this.service = service;
    }

    @Override
    public void saySomething() {
        System.out.println("Hellooo!");
        service.saySomethingOther();
    }
}
