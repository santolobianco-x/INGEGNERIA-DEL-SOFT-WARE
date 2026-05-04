//LA CLASSE CHE HA AL SUO INTERNO IL METODO main CON LA FIRMA CHE È RIPORTATA SOTTO
//LA CLASSE CHE CONTIENE IL MAIN DOVRA' AVERE IL NOME DEL FILE
public class ex1{
    public static void main(String arg[]){
        Rettangolo r = new Rettangolo(5, 6);
        r.stampa();
        
    }
}


class Rettangolo{
    private int altezza;
    private int base;


    public Rettangolo(int a, int b){
        this.altezza = a;
        this.base = b;
    }
    
    public int getArea(){
        return base*altezza;
    }

    public int getPerimetro(){
        return 2*(altezza+base);
    }

    public void stampa(){
        System.out.println("Base: "+ this.base);
        System.out.println("Altezza: "+ this.altezza);
        System.out.println("Perimetro: "+this.getPerimetro());
        System.out.println("Area: "+this.getArea());
    }
}