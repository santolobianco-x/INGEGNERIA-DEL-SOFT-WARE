// CHAIN OF RESPONSIBILITY
public class es9{
    public static void main(String args[]){
        GestoreSpedizioni drone = new Drone();
        GestoreSpedizioni furgone = new Furgone();
        GestoreSpedizioni camion = new Camion();

        drone.impostaProssimo(furgone);
        furgone.impostaProssimo(camion);

        drone.smistaPacco(30);
        drone.smistaPacco(4);
        drone.smistaPacco(1000);
    }
}


abstract class GestoreSpedizioni{

    protected GestoreSpedizioni prossimo;

    public void impostaProssimo(GestoreSpedizioni g){
        this.prossimo = g;
    }

    public abstract void smistaPacco(int peso);
}


class Drone extends GestoreSpedizioni{
    public void smistaPacco(int peso){
        if(peso <= 5){
            System.out.println("Pacco consegnato via drone!");
            System.out.println("Peso: " + peso + " kg");
        }else if(prossimo != null){
            prossimo.smistaPacco(peso);
        }
    }
}


class Furgone extends GestoreSpedizioni{
    public void smistaPacco(int peso){
        if(peso <= 50){
            System.out.println("Pacco consegnato via furgone!");
            System.out.println("Peso: " + peso + " kg");
        }else if(prossimo != null){
            prossimo.smistaPacco(peso);
        }
    }
}


class Camion extends GestoreSpedizioni{
    public void smistaPacco(int peso){
        System.out.println("Pacco pesante consegnato via Camion!");
        System.out.println("Peso: " + peso + " kg");
    }
}