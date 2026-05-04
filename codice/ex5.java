//APPLICARE L'ESTRAZIONE DEI METODI E LA SOSTITUZIONE DELLE VARIABILI TEMPORANEE CON METODI QUERY
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class ex5 {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        Pagamenti payments = new Pagamenti(s);

        //METODI GREZZI
        payments.readin_convert();
        payments.getSummary();

        //METODI REFATTORIZZATI
        payments.readinr();
        payments.getSummaryr();
    }
}



class Pagamenti{
    final List <String> str = new ArrayList<>();
    final List <Integer> pgms = new ArrayList<>();
    Scanner s;

    public Pagamenti(Scanner scan){
        s = scan;
    }

    public void readin_convert(){ //POSSIAMO DIVIDERE IL METODO E SEMPLIFICARE LA LETTURA
        str.clear();
        pgms.clear();

        String currentline;
        System.out.println("Inserisci pagamenti o digita \'exit\' per uscire");


        while(!((currentline = s.nextLine()).equals("exit"))){ //ESEGUE LETTURA DA STDIN
            str.add(currentline);
        }

        for(String st : str){ //ESEGUE LA CONVERSIONE 
            try{
                pgms.add(Integer.parseInt(st));
            }catch(NumberFormatException e){
                System.err.println("Errore durante la conversione della riga: "+st);
            }
        }
    }

    public void readinr(){
        readstdin();
        convert();
    }


    private void readstdin(){
        str.clear();
        String curLinee;
        System.out.println(
            "Inserisci pagamenti o digita \'exit\' per uscire"
        );
        while(!((curLinee = s.nextLine()).equals("exit"))){
            str.add(curLinee);
        }
    }
    

    private void convert(){
        pgms.clear();
        for(String st : str){
            try{
                pgms.add(Integer.parseInt(st));
            }catch(NumberFormatException e){
                System.err.println(
                    "Errore durante la conversione della riga: "
                    + st
                );
            }
        }
    }

    public void getSummary(){ //POSSIAMO DIVIDERE E SEMPLIFICARE LA LETTURA DEL METODO
        int sm = 0; 
        float avg = 0;
        for(int value: pgms)sm+=value;
        System.out.println("La somma dei pagamenti è uguale a: "+ sm);
        if(pgms.size() == 0){
            avg = 0; 
        }else{
            avg = sm / pgms.size();
        }
        System.out.println("La media dei pagamenti è ugale a: " + avg);
    }


    
    public void getSummaryr(){
        System.out.println("La somma dei pagamenti è uguale a: "+ this.sum());
        System.out.println("La media dei pagamenti è ugale a: " + this.avarage());
    }

    private int sum(){
        int sum = 0;
        for(int value: pgms)sum += value;
        return sum;
    }


    private float avarage(){
        if(pgms.size() == 0)return 0;
        else return this.sum() / pgms.size();
    }
}

