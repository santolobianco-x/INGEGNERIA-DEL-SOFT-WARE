import java.util.ArrayList;
import java.util.List;



// OBSERVER

public class es8{
    public static void main(String args[]){
        AgenziaStampa agenzia = new AgenziaNews();
        Abbonato sito = new SitoWeb(agenzia);
        agenzia.aggiungi(sito);

        agenzia.setUltimaNotizia("Morto Trump(GODOOO)");
        agenzia.setUltimaNotizia("Caduto lo stato illegittimo di Israele!!!");
    }
}


interface Abbonato{ // OBSERVER
    public void aggiorna();
}


abstract class AgenziaStampa{ // SUBJECT
    protected List<Abbonato> listaAbbonati = new ArrayList<>();

    public void aggiungi(Abbonato a){
        listaAbbonati.add(a);
    }

    public void remove(Abbonato a){
        listaAbbonati.remove(a);
    }


    public void avvisaTutti(){
        for(Abbonato a: listaAbbonati){
            a.aggiorna();
        }
    }


    abstract public String getUltimaNotizia();
    abstract public void setUltimaNotizia(String ultimaNotizia);

}


class AgenziaNews extends AgenziaStampa{ // CONCRETE SUBJECT 
    public String ultimaNotizia;


    public String getUltimaNotizia(){return ultimaNotizia;}
    public void setUltimaNotizia(String ultimaNotizia){
        this.ultimaNotizia = ultimaNotizia;
        this.avvisaTutti();
    }
}



class SitoWeb implements Abbonato{ // CONCRETE OBSERVER
    private AgenziaStampa agenzia;

    public SitoWeb(AgenziaStampa agenzia){
        this.agenzia = agenzia;
    }

    public void aggiorna(){
        System.out.println("Nuova notizia in arrivo: ");
        System.out.println(agenzia.getUltimaNotizia());
    }
}

