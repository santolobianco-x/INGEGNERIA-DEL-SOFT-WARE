//INTERFACCE, CLASSI ASTRATTE, EREDITARIETA' E SOVRACCARICAMENTO DEI METODI

public class ex7 {
    public static void main(String[] args) {
        Auto nissan = new Auto("juke", 180, "nissan");
        nissan.stampaInfo();
        nissan.muovi(80);
        Bicicletta bmx = new Bicicletta("bmx", 7, 15);
        bmx.stampaInfo();
        bmx.muovi(60);
    }
}


interface Movible{
    void muovi(int distanza);
}


abstract class Veicolo implements Movible{
    String modello;
    int velocitaMax;

    public Veicolo(String m, int v){
        modello = m;
        velocitaMax = v;
    }

    public void stampaInfo(){
        System.out.println("MODELLO DEL VEICOLO: " + modello);
        System.out.println("VELOCITA' MASSIMA: " + velocitaMax);
    }


    abstract public void muovi(int distanza);
}


class Auto extends Veicolo{
    String marca;
    public Auto(String m, int v, String ma){
        super(m, v);
        marca = ma;
    }


    public void stampaInfo(){
        System.out.println("MODELLO DELLA MACCHINA: " + modello);
        System.out.println("MARCA DELLA MACCHINA: " +marca);
        System.out.println("VELOCITA' MASSIMA(KM/H): " + velocitaMax);
    }
    
    public void muovi(int distanza){
        if(velocitaMax <= 0){
            return;
        }
        for(int i = 1; i <= distanza; i++){
            System.out.println("km raggiunti: " + i + " km da fare: " + (distanza-i));
            try{
                Thread.sleep(100000/velocitaMax);
            }catch(InterruptedException e){
            }
        }
    }
}


class Bicicletta extends Veicolo{
    int ruota;
    public Bicicletta(String m, int v, int r){
        super(m, v);
        ruota = r;
    }


    public void stampaInfo(){
        System.out.println("MODELLO DELLA BICICLETTA: " + modello);
        System.out.println("GRANDEZZA RUOTA: " +ruota);
        System.out.println("VELOCITA' MASSIMA(PEDALATE/SECONDI): " + velocitaMax);
    }
    
    public void muovi(int distanza){
        if(velocitaMax <= 0){
            return;
        }
        for(int i = 1; i <= distanza; i++){
            System.out.println("N. pedalate: "+ i);
            try{
                Thread.sleep(1000/velocitaMax);
            }catch(InterruptedException e ){
            }
        }
    }
}
