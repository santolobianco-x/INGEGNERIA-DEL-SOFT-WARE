import java.util.Arrays;
import java.util.List;;

//STREAM -> Permette di semplificare l'utilizzo di classi figlie(implementative) della Collection
//       -> lista trasformata in un flusso, i cui metodi non necessitano cicli perchè sono implementati internamente
//       -> codice più leggibile e programmazione FUNZIONALE
public class ex19{
    public static void main(String args[]){
        List<String> fruits = Arrays.asList("BANANA", "APPLE", "PINEAPPLE", "STRAWBERRY");
        fruits.stream().forEach(s -> System.out.println(s));

        // CON STREAM, PIU' LEGGIBILE E SEMPLICE DA APPLICARE
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        numbers.stream()
            .filter(n -> n%2 == 0)
            .forEach(n -> System.out.println(n));



        // SENZA STREAM, MENO LEGGIBILE E CON IMPLEMENTAZIONE DIRETTA DEI CICLI
        List<Integer> number_s = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        for (Integer n : number_s) {
            if (n % 2 == 0) {
                System.out.println(n);
            }
        }

        //REDUCE -> utile ad aggregare mediante operazioni(somma moltiplicazione ecc) tutti gli elementi in unico elemento
        //       -> restituisce
        List<Integer> toSum = Arrays.asList(1,2,3,4,55,6,7,10,15,77);
        int sum = toSum.stream()
            .reduce(0,(accum,v) -> accum+v);
        System.out.println("Somma uguale a " + sum);


        //MAP -> utile ad applicare una funzione a tutti gli elementi di uno stream
        //    -> ritorna un ulteriore stream
        List<Double> toSquare = Arrays.asList(22d,55d,453d,669d,34d,81d); //d specifica che sono DOUBLE
        List<Double> roots = toSquare.stream().map(Math::sqrt).toList();
        roots.forEach(x-> System.out.println(x));
        

    }
}