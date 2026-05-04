// DESIGN PATTERN SINGLETON -> UNICA INSTANZA DI UNA CLASSE UN SOLO PUNTO DI ACCESSO
public class ex9{
    public static void main(String args[]){
        Logger lg = Logger.getInstance(); // LAVORIAMO CON L'UNICA INSTANZA
        lg.log("PRIMO MESSAGGIO");

        Logger lg2 = Logger.getInstance();
        lg2.log("SECONDO MESSAGGIO");
        
    }
}

class Logger{
    private static Logger lgr = new Logger(); // SI RICHIAMA IL COSTRUTTORE PRIVATO 
    //E SI CREA UN'ISTANZA PRIVATA E STATICA(DURA PER TUTTO IL CICLO DI VITA DEL PROGRAMMA
    //ED È LEGATA ALLA CLASSE E NON AL SINGOLO OGGETTO)

    private Logger(){ //COSTRUTTORE PRIVATO -> PUO' ESSERE RICHIAMATO SOLO ALL'INTERNO DELLA CLASSE STESSA
        System.out.println("Logger creato");
    }

    public static Logger getInstance(){ //PUNTO DI ACCESSO GLOBALE CHE RITORNA L'UNICA INSTANZA CREATA
        return lgr;
    }

    public void log(String Message){
        System.out.println("LOG: " + Message);
    }
}