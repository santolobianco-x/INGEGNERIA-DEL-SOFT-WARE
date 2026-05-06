//ADAPTER --> STRUTTURALE(O COMPORTAMENTALE) 
public class es1{
    public static void main(String args[]){
        TermometroVecchio t = new TermometroVecchio();
        SensoreTemperatura tnuovo = new TermometroAdapter(t);
        System.out.println("Gradi Celsius: "+ tnuovo.getTemperaturaCelsius());
        System.out.println("Gradi Celsius: "+ tnuovo.getTemperaturaCelsius());
        System.out.println("Gradi Celsius: "+ tnuovo.getTemperaturaCelsius());

    }
}


interface SensoreTemperatura{
    public float getTemperaturaCelsius();
}

class TermometroVecchio{
    public float getTemperaturaFahrenheit(){
        return (float) (Math.random()*160-30);
    }
}


class TermometroAdapter implements SensoreTemperatura{
    
    private TermometroVecchio t;
    public TermometroAdapter(TermometroVecchio t){
        this.t = t;
    }
    
    public float getTemperaturaCelsius(){
        return (t.getTemperaturaFahrenheit()-32)*5f / 9f;
    }
}