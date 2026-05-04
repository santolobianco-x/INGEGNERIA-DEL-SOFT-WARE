//DESIGN PATTERN MEDIATOR --> (comportamentale) permette di utilizzare una classe che sostituisce
//                        --> la comunicazione tra oggetti. Evita di far interagire direttamente
//                        --> gli oggetti, --> accoppiamento lasco. 
public class ex29{
    public static void main(String args[]){
        ControlTower tower = new ControlTower();

        Airplane a1 = new PassengerPlane(tower, "Flight-A");
        Airplane a2 = new PassengerPlane(tower, "Flight-B");

        a1.requestLanding();
        a2.requestLanding();
        tower.freeeRunway();
        a2.requestLanding();
    }
}

interface Mediator{ // MEDIATOR
    void requestLanding(Airplane plane);
}


abstract class Airplane{ // COLLEAGUE
    protected Mediator mediator;
    protected String name;

    public Airplane(Mediator m, String n){
        mediator = m;
        name = n;
    }

    public String getName(){
        return name;
    }
    
    public void requestLanding(){
        mediator.requestLanding(this);
    }
}



class ControlTower implements Mediator{ // CONCRETE MEDIATOR
    private boolean runwayBusy = false;

    public void requestLanding(Airplane plane){
        if(!runwayBusy){
            runwayBusy = true;

            System.out.println(plane.getName() + " autorizzato ad atterrare");
        } else{
            System.out.println(plane.getName() + " deve attendere");
        }
    }

    public void freeeRunway(){
        runwayBusy = false;
        System.out.println("Pista libera");
    }
}


class PassengerPlane extends Airplane { // CONCRETE COLLEAGUE
    public PassengerPlane(Mediator m, String n){
        super(m, n);
    }
}