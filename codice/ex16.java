// BUILDER -> design pattern che separa la costruzione di un oggetto 
// dalla sua rappresentazione. Un altra classe sarà incaricata di costruire istanze di oggetti
// immutabili(final).
public class ex16{
    public static void main(String args[]){
        Director dir = new Director();
        House cheap = dir.getCheapHouse();
        House familiar = dir.getFamiliarHouse();
        House ecoluxury = dir.getEcoLuxury();
        cheap.printInfo();
        familiar.printInfo();
        ecoluxury.printInfo();
    }
}



// INTERFACCIA CHE DEVONO IMPLEMENTARE I COSTRUTTORI DI CLASSI
interface HouseBuilder{
    public void setGarage(boolean g);
    public void setGarden(boolean g);
    public void setSolarPanels(boolean s);
    public House getHouse();
}


// DIRECTOR -> CLASSE CHE PERMETTE DI COSTRUIRE OGGETTI PREIMPOSTATI
class Director{
    public Director(){}
    public House getCheapHouse(){
        HouseBuilder cheap = new ConcreteHouseBuilder(2, 1, 1);
        return  cheap.getHouse();
    }
    public House getFamiliarHouse(){
        HouseBuilder large = new ConcreteHouseBuilder(4, 2, 3);
        large.setGarage(true);
        large.setGarden(true);
        return large.getHouse();
    }
    public House getEcoLuxury(){
        HouseBuilder ecoluxury = new ConcreteHouseBuilder(5, 3, 2);
        ecoluxury.setGarage(true);
        ecoluxury.setGarden(true);
        ecoluxury.setSolarPanels(true);
        return ecoluxury.getHouse();
    }
}


// COSTRUTTORE DELL'ISTANZA COSTANTE
class ConcreteHouseBuilder implements HouseBuilder{
    public int nRooms;
    public int nRestRooms;
    public boolean garage;
    public boolean garden;
    public boolean solarPanels;
    public String roof;

    public ConcreteHouseBuilder(int r, int rr, int ro){
        nRooms = r;
        nRestRooms = rr;
        switch (ro) {
            case 2:
                roof = "Spiovente";
            break;
            case 3:
                roof = "Terrazza";
            break;
            default:
                roof = "Piano";
            break;
        }
        garage = false;
        garden = false;
        solarPanels = false;
    }

    public void setGarage(boolean g){
        garage = g;
    }

    public void setGarden(boolean g){
        garden = g;
    }

    public void setSolarPanels(boolean s){
        solarPanels = s;
    }

    public House getHouse(){
        return new House(nRooms, nRestRooms, garage, garden, solarPanels, roof);
    }
}



class House{
    public final int nRooms;
    public final int nRestRooms;
    public final boolean garage;
    public final boolean garden;
    public final boolean solarPanels;
    public final String roof;
    public House(int r, int rr, boolean g, boolean gd, boolean s, String ro){
        nRooms = r;
        nRestRooms = rr;
        garage = g;
        garden = gd;
        solarPanels = s;
        roof = ro;
    }

    public void printInfo(){
        System.out.println("Number of Rooms: " + nRooms);
        System.out.println("Number of RestRooms: "+ nRestRooms);
        System.out.println("Type of Rooms: "+ roof);
        if(garage){
            System.out.println("Garage included");
        }
        if(garden){
            System.out.println("Garden included");
        }
        if(solarPanels){
            System.out.println("Solar Panels included");
        }
    }
}


