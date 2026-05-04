import java.lang.Math;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;



public class ex21{
    public static void main(String []args){

        System.out.println("==================ITERATE==================");
        List<Integer> pari = Stream.iterate(0, n -> n+2)
        .limit(50)
        .collect(Collectors.toList());
        pari.stream().forEach(o -> System.out.println(o));



        System.out.println("==================GENERATE==================");
        List<Integer> dispari = Stream
        .generate(() -> 2 * (int)(Math.random() * 50) + 1) //MATH RANDOM GENERA NUMERI TRA 0 E 1, QUINDI PER PORTARLI IN UNA SCALA DA 0 A 50, BASTA MOLTIPLICARLI PER 50
        .limit(50)
        .collect(Collectors.toList());
        dispari.stream().forEach(d -> System.out.println(d));



        System.out.println("==================GENERATE PARALLELIZZATO==================");
        List<Double> parallelRandom = Stream.generate(()->(Double)(Math.random()))
        .parallel() // GLI ELEMENTI VENGONO GENERATI IN MODO PARALLELO
        .limit(50)
        .collect(Collectors.toList());
        parallelRandom.stream()
        .forEach(p -> System.out.println(p));



        System.out.println("DEBUG TRAMITE PEEK");
        parallelRandom.stream()
        .limit(10)
        .peek( x -> System.out.println("PRIMA DI APPLICARE *10: " + x))
        .map( x -> x*10)
        .peek( x -> System.out.println("DOPO AVER APPLICATO *10: " + x))
        .toList();
        



    }
}


