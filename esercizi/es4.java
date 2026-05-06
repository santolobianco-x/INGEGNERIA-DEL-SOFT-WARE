import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;



//TEMPLATE METHOD

public class es4{
    public static void main(String args[]){
        ElaboratoreReport report = new ReportVendite();
        report.generaReport();
    }
}



abstract class ElaboratoreReport {

    public final void generaReport() {// template method
        estraiDati();
        formattaDati();
        invia();
    }

    protected abstract void estraiDati();
    protected abstract void formattaDati();

    protected void invia() { // metodo hook --> opzionale
        System.out.println("Il report è stato salvato nell'archivio locale di default.");
    }
}



class ReportVendite extends ElaboratoreReport{
    List<Integer> array;
    List<String> inputs;
    Scanner inputData;


    public ReportVendite(){
        array = new ArrayList<>();
        inputs = new ArrayList<>();
        inputData = new Scanner(System.in);
    }


    protected void estraiDati(){
        System.out.println("Inserire dati del report(per terminare inserire 0)");

        String current = inputData.next();

        while(!current.equals("0")){
            inputs.add(current);
            current = inputData.next();
        }
    }

    protected void formattaDati(){
        for(String s: inputs){
            try{
                array.add(Integer.parseInt(s));
            }catch(NumberFormatException e){
                System.out.println("Input non valido: " + s);
            }
        }
    }

    @Override
    protected void invia(){
        System.out.println("Dati validi in input:");
        for(Integer i: array)
            System.out.println(""+i);
    }

}