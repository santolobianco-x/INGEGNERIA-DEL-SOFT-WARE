//IMPLEMENTAZIONE RECORD JAVA
public class ex6 {
    public static void main(String[] args) {
        Studente s1 = new Studente("Mario", 27.5f);
        Studente s2 = new Studente("Anna", 30.0f);

        Corso c1 = new Corso("Programmazione 2", 8);
        Corso c2 = new Corso("Ingegneria del Software", 6);

        System.out.println(s1.nome() + " media: " + s1.media());
        System.out.println(s2.nome() + " media: " + s2.media());
        System.out.println("Corso: " + c1.titolo() + " CFU: " + c1.cfu());
        System.out.println("Corso: " + c2.titolo() + " CFU: " + c2.cfu());
    }
}



interface Valutabile{
    boolean promosso();
}

record Studente(String nome, float media) implements Valutabile{ 
    public boolean promosso(){
        return media > 30;
    }
}
record Corso(String titolo, int cfu) { }


