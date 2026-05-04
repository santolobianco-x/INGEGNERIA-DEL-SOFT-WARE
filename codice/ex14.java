// PROTOTYPE PATTERN
// DESIGN PATTERN ADETTO A SEPARARE LA CLASSE CHE ISTANZIA L'OGGETTO DA QUELLA CHE LA USA
// L'ISTANZAZIONE AVVIENE ATTRAVERSO UN METODO CLONE NELL'OGGETTO DA ISTANZIARE
// SI UTILIZZERANNO DEGLI OGGETTI CHIAMATI "PROTOTIPI" CHE PRESENTANO UNO STATO GIA' CONFIGURATO
import java.util.HashMap;
import java.util.Map;

public class ex14{
    public static void main(String[] args) {
        PersonaggioManager pm = new PersonaggioManager();

        Personaggio pnoob = new PersonaggioConcreteD(3, 5);
        pnoob.addAbility("Pugno","Colpisce con pugno");
        pnoob.addAbility("Calcio","Colpisce con calcio");
        pm.add("Noob", pnoob);
        Personaggio first = pm.get("Noob");
        first.addAbility("Spada", "Colpisce con spada");
        first.showInfo();
        pm.get("Noob").showInfo();
    }
}


interface Personaggio{
    public void incrementPS();
    public void decrementPS();
    public void incrementPF();
    public void decrementPF();
    public void addAbility(String title, String description);
    public void showInfo();
    public Personaggio clone();
}

// DEEP COPY
class PersonaggioConcreteD implements Personaggio{
    private int PS;
    private int PF;
    private Map<String, String> abilities;


    public PersonaggioConcreteD(int PS, int PF){
        this.PS = PS;
        this.PF = PF;
        this.abilities = new HashMap<>();
    }


    private PersonaggioConcreteD(int PS, int PF, Map<String, String> abilities){
        this.PS = PS;
        this.PF = PF;
        this.abilities = abilities;
    }


    public void incrementPS(){
        if(PS < 10){
            PS++;
        } 
    }
    public void decrementPS(){
        if(PS > 0){
            PS--;
        }
        
    }

    public void incrementPF(){
        if(PF < 10){
            PF++;
        }
    }
    public void decrementPF(){
        if(PF > 0){
            PF--;
        }
    }

    public void addAbility(String title, String description){
        abilities.put(title, description);
    }

    public void showInfo(){
        System.out.println("PS: " + PS + " | PF: " + PF);
        System.out.println("Abilità:");
        for (Map.Entry<String, String> entry : abilities.entrySet()) {
            System.out.println(" - " + entry.getKey() + ": " + entry.getValue());
        }
    }


    public Personaggio clone(){
        Map<String, String> abilitiesCopy = new HashMap<>(this.abilities);
        return new PersonaggioConcreteD(PS,PF, abilitiesCopy);
    }

}




// SHALLOW COPY
class PersonaggioConcreteS implements Personaggio{
    private int PS;
    private int PF;
    private Map<String, String> abilities;


    public PersonaggioConcreteS(int PS, int PF){
        this.PS = PS;
        this.PF = PF;
        this.abilities = new HashMap<>();
    }


    private PersonaggioConcreteS(int PS, int PF, Map<String, String> abilities){
        this.PS = PS;
        this.PF = PF;
        this.abilities = abilities;
    }


    public void incrementPS(){
        if(PS < 10){
            PS++;
        } 
    }
    public void decrementPS(){
        if(PS > 0){
            PS--;
        }
        
    }

    public void incrementPF(){
        if(PF < 10){
            PF++;
        }
    }
    public void decrementPF(){
        if(PF > 0){
            PF--;
        }
    }

    public void addAbility(String title, String description){
        abilities.put(title, description);
    }

    public void showInfo(){
        System.out.println("PS: " + PS + " | PF: " + PF);
        System.out.println("Abilità:");
        for (Map.Entry<String, String> entry : abilities.entrySet()) {
            System.out.println(" - " + entry.getKey() + ": " + entry.getValue());
        }
    }


    public Personaggio clone(){
        return new PersonaggioConcreteS(PS,PF, abilities);
    }

}


class PersonaggioManager{
    public Map<String, Personaggio> prototipi;
    public PersonaggioManager(){
        prototipi = new HashMap<>();
    }
    void add(String s, Personaggio p){
        prototipi.put(s, p);
    }

    Personaggio get(String s){
        if(prototipi.get(s) != null){
            return prototipi.get(s).clone();
        }
        return null;
    }


    void remove(String s){
        prototipi.remove(s);
    }

}