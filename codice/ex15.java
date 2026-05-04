// Il design pattern Adapter permette di far interagire il client con una classe esistente 
// (Adaptee) che ha un'interfaccia diversa da quella attesa (Target), 
// traducendo le chiamate tramite un Adapter senza modificare né il client né la classe esistente.
public class ex15{
    public static void main(String args[]){

        ILogger l = new Logger();
        l.logInfo("APERTO CORRETTAMENTE IL FILE");
        l.logError("IL FILE NON E' DI TIPO ISBLK");

        ILogger l2 = new Logger2();
        l2.logInfo("APERTA CARTELLA");
        l2.logError("ERRORE DURANTE L'ESECUZIONE DEL PROCESSO");
    }
}


// INTERFACCIA -> FUNZIONI UTILIZZATE DAL CLIENT
interface ILogger{
    public void logInfo(String message);
    public void logError(String message);
}


// ADAPTEE -> CLASSE DA CONVERTIRE

class LegacyLogger{
    public void write(String l, String m){
        System.out.println("[ "+ l +" ] " + m);
    }
}

// OBJECT ADAPTER -> SI UTILIZZA UN RIFERIMENTO DELL'ADAPTEE
class Logger implements ILogger{
    private LegacyLogger ll; 


    public Logger(){
        ll = new LegacyLogger();
    }

    public void logInfo(String message){
        ll.write("INFO", message);
    }

    public void logError(String message){
        ll.write("ERROR", message);
    }
}



// CLASS ADAPTER -> LA CLASSE ADAPTER È SOTTOCLASSE DELLA CLASSE ADAPTEE
class Logger2  extends LegacyLogger implements ILogger {
    public Logger2(){
    }

    public void logInfo(String message){
        this.write("INFO",message);
    }

    public void logError(String message){
        this.write("ERROR",message);
    }
}