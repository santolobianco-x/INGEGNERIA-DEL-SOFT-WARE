import java.util.ArrayList;
import java.util.List;
// OBJECT POOL -> SI IMPLEMENTA MEDIANTE FACTORY METHOD, SINGLETON E DEPENDENCY INJECTION



public class ex12{
    public static void main(String args[]){
        Connessione prototype = new ConnessioneTCP(); // PROTOTIPO PER DEPENDENCY INJECTION
        Pool poolconnessioni = PoolConnessioni.getInstance(prototype); 

        Connessione c1 = poolconnessioni.getConnessione();
        Connessione c2 = poolconnessioni.getConnessione();
        c1.usa();
        c2.usa();
        poolconnessioni.releaseConnessione(c1);
        poolconnessioni.releaseConnessione(c2);
    }
}



interface Connessione{ // PRODUCT
    public void usa();
}

class ConnessioneTCP implements Connessione{ // CONCRETE PRODUCT
    public ConnessioneTCP(){}
    public void usa(){
        System.out.println("Connesione TCP stabilita");
    }
}



abstract class Pool{ // CREATOR
    abstract public Connessione getConnessione();
    abstract public void releaseConnessione(Connessione c);
}


class PoolConnessioni extends Pool{ // CONCRETE CREATOR implementato mediante SINGLETON
    private static PoolConnessioni instance;
    private List<Connessione> connessioni;
    private Connessione prototype;

    private PoolConnessioni(Connessione proto){
        System.out.println("Pool Connessioni creato");
        connessioni = new ArrayList<>();
        this.prototype = proto;
    }


    public static PoolConnessioni getInstance(Connessione proto){
        if(instance == null){
            instance = new PoolConnessioni(proto);
        }
        return instance;
    }

    public Connessione getConnessione(){ // FACTORY METHOD
        if(connessioni.size() == 0){
            try{
                connessioni.add(
                    this.prototype.getClass()
                    .getDeclaredConstructor()
                    .newInstance()
                );
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return connessioni.remove(connessioni.size()-1);
    }
    public void releaseConnessione(Connessione c){ // metodo di reinserimento nella lista
        connessioni.add(c);
    }
    
}
