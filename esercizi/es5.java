
// BRIDGE
public class es5{
    public static void main(String args[]){
        PiattaformaInvio SMS = new InvioSMS();
        PiattaformaInvio mail = new InvioMail();

        Messaggio spam = new MessaggioSpam(mail);
        Messaggio normale = new MessaggioNormale(mail);
        Messaggio urgente = new MessaggioUrgente(SMS);

        spam.invia("Acquista crypto");
        normale.invia("Ciao Pino, come stai?");
        urgente.invia("Ciao bello, il padre di GM sta morendo!!");
    }
}




interface PiattaformaInvio{
    public void inoltra(String testo);
}

abstract class Messaggio{
    protected PiattaformaInvio piattaforma;

    public Messaggio(PiattaformaInvio piattaforma){
        this.piattaforma = piattaforma;
    }
    public abstract void invia(String testo);
}

class MessaggioUrgente extends Messaggio{

    public MessaggioUrgente(PiattaformaInvio piattaforma){
        super(piattaforma);
    }

    public void invia(String testo){
        piattaforma.inoltra("[URGENTE] " +testo);
    }
}


class MessaggioNormale extends Messaggio{
    public MessaggioNormale(PiattaformaInvio piattaforma){
        super(piattaforma);
    }

    public void invia(String testo){
        piattaforma.inoltra("[NORMALE] " + testo);
    }
}


class MessaggioSpam extends Messaggio{
    public MessaggioSpam(PiattaformaInvio piattaforma){
        super(piattaforma);
    }

    public void invia(String testo){
        piattaforma.inoltra("[SPAM] " + testo);
    }
}



class InvioSMS implements PiattaformaInvio{
    public void inoltra(String testo){
        System.out.println("Invio del SMS: " + testo);
    }
}


class InvioMail implements PiattaformaInvio{
    public void inoltra(String testo){
        System.out.println("Invio della mail: " + testo);
    }
}