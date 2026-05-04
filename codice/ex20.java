import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// UTILIZZO DEGLI JAVA STREAMS
public class ex20 {

    public static void main(String args[]){
        List<Ordine> ordini = List.of(
            new Ordine("Santo", "MacBook pro", "Computer", 1499.99, 1),
            new Ordine("Anna", "Mouse", "Informatica", 25, 2),
            new Ordine("Marco", "Scrivania", "Arredo", 300, 1),
            new Ordine("Sara", "Monitor", "Informatica", 200, 2),
            new Ordine("Paolo", "Sedia", "Arredo", 150, 4),
            new Ordine("Giulia", "Tastiera", "Informatica", 80, 1)
        );



        ordini.stream()
        .filter(o -> o.categoria().equals("Informatica"))
        .sorted(Comparator.comparing(Ordine::cliente))
        .distinct()
        .forEach(o -> System.out.println("Cliente acquisti \'informatica\'': "+ o.cliente()));



        double totalPrice = ordini.stream()
        .map(o -> o.prezzo()*o.quantita())
        .reduce(0.0,(accum,o)-> accum+o);
        System.out.println(("Fatturato totale: "+ totalPrice));




        Optional<Ordine> max = ordini.stream()
        .max(Comparator.comparing(o-> o.prezzo() * o.quantita()));
        if(max.isPresent())System.out.println("Ordine più costoso: " + max.get());





        List<String> prodottiArredo = ordini.stream()
        .filter(o -> o.categoria().equals("Arredo"))
        .map(o -> o.prodotto())
        .collect(Collectors.toList());



        prodottiArredo.stream().forEach(o -> System.out.println("Prodotto della categoria \'Arredo\': "+o));



        long nOrdiniCostosi = ordini.stream()
        .filter(o -> (o.prezzo() * o.quantita()) >= 100.00)
        .count();

        System.out.println("Numero di prodotti ordini costosi(>=100): "+ nOrdiniCostosi);


    }
}



record Ordine(String cliente, String prodotto, String categoria, double prezzo, int quantita){}



