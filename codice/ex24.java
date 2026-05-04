
//DESIGN PATTERN: BRIDGE
// --> design pattern che separa l'astrazione dalla sua implementazione, permettendo alle due di variare indipendentemente.
public class ex24{
    public static void main(String args[]){
        System.out.println("Telecomando semplice e TV");
        Dispositivo tv = new TV();
        TelecomandoSemplice telesemplice = new TelecomandoSemplice(tv);
        
        telesemplice.accendi();

        telesemplice.aumentaVolume();

        telesemplice.decrementaVolume();

        telesemplice.spegni();

        System.out.println("Telecomando avanzato e Radio");
        Dispositivo radio = new Radio();
        TelecomandoAvanzato teleavanzato = new TelecomandoAvanzato(radio);

        teleavanzato.accendi();

        teleavanzato.muto();

        teleavanzato.spegni();
    }
}



// POTREBBE SORGERE LA DOMANDA: PERCHÈ TV/RADIO SONO GLI IMPLEMENTOR E TELECOMANDO SEMPLICE/AVANZATO SONO REFINED ABSTRACTION?
// TELECOMANDO --> INDICA COSA DEVE FARE
// DISPOSITIVO --> ESEGUE CIO' CHE VIENE INDICATO


interface Dispositivo{ // IMPLEMENTOR
    public void accendi();
    public void spegni();
    public void setVolume(int v);
    public int getVolume();
}


abstract class Telecomando{ // ABSTRACTION
    protected Dispositivo dispositivo;
    public Telecomando(Dispositivo d){
        dispositivo = d;
    }

    public void accendi(){
        dispositivo.accendi();
    }

    public void spegni(){
        dispositivo.spegni();
    }
}



class TV implements Dispositivo{ // CONCRETE IMPLEMENTOR
    public int volume;

    public TV(){
        volume = 50;
    }

    public void accendi(){
        System.out.println("TV accesa");
    }
    public void spegni(){
        System.out.println("TV spenta");
    }

    public void setVolume(int v){
        if(v > 100){
            volume = 100;
        }else if(v < 0){
            volume = 0;
        } else{
            volume = v;
        }
    }


    public int getVolume(){ return volume;}
}


class Radio implements Dispositivo{ // CONCRETE IMPLEMENTOR
    public int volume;
    public Radio(){
        volume = 30;
    }


    public void accendi(){
        System.out.println("Radio accesa");
    }

    public void spegni(){
        System.out.println("Radio spenta");
    }

    public void setVolume(int v){
        if(v > 60){
            volume = 60;
        }else if( v < 0){
            volume = 0;
        }else{
            volume = v;
        }
    }

    public int getVolume(){ return volume;}
}


class TelecomandoSemplice extends Telecomando{ // REFINED ABSTRACTION
    public TelecomandoSemplice(Dispositivo d){
        super(d);
    }

    public void aumentaVolume(){
        int volume = dispositivo.getVolume();
        System.out.println("Volume prima dell'incremento: " + volume);
        dispositivo.setVolume(volume+1);
        System.out.println("Volume dopo l'incremento:     " + dispositivo.getVolume());
    }

    public void decrementaVolume(){
        int volume = dispositivo.getVolume();
        System.out.println("Volume prima del decremento: " + volume);
        dispositivo.setVolume(volume-1);
        System.out.println("Volume dopo il decremento:     " + dispositivo.getVolume());
    }
}


class TelecomandoAvanzato extends Telecomando{ // REFINED ABSTRACTION
    public TelecomandoAvanzato(Dispositivo d){
        super(d);
    }

    public void muto(){
        System.out.println("Volume prima del muto: " + dispositivo.getVolume());
        dispositivo.setVolume(0);
    }

}