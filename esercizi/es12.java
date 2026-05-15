//  COMPOSITE
import java.util.ArrayList;
import java.util.List;

public class es12{
    public static void main(String args[]){
        UnitaOrganizzativa root = new UnitaOrganizzativa(null, "APPLE");
        UnitaOrganizzativa dipendenti = new UnitaOrganizzativa(root, "PROGRAMMATORI");


        Sviluppatore io = new Sviluppatore("SANTO LO BIANCO", 100);
        Sviluppatore giorgio = new Sviluppatore("GIORGIO ANZALONE", 1000);
        Sviluppatore matteo = new Sviluppatore("MATTEO FAILLA", 1000);

        root.add(dipendenti);
        root.add(io);
        dipendenti.add(giorgio);
        dipendenti.add(matteo);

        System.out.println("Soldi spesi per l'unità " + dipendenti.getNome() +" : " + dipendenti.calcolaCosto());
        System.out.println("Soldi spesi in totale: "+ root.calcolaCosto());
    }
}



interface RisorsaAziendale{
    public String getNome();
    public int calcolaCosto();
}


class Sviluppatore implements RisorsaAziendale{

    private String nome;
    private int stipendio;


    public Sviluppatore(String nome, int stipendio){
        this.nome = nome;
        this.stipendio = stipendio;
    }
    public String getNome(){
        return nome;
    }
    public int calcolaCosto(){
        return stipendio;
    }

}



class UnitaOrganizzativa implements RisorsaAziendale{
    private List<RisorsaAziendale> unita;
    private UnitaOrganizzativa father;
    private String nomeUnita;
    private int costoTotale;
    public boolean dirty;

    public UnitaOrganizzativa(UnitaOrganizzativa father, String nomeUnita){
        this.father = father;
        this.nomeUnita = nomeUnita;
        this.costoTotale = 0;
        unita = new ArrayList<>();
    }

    public String getNome(){
        return nomeUnita;
    }

    public int calcolaCosto(){
        if(dirty){
            costoTotale = calcola();
            dirty = false;
        }
        return costoTotale;
    }

    private int calcola(){
        int somma = 0;
        for(RisorsaAziendale s:unita){
            somma += s.calcolaCosto();
        }
        return somma;
    }

    public void add(RisorsaAziendale r){
        boolean added = unita.add(r);
        if(added){
            sporca();
        }
    }

    public void remove(RisorsaAziendale r){
        boolean removed = unita.remove(r);
        if(removed){
            sporca();
        }
    }

    public void sporca(){
        dirty = true;
        if(father != null){
            father.sporca();
        }
    }
}