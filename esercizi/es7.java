//STATE

public class es7{
    public static void main(String args[]){
        LettoreAudio lettoreMP3 = new LettoreAudio();
        lettoreMP3.premiPlayPausa();
        lettoreMP3.premiPlayPausa();
    }
}


interface StatoLettore{ //STATE
    public void gestisciTasto(LettoreAudio lettore);
}



class StatoPausa implements StatoLettore{ // CONCRETE STATE
    public void gestisciTasto(LettoreAudio lettoreAudio){
        System.out.println("Avvio riproduzione brano");
        lettoreAudio.setTasto(new StatoRiproduzione());
    }
}


class StatoRiproduzione implements StatoLettore{
    public void gestisciTasto(LettoreAudio lettoreAudio){
        System.out.println("Sospensione riproduzione brano");
        lettoreAudio.setTasto(new StatoPausa());
    }
}

class LettoreAudio{ // CONTEXT
    private StatoLettore statoCorrente;

    public LettoreAudio(){
        this.statoCorrente = new StatoPausa();
    }

    public void setTasto(StatoLettore nuovoStato){
        this.statoCorrente = nuovoStato; 
    }

    public void premiPlayPausa(){
        statoCorrente.gestisciTasto(this);
    } 
}
