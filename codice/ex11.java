// FACTORY METHOD -> DESIGN PATTERN CHE SEPARA LA CLASSE CHE UTILIZZA UN OGGETTO DALLA CLASSE DOVE LO SI INSTANZIA
public class ex11{
    public static void main(String args[]){
        ServizioNotifiche servMail = new ServizioMail();
        ServizioNotifiche servSMS = new ServizioSMS();


        notifica mail = servMail.creaNotifica();
        notifica sms = servSMS.creaNotifica();
        mail.ricevi("CIAO QUANDO CI VEDIAMO PER LA PRESENTAZIONE DEL PROGETTO?",
                    "angelo1975@icloud.com");
        sms.ricevi("IL SUO ORDINE È STATO RICEVUTO", 
                    "+0933567912");
    }
}


interface notifica{ // ***PRODOTTO*** -> INTERFACCIA O CLASSE ASTRATTA CHE DETERMINA I METODI CHE DEVONO ESSERE IMPLEMENTATI DAI PRODOTTI CONCRETI
    public void ricevi(String message, String mittente);
}


class Email implements notifica{ // ***PRODOTTO CONCRETO*** -> PRODOTTO CHE VERRA' ISTANZIATO
    public void ricevi(String message, String mittente){
        System.out.println("Nuova email da: " + mittente);
        System.out.println(message);
    }
}

class SMS implements notifica{ 
    public void ricevi(String message, String mittente){
        System.out.println("Nuovo SMS da: "+ mittente);
        System.out.println(message);
    }
}



// ***CREATORE*** -> CLASSE ASTRATTA CHE DICHIARA IL ***FACTORY METHOD***
// ***CREATORE CONCRETO*** -> CLASSE CHE IMPLEMENTA IL CREATORE, IMPLEMENTANDO IL ***FACTORY METHOD*** E DECIDENDO QUALE PRODOTTO ISTANZIARE


abstract class ServizioNotifiche{ 
    abstract public notifica creaNotifica();
}

class ServizioMail extends ServizioNotifiche{ 
    public ServizioMail(){}
    public notifica creaNotifica(){
        return new Email();
    }
}

class ServizioSMS extends ServizioNotifiche{
    public ServizioSMS(){}
    public notifica creaNotifica(){
        return new SMS();
    }
}