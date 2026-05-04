// DESIGN PATTERN STATE --> design pattern che permette di cambiare il comportamento al cambiare dello stato dell'oggetto
//                      -->  evita l'utilizzo di blocchi condizionali 
public class ex27{
    public static void main(String args[]){
        Document doc1 = new Document("doc1");
        Document doc2 = new Document("doc2");
        Document doc3 = new Document("doc3");

        doc1.publish();
        doc2.publish();
        doc3.publish();


        doc1.publish();
        doc2.publish();
        doc3.publish();

        doc1.publish();
        doc2.publish();
        doc3.publish();
    }

}


interface State{ // STATE
    public void publish(Document doc);
}


class DraftState implements State{ // CONCRETE STATE 1
    public void publish(Document doc){
        System.out.println("Il documento: '"+ doc.getNome()+"' passa in revisione.");
        doc.setState(new ModerationState());
    }
}

class ModerationState implements State{ // CONCRETE STATE 2
    public void publish(Document doc){
        System.out.println("Il documento: '"+ doc.getNome()+"'passa in publicazione");
        doc.setState(new PublishedState());
    }
}

class PublishedState implements State{ // CONCRETE STATE 3
    public void publish(Document doc){
        System.out.println("Il documento: '"+ doc.getNome()+"' è stato pubblicato");
    }
}


class Document{ // CONTEXT
    private State state;
    private String nome;


    public Document(String s){
        state = new DraftState();
        nome = s;
    }

    public void setState(State state){
        this.state = state;
    }

    public void publish(){
        state.publish(this);
    }

    public String getNome(){return nome;}
}