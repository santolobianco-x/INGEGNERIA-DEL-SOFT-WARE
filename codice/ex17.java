import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

// FACADE-> IL DESIGN PATTERN FACADE SERVE PER SEPARARE IL CLIENT DALLE CLASSI UTILIZZATE E PER RENDERE
// PIU' SEMPLICE L'UTILIZZO DELLE CLASSI STESSE.
// LA CLASSE FACADE(IN QUESTO CASO REGISTRO) SI OCCUPERA' DI RENDERE PIU' SEMPLICE L'UTILIZZO DEGLI OGGETTI
// IMPEGNANDOSI A EFFETTUARE I RICHIAMI 
//CLIENT
public class ex17 {

    public static void main(String[] args) {

        Registro registro = new Registro();   // Facade
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\n===== SISTEMA BIBLIOTECA =====");
            System.out.println("1. Registra Socio");
            System.out.println("2. Registra Libro");
            System.out.println("3. Aggiungi socio in BlockList");
            System.out.println("4. Prestito Libro");
            System.out.println("5. Restituzione Libro");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");

            int scelta = Integer.parseInt(scanner.nextLine());

            switch (scelta) {
                case 1:
                    registro.registerSocio();
                    break;

                case 2:
                    registro.registerBook();
                    break;

                case 3:
                    registro.registerCattivoSocio();
                    break;

                case 4:
                    if (registro.lendLibro()) {
                        System.out.println("Prestito completato con successo.");
                    } else {
                        System.out.println("Prestito fallito.");
                    }
                    break;

                case 5:
                    registro.returnLibro();
                    break;

                case 0:
                    running = false;
                    System.out.println("Uscita dal sistema...");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }
        }

        scanner.close();
    }
}


//CLASSE FACADE
class Registro{
    private Libri libri;
    private Soci soci;
    private BlockList blockList;
    private Prestiti prestiti;


    public Registro(){
        libri = new Libri();
        soci = new Soci();
        blockList = new BlockList();
        prestiti = new Prestiti();
    }

    public boolean lendLibro(){
        Socio socio = soci.fetchSocio();
        if(!soci.verify(socio)){
            System.out.println("Socio non trovato");
            return false;
        }

        if(!blockList.accepted(socio)){
            System.out.println("Socio è presente nella BlockList");
            return false;
        }

        Libro libro = libri.fetchLibro();
        if(!libri.isFree(libro)){
            System.out.println("Il libro non è libero o non è presente nel catalogo");
            return false;
        }

        if(!prestiti.register(socio, libro)){
            return false;
        }

        libri.removeLibro(libro);
        
        return true;
    }
    
    public void returnLibro(){
        Libro libro = libri.fetchLibro();
        prestiti.returnBook(libro);
        libri.insertLibro(libro);
    }

    public void registerSocio(){
        Socio socio = soci.fetchSocio();
        soci.insertSocio(socio);
    }

    public void registerCattivoSocio(){
        Socio socio = blockList.fetchSocio();
        blockList.insertSocio(socio);
    }

    public void registerBook(){
        Libro libro = libri.fetchLibro();
        libri.insertLibro(libro);
    }
    
}



class Socio{
    public String nome;
    public String cognome;
    public Socio(String n, String c){
        nome = n;
        cognome = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;       
        if (o == null) return false;      
        if (getClass() != o.getClass()) return false;

        Socio socio = (Socio) o;          

        return nome.equals(socio.nome) && cognome.equals(socio.cognome);
    }
    @Override
    public int hashCode(){
        return java.util.Objects.hash(nome,cognome);
    }
}


class Libro{
    public String titolo;
    public String autore;

    public Libro(String t, String a){
        titolo = t;
        autore = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;       
        if (o == null) return false;      
        if (getClass() != o.getClass()) return false;

        Libro libro = (Libro) o;          

        return titolo.equals(libro.titolo) && autore.equals(libro.autore);
    }

    @Override
    public int hashCode(){
        return java.util.Objects.hash(titolo,autore);
    }
}

class ListaSoci{
    public List<Socio> soci;
    public Scanner scanner;
    public ListaSoci(){
        soci = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public Socio fetchSocio(){
        System.out.println("Inserisci nome socio: ");
        String nome = scanner.nextLine();
        System.out.println("Inserisci cognome socio: ");
        String cognome = scanner.nextLine();
        return new Socio(nome, cognome);
    }


    public void insertSocio(Socio toInsert){
        if(soci.contains(toInsert)){
            System.out.println("Il socio è già stato registrato precedentemente");
        }else{
            soci.add(toInsert);
            System.out.println("Registrazione avvenuta con successo");
        }
    }

    public void removeSocio(Socio toRemove){
        if(soci.remove(toRemove)){
            System.out.println("Socio rimosso con successo");
        }else{
            System.out.println("Socio non trovato");
        }
    }

}


class Libri{
    public List<Libro> libri;
    public Scanner scanner;
    public Libri(){
        libri = new ArrayList<>();
        scanner = new Scanner(System.in);
    }


    public Libro fetchLibro(){
        System.out.println("Inserisci titolo libro: ");
        String titolo = scanner.nextLine();
        System.out.println("Inserisci autore libro: ");
        String autore = scanner.nextLine();
        return new Libro(titolo, autore);
    }


    public void insertLibro(Libro toInsert){
        libri.add(toInsert);
    }


    public void removeLibro(Libro toRemove){
        libri.remove(toRemove);
    }
    
    public boolean isFree(Libro libro){
        return libri.contains(libro);
    } 
}


class Soci extends ListaSoci{
    public Soci(){
        super();
    }

    public boolean verify(Socio toResearch){
        return soci.contains(toResearch);
    }
}

class BlockList extends ListaSoci{
    public BlockList(){
        super();
    }

    public boolean accepted(Socio toResearch){
        return !soci.contains(toResearch);
    }
}


class Prestiti{
    public Map<Libro, Socio> prestiti;
    public Prestiti(){
        prestiti = new HashMap<>();
    }


    private int getNumPrestiti(Socio s){
        int count = 0; 
        for(Socio socio: prestiti.values()){
            if(socio.equals(s)){
                count++;
            }
        }
        return count;
    }


    public boolean register(Socio socio, Libro libro){
        if(getNumPrestiti(socio) >= 5){
            System.out.println("Impossibile effettuare prestito, il socio ha molti libri a carico");
            return false;
        }
        prestiti.put(libro, socio);
        System.out.println("Prestito registrato");
        return true;
    }
    
    public void returnBook(Libro l){
        if(prestiti.remove(l) == null){
            System.out.println("Prestito non trovato");
        }else{
            System.out.println("Il socio ha correttamente ritornato il libro");
        }
    }
}