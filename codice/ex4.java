//TESTING SULLE FUNZIONI
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ex4{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        Calcolatrice calc = new Calcolatrice(input);
        System.out.println("TESTING...");
        calc.testSomma();
        calc.testMoltiplicazione();
        System.out.println("RISULTATO SOMMA: " + calc.somma());
        System.out.println("RISULTATO MOLTIPLICAZIONE:" + calc.moltiplicazione());



    }
}



class Calcolatrice{
    final List<String> str = new ArrayList<>();
    final List<Integer> values = new ArrayList<>();
    Scanner s;


    public  Calcolatrice(Scanner s){
        this.s = s;
    }


    private void initList(){
        values.clear();
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(5);
    }


    public void testSomma(){
        this.initList();
        int sum = 0; 
        for(int v: values) sum+=v;
        if(sum == 15)
            System.out.println("OK Metodo somma funzionante");
        else
            System.err.print("ERRORE Metodo somma non funzionante");
    }

    public int somma(){
        System.out.println("SOMMA");
        this.readStandardIn();
        int sum = 0;
        for(int v: values) sum += v;
        return sum;
    }

    public void testMoltiplicazione(){
        this.initList();
        int mul = 1; 
        for(int v: values) mul*=v;
        if(mul == 120)
            System.out.println("OK Metodo moltiplicazione funzionante");
        else
            System.err.println("ERRORE Metodo moltiplicazione non funzionante");
    }

    public int moltiplicazione(){
        System.out.println("MOLTIPLICAZIONE");
        this.readStandardIn();
        int mul = 1; 
        for(int v: values) mul *= v;
        return mul;
    }


    private void readStandardIn(){
        this.read();
        this.convert();
    }

    private void read(){
        str.clear();
        String riga;
        System.out.println("Inserisci numeri o digita \'exit\' per uscire");
        while(true){
            if((riga = s.nextLine()).equals("exit")){
                break;
            }
            str.add(riga);
        }
    }

    private void convert(){
        values.clear();
        for(String st: str){
            try{
                values.add(Integer.parseInt(st));
            }catch(NumberFormatException e){
                System.err.println("ERRORE DURANTE LA CONVERSIONE DELLA RIGA: "+st);
            }
        }
    }
    
}