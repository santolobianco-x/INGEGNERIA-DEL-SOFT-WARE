
//DESIGN PATTERN: TEMPLATE METHOD
// Il Template Method definisce lo scheletro di un algoritmo in un metodo della superclasse, 
// lasciando alle sottoclassi la possibilità di ridefinire alcuni passi senza modificare la struttura complessiva.

public class ex8{
    public static void main(String args[]){
        Document dc = new MyDocument();
        dc.open();
    }
}


abstract class Document {
    public void open() {//template method
        read();              
        print();             
        hook();              
    }
    abstract void read();//metodo primitivo
    void print() {
        System.out.println("Stampo documento");
    }
    void hook() { } //metodo hook
    // ->             definisce un comportamento opzionale
}


class MyDocument extends Document {
    void read() {
        System.out.println("Leggo MyDocument");
    }
    void hook() {
        System.out.println("Operazione aggiuntiva");
    }
}

