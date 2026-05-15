//ADAPTER
public class es10{
    public static void main(String args[]){
        VecchioGestoreTransazioni gestore = new VecchioGestoreTransazioni();
        SistemaPagamento sistema = new ModuloIntegrazione(gestore);
        sistema.paga(50);
        sistema.paga(1000);
        sistema.paga(1500);

    }
}


interface SistemaPagamento{ // TARGET 
    public void paga(int cifra);
}


class VecchioGestoreTransazioni{ // ADAPTEE
    public void inviaDenaro(Float importo, String valuta){
        System.out.println("Transazione elaborata dal vecchio sistema: "+ importo + " " + valuta);
    }
}


class ModuloIntegrazione implements SistemaPagamento{ // CONCRETE ADAPTER
    private VecchioGestoreTransazioni gestore;
    public ModuloIntegrazione(VecchioGestoreTransazioni gestore){
        this.gestore = gestore;
    }

    public void paga(int cifra){
        float importo = (float) cifra;
        gestore.inviaDenaro(importo, "EUR");
    }
}



class ModuloIntegrazioneTwoWay extends VecchioGestoreTransazioni implements SistemaPagamento { // ADAPTER A DUE VIE(soddisfa due condizioni:)
                                                                                                                        // * può essere visto come target
                                                                                                                        // * può essere trattato come classe originale
    public ModuloIntegrazioneTwoWay(){
        super();
    }
    public void paga(int cifra){
        float importo = (float)cifra;
        this.inviaDenaro(importo, "EUR");  
    }
}