// DESIGN PATTERN: COMMAND(comportamentale) --> impiegato per separare chi effettua una richiesta da chi la esegue questo disaccoppiamento 
//                                          -->  permette di modificare il receiver e far gestire al command cosa deve essere fatto 
//                                          -->  e chi lo deve fare. Le richieste diventano degli oggetti e possono essere trattati come dati.

public class ex31{
    public static void main(String args[]){

        // -- CLIENT
        Editor editor = new Editor();

        Command copy = new CopyCommand(editor);
        Command paste = new PasteCommand(editor);
        Command cut = new CutCommand(editor);
        // --- CLIENT

        // -- INVOKER
        copy.execute();
        paste.execute();
        cut.execute();
        // -- INVOKER
    }
}


interface Command{ // COMMAND
    public void execute();
}


class Editor{ // RECEIVER
    public void copy(){
        System.out.println("Testo Copiato");
    }

    public void paste(){
        System.out.println("Testo Incollato");
    }

    public void cut(){
        System.out.println("Testo Tagliato");
    }
}


class CopyCommand implements Command{ // CONCRETE COMMAND
    private Editor editor;
    public CopyCommand(Editor e){
        editor = e;
    }

    public void execute(){
        editor.copy();
    }
}


class PasteCommand implements Command{ // CONCRETE COMMAND
    private Editor editor;
    public PasteCommand(Editor e){
        editor = e;
    }
    
    public void execute(){
        editor.paste();
    }
}


class CutCommand implements Command{ // CONCRETE COMMAND
    private Editor editor;
    public CutCommand(Editor e){
        editor = e;
    }
    
    public void execute(){
        editor.cut();
    }
}