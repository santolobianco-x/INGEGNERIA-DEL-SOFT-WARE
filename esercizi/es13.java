

// FACTORY METHOD
public class es13{
    public static void main(String args[]){
        GeneratorReport pdfGenerator = new GeneratorePDF();
        GeneratorReport wordGenerator = new GeneratoreWord();

        pdfGenerator.eseguiProcessoStampa();
        wordGenerator.eseguiProcessoStampa();
        
    }
}


interface Documento{ // COMPONENT
    public void stampa();
}


class DocumentoPDF implements Documento{ // CONCRETE COMPONENT 
    public void stampa(){
        System.out.println("Stampo un PDF ad alta definizione");
    }
}


class DocumentoWord implements Documento{ // CONCRETE COMPONENT
    public void stampa(){
        System.out.println("Stampo un file Word ad alta definizione");
    }
}





abstract class GeneratorReport{ // CREATOR
    public void eseguiProcessoStampa(){
        System.out.println("1. Raccolgo i dati dal database...");
        System.out.println("2. Formatto l'intestazione aziendale...");

        Documento doc = this.getDocumento();

        doc.stampa();
    }


    abstract protected Documento getDocumento();
}


class GeneratorePDF extends GeneratorReport{ // CONCRETE CREATOR
    protected Documento getDocumento(){
        return new DocumentoPDF();
    }
}


class GeneratoreWord extends GeneratorReport{ // CONCRETE CREATOR
    protected Documento getDocumento(){
        return new DocumentoWord();
    }
}