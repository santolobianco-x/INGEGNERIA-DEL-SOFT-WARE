// COMMAND --> trasforma una richiesta in un oggetto



public class es3{
    public static void main(String args[]){
        SistemaAllarme sistemaAllarme = new SistemaAllarme();
        Comando attiva = new Attiva(sistemaAllarme);
        Comando disattiva = new Disattiva(sistemaAllarme);


        Telecomando telecomando = new Telecomando(attiva);
        telecomando.premiPulsante();

        telecomando.setComando(disattiva);
        telecomando.premiPulsante();

        
    }
}



interface Comando{
    public void esegui();
}


class SistemaAllarme{
    public void attiva(){
        System.out.println("Allarme di casa ATTIVATO");
    }
    public void disattiva(){
        System.out.println("Allarme di casa DISATTIVATO");
    }
}


class Telecomando{
    private Comando comandoSalvato;
    
    public Telecomando(Comando c){
        this.comandoSalvato = c;
    }


    public void setComando(Comando c){
        this.comandoSalvato = c;
    }
    public void premiPulsante(){
        if(comandoSalvato != null){
            comandoSalvato.esegui();
        }else{
            System.out.println("Nessun comando associato");
        }
    }
}


class Attiva implements Comando{
    private SistemaAllarme sistemaAllarme;

    public Attiva(SistemaAllarme sa){
        this.sistemaAllarme = sa;
    }
    
    public void esegui(){
        sistemaAllarme.attiva();
    }
}


class Disattiva implements Comando{
    private SistemaAllarme sistemaAllarme;

    public Disattiva(SistemaAllarme sa){
        this.sistemaAllarme = sa;
    }
    
    public void esegui(){
        sistemaAllarme.disattiva();
    }
}