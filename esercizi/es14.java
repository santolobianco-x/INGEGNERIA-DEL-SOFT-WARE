

public class es14{
    public static void main(String args[]){
        Televisore tv = new Televisore();
        ImpiantoAudio audio = new ImpiantoAudio();
        LuciSmart luci = new LuciSmart();


        GestioneHomeTheater homeTheater = new GestioneHomeTheater(tv, audio, luci);
        homeTheater.guardaFilm("La Bella Vita");

        System.out.println("\n\n");
        homeTheater.fineFilm();
    }
}



class Televisore{
    public void accendi(){ System.out.println("TV accesa.");}
    public void impostaIngresso(String ingresso){ System.out.println("TV impostata su:" + ingresso);}
    public void spegni(){ System.out.println("TV spenta.");}
}

class ImpiantoAudio{
    public void accendi(){ System.out.println("Impianto Audio acceso.");}
    public void impostaVolume(int volume){ System.out.println("Volume impostata su:" + volume);}
    public void spegni(){ System.out.println("Impianto Audio spento.");}
}



class LuciSmart{
    public void abbassa(){ System.out.println("Luci abbassate per la visione del film.");}
    public void accendi(){ System.out.println("Luci accese al 100%");}
}


class GestioneHomeTheater{
    private Televisore TV;
    private ImpiantoAudio audio;
    private LuciSmart luci;

    public GestioneHomeTheater(Televisore TV, ImpiantoAudio audio, LuciSmart luci){
        this.TV = TV;
        this.audio = audio;
        this.luci = luci;
    }

    public void guardaFilm(String film){
        System.out.println("-- Preparazione per la visione del film: " + film + " --");
        TV.accendi();
        audio.accendi();
        luci.abbassa();
        TV.impostaIngresso(film);
        audio.impostaVolume(60);
    }

    public void fineFilm(){
        System.out.println("-- Spegnimento del sistema Home Theater --");
        TV.spegni();
        audio.spegni();
        luci.accendi();
    }
}