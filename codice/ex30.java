


// DESIGN PATTERN CHAIN OF RESPONSIBILITY --> questo design pattern comportamentale si occupa di separare chi manda una richiesta
//                                        --> da chi la elabora. in questo modo la richiesta passa lungo una catena di oggetti.



public class ex30{ // CLIENT
    public static void main(String args[]){
        Approver tl = new TeamLeader();
        Approver m = new Manager();
        Approver d = new Director();


        tl.setSuccessor(m);
        m.setSuccessor(d);

        tl.handleRequest(70);
        tl.handleRequest(700);
        tl.handleRequest(3000);
        tl.handleRequest(7000);
    }
}


abstract class Approver{ // HANDLER
    protected Approver successor;
    

    public void setSuccessor(Approver successor){
        this.successor = successor;
    }
    
    public abstract void handleRequest(int amount);
}


class TeamLeader extends Approver{ // CONCRETE HANDLER 
    public void handleRequest(int amount){
        if(amount <= 100){
            System.out.println("TeamLeader approva " + amount);
        }else if(successor != null){
            successor.handleRequest(amount);
        }
    }
}


class Manager extends Approver{ // CONCRETE HANDLER
    public void handleRequest(int amount){
        if(amount <= 1000){
            System.out.println("Manager approva " + amount);
        }else if(successor != null){
            successor.handleRequest(amount);
        }
    }
}



class Director extends Approver{ // CONCRETE HANDLER
    public void handleRequest(int amount){
        if(amount <= 5000){
            System.out.println("Director approva " + amount);
        }else{
            System.out.println("Richiesta non gestita");
        }
    }
}