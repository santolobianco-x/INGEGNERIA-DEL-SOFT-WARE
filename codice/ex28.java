import java.util.List;
import java.util.Arrays;

// ULTERIORE ESEMPIO DI STATE --> codice prof E. Tramontana
public class ex28{
    public static void main(String args[]){
        Libro l = new Libro();
        l.mostra();
        l.modeColonna();
        l.mostra();
    }
}

interface Display { 
    public void scrivi(List<String> testo);
}


class Libro { 
    private String testo = "Darwin's _Origin of Species_ persuaded the world that the "
        + "difference between different species of animals and plants is not the fixed "
        + "immutable difference that it appears to be.";
    
    private List<String> lista = Arrays.asList(testo.split("[\\s+]+"));
    private Display mode = new Colonna();

    public void mostra() {
        mode.scrivi(lista);
    }

    public void modeColonna() {
        mode = new Colonna();
    }

    public void modeParola() {
        mode = new SingolaParola();
    }
}


class Colonna implements Display {
    private final int numCar = 38;
    private final int numRighe = 12;

    public void scrivi(List<String> testo) {
        int riga = 0;
        int col = 0;
        for (String p : testo) {
            if (col + p.length() > numCar) {
                System.out.println();
                riga++;
                col = 0;
            }
            if (riga == numRighe) break;
            System.out.print(p + " ");
            col += p.length() + 1;
        }
    }
}


class SingolaParola implements Display {
    private int maxLung;

    public void scrivi(List<String> testo) {
        System.out.println();
        trovaMaxLung(testo);
        for (String p : testo) {
            int numSpazi = (maxLung - p.length()) / 2;
            mettiSpazi(numSpazi);
            System.out.print(p);
            if (p.length() % 2 == 1) numSpazi++;
            mettiSpazi(numSpazi);
            aspetta();
            cancellaRiga();
        }
        System.out.println();
    }

    private void mettiSpazi(int n) {
        System.out.print(" ".repeat(n));
    }

    private void cancellaRiga() {
        System.out.print("\b".repeat(maxLung));
    }

    private void trovaMaxLung(List<String> testo) {
        for (String p : testo) if (maxLung < p.length()) maxLung = p.length();
    }

    private static void aspetta() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) { }
    }
}

