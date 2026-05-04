//DESIGN PATTERN OBSERVER --> IMPLEMENTATO MEDIANTE LE LIBRERIE STANDARD
import java.util.Observable;
import java.util.Observer;

public class ex26{
    Registro registro = new Registro();
    Monitor monitor = new Monitor();
    public static void main(String args[]){
        ex26 client = new ex26();
        client.test();

    }

    private void test(){
        registro.addObserver(monitor);
        registro.ritira(500);
        registro.deposita(100);
        registro.ritira(50);
        registro.deposita(500);
        System.out.println("Saldo attuale: "+ registro.getBilancio());
        System.out.println("Il subject ha effettuato " + monitor.getNum_operation() + " operazioni");
    }
}


class Monitor implements Observer{
    private int num_operation;

    public Monitor(){
        num_operation = 0;
    }

    public void update(Observable obs, Object s){
        System.out.println("Monitor: il saldo è di euro "+ s);
        num_operation++;
    }

    public int getNum_operation(){return num_operation;}
}

class Registro extends Observable{
    private double bilancio;
    public Registro(){
        bilancio = 0;
    }


    public boolean ritira(double somma){
        System.out.println("Prelievo di somma "+ somma);
        if(bilancio >= somma){
            bilancio -= somma;
            setChanged(); // se non viene richiamato setChanged non può essere notificato il cambio di stato
            notifyObservers(bilancio);
            return true;
        }
        System.out.println("Operazione non permessa");
        return false;
    }

    public void deposita(double somma){
        System.out.println("Deposito di somma "+ somma);
        bilancio += somma;
        setChanged();
        notifyObservers(bilancio);
    }

    public double getBilancio(){return bilancio;}
}

