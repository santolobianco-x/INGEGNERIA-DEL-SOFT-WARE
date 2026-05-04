import java.util.ArrayList;
import java.util.List;


// DESIGN PATTERN: OBSERVER
//  --> l'observer è un design pattern comportamentale che permette di mantenere la coerenza
//  --> quando ci sono classi dipendente da una classe e il cambiamento di stato deve esseere notificato
//  --> per continuare a mantenere uno stato consistente.

public class ex25{
    public static void main(String args[]){

        WeatherStation station = new WeatherStation();

        Observer o1 = new PhoneDisplay(station);
        Observer o2 = new PCDisplay(station);
        

        station.setTemperature(30);
        freeze();
        station.setTemperature(31);
        freeze();
        station.setTemperature(32);

    }


    public static void freeze(){
        try{
            Thread.sleep(5000);
        } catch(InterruptedException e){}
    }
}


// OBSERVER
interface Observer{
    public void update();
}


// SUBJECT 
abstract class Subject{
    protected List<Observer> observers = new ArrayList<>();

    public void attach(Observer o){
        observers.add(o);
    }

    public void detach(Observer o){
        observers.remove(o);
    }

    public void notifyObservers(){
        for(Observer o:observers)
            o.update();
    }
}


// CONCRETE SUBJECT 
class WeatherStation extends Subject{
    private int temperature;
    public void setTemperature(int t){
        temperature = t;
        notifyObservers();
    }
    

    public int getTemperature(){return temperature;}
}


// CONCRETE OBSERVER
class PhoneDisplay implements Observer{
    private WeatherStation station;

    public PhoneDisplay(WeatherStation w){
        station = w;
        station.attach(this);
    }

    public void update(){
        int temperature = station.getTemperature();

        System.out.println("Phone display: temperatura = "+ temperature);
    }
}




class PCDisplay implements Observer{
    private WeatherStation station;

    public PCDisplay(WeatherStation w){
        station = w;
        station.attach(this);
    }

    public void update(){
        int temperature = station.getTemperature();

        System.out.println("PC display: temperatura = "+ temperature);
    }
}