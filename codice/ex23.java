
public class ex23 {
	private Messaggio m = new Riduttore(new Testo("Taro", "There are four of us here"));

	public static void main(String[] args) {
		System.out.println("Istanziazione ... ");
		ex23 c = new ex23();
		c.test();
		c.test2();
	}
	
	private void test() {
		System.out.println("Invocazione metodo getTesto ... ");
		System.out.println("\ntesto: " + m.getTesto()+"\n");
		System.out.println("Invocazione metodo getDestin ... ");
		System.out.println("\ndestin: " + m.getDestin()+"\n");
	}

	private void test2() {
		System.out.println("Istanziazione m2 ... ");
		Messaggio m2 = new Riduttore(new Indirizzi(new Testo("Saro", "Saro, are you going to go home now?")));
		
		System.out.println("Invocazione metodo getTesto ... ");
		System.out.println("\ntesto: " + m2.getTesto()+"\n");
		System.out.println("Invocazione metodo getDestin ... ");
		System.out.println("\ndestin: " + m2.getDestin()+"\n");
	}

}


// DESIGN PATTERN DECORATOR:
// si possono estendere funzionalità, senza eredità, in modo totalmente elastico attraverso i decorator.



interface Messaggio{ // COMPONENT
    public String getDestin();
    public String getTesto();
}


class Testo implements Messaggio{ // CONCRETE COMPONENT
    private String testo;
    private String dest;

    public Testo(String t, String d){
        testo = t;
        dest = d;
    }

    public String getDestin(){
        System.out.println("[Testo.getDestin]");
        return dest;
    }

    public String getTesto(){
        System.out.println("[Testo.getTesto]");
        return testo;
    }

}


class Modificatore implements Messaggio{ // DECORATOR
    private Messaggio p;
    
    public Modificatore(Messaggio c){
        p = c;
    }

    public String getDestin(){
        System.out.println("[Modificatore.getDestin] ");
        return p.getDestin();
    }

    public String getTesto(){
        System.out.println("[Modificatore.getTesto] ");
        return p.getTesto();
    }

}


class Riduttore extends Modificatore{ // CONCRETE DECORATOR
    public Riduttore(Messaggio c){
        super(c);
    }

    public String getTesto(){
        System.out.println("[Riduttore.getTesto] ");
		String s = super.getTesto();
		s = s.replaceAll("!", "");
		s = s.replaceAll("four", "4");
		s = s.replaceAll("going to", "gonna");
		s = s.replaceAll("would you", "wonna");
		return s;
    }
}


class Indirizzi extends Modificatore{ //CONCRETE DECORATOR
    public Indirizzi(Messaggio c){
        super(c);
    }

    public String getDestin(){
        System.out.println("[Indirizzi.getDestin]");
        String s = super.getDestin();
        s = s.replaceFirst("Saro", "3336543211");
        s = s.replaceFirst("Taro", "3939685732");
        return s;
    }


}