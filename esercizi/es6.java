//STATE
public class es6{
    public static void main(String args[]){
        Guida g = new Guida();
        g.accelera();
        g.accelera();
        g.accelera();
        g.getVelocita();
        g.apriPorte();

        g.fermati();
        g.getVelocita();
        g.apriPorte();
    }
}



interface Auto{
    public Auto frena();
    public Auto accelera();
    public int getVelocita();
    public boolean apriPorte();
}



class AutoM implements Auto{
    int velocita = 0;

    public Auto frena(){
        return new AutoS();
    }

    public Auto accelera(){
        velocita++;
        return this;
    }

    public int getVelocita(){return velocita;}

    public boolean apriPorte(){return false;}
}




class AutoS implements Auto{
    public Auto frena(){
        return this;
    }

    public Auto accelera(){
        return new AutoM().accelera();
    }

    public int getVelocita(){return 0;}

    public boolean apriPorte(){return true;}
}







class Guida{
    private Auto a = new AutoS();

    public void parti(){
        a = a.accelera();
    }

    public void frena(){
        a = a.frena();
    }

    public void fermati(){
        a = new AutoS();
    }

    public void accelera(){
        a = a.accelera();
    }

    public void getVelocita(){
        System.out.println("Velocità: "+ a.getVelocita());
    }

    public void apriPorte(){
        if(a.apriPorte())
            System.out.println("Porte aperte OK");
        else
            System.out.println("Porte chiuse");
    }
}


