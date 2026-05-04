import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ex2{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);


        System.out.println("INSERISCI IL NOME DEL FILE");
        String nomefile = input.nextLine();
        CalcolaImporti ci = new CalcolaImporti();


        ci.calcola(nomefile);
        
        System.out.println("IMPORTI:"+ ci.getImporti());

        System.out.println("TOTALE: "+ci.getTotale());
        input.close();
        
    }
}



class CalcolaImporti{
    private final List<String> importi = new ArrayList<>();
    private float totale, massimo;

    //ESEMPIO DI SPAGHETTI CODE
    public float calcola(final String n){
        importi.clear();
        try(BufferedReader f = new BufferedReader(new FileReader(new File(n)))){
            totale = 0;
            massimo = 0;
            String riga;
            while((riga = f.readLine()) != null){
                if(!importi.contains(riga)){
                    importi.add(riga);
                    try{
                        Float valore = Float.parseFloat(riga);

                        totale += valore;
                        if(valore > massimo){
                            massimo = valore;
                        }
                    }catch(NumberFormatException e){
                        System.err.println("ERRORE DI FORMATTAZIONE NELLA RIGA " +riga);
                    }
                }
            }
            f.close();
        } catch(IOException e){
            System.err.println("Errore di I/O: " +e.getMessage());
        }
        return totale;
    }

    public List<String> getImporti() {
        return importi;
    }
    public float getTotale() {
        return totale;
    }
    public float getMassimo() {
        return massimo;
    }

}