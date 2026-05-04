//MULTITON -> VENGONO CREATE UN NUMERO FINITO DI INSTANZE, DOVE OGNI INSTANZA HA UNA CHIAVE
import java.util.HashMap;
import java.util.Map;

class ex10{
    public static void main(String args[]){
        DB docenti = DB.getInstance("doc");
        DB studenti = DB.getInstance("stud");
        DB docenti2 = DB.getInstance("doc");
        docenti.query("SELECT * FROM docenti WHERE materia = \'matematica\'");
        studenti.query("SELECT * FROM studenti WHERE media >= 25");
        docenti2.query("SELECT matricola FROM docenti WHERE cognome = \'Lo Bianco\' && nome = \'Santo\'");
    }
}


class DB{
    private static Map <String, DB> instances = new HashMap<>();
    private String dbName;
    
    private DB(String dbName){
        this.dbName = dbName;
        System.out.println("CONNESSIONE CREATA PER DATABASE: "+dbName);
    }

    public static DB getInstance(String dbName){
        if(!instances.containsKey(dbName)){
            instances.put(dbName, new DB(dbName));
        }
        return instances.get(dbName);
    }

    public void query(String sql){
        System.out.println("ESECUZIONE QUERY SUL DATABASE: "+dbName +" : "+ sql);
    }
}