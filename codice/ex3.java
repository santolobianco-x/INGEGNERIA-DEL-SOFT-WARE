//VERSIONE DI ex2.java SWITCHANDO L'APPROCCIO
//      SPAGHETT_CODE -> QUERY&COMAND
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ex3{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);


        System.out.println("INSERISCI IL NOME DEL FILE");
        String nomefile = input.nextLine();
        CalcolaImporti ci = new CalcolaImporti(nomefile);
        System.out.println("IMPORTI LETTI: "+ ci.getImportiLetti());
        System.out.println("IMPORTI VALIDI: "+ ci.getImportiValidi());
        System.out.println("MASSIMO: "+ ci.searchmax());
        System.out.println("TOTALE: "+ ci.calculate());
        input.close();
        
    }
}



class CalcolaImporti{
    private final List<String> importiLetti = new ArrayList<>();
    private final List<String> importiValidi = new ArrayList<>();
    private final List<Float> valori = new ArrayList<>();

    public CalcolaImporti(final String n){
        preprocessing(n);
    }

    public void preprocessing(final String n){
        this.readfile(n);
        this.removedupl();
        this.converti();
    }

    private void readfile(final String n){
        importiLetti.clear();
        try(BufferedReader f = new BufferedReader(new FileReader((new File(n))))){
            String riga;
            while ((riga = f.readLine()) != null) {
                importiLetti.add(riga);
            }
            f.close();
        }catch( IOException e){
            System.err.println("ERRORE DI I/O: "+ e.getMessage());
        }
    }

    private void removedupl(){
        importiValidi.clear();
        for(String s: importiLetti){
            if(!importiLetti.contains(s)){
                importiValidi.add(s);
            }
        }
    }

    private void converti(){
        valori.clear();
        for(String s: importiValidi){
            try{
                valori.add(Float.parseFloat(s));
            }catch(NumberFormatException e){
                System.err.println("ERRORE DI FORMATTAZIONE NELLA RIGA "+s);
            }
        }
    }

    public float calculate(){
        float totale = 0;
        for(float v : valori) totale+=v;
        return totale;
    }

    public float searchmax(){
        float massimo = valori.get(0);
        for(float v: valori){
            if(massimo < v)
                massimo = v;
        }
        return massimo;
    }

    
    public List<String> getImportiLetti() {
        return importiLetti;
    }
    public List<String> getImportiValidi() {
        return importiValidi;
    }

    public List<Float> getValori() {
        return valori;
    }
}