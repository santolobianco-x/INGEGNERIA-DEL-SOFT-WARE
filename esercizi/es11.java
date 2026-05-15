//DECORATOR
public class es11{
    public static void main(String args[]){
        Pizza pizzaM = new PizzaMargherita();
        System.out.println(pizzaM.getDescrizione());
        System.out.println("Prezzo: " + pizzaM.getPrezzo());


        Pizza pizzaP = new AggiuntaFunghi(pizzaM);
        System.out.println(pizzaP.getDescrizione());
        System.out.println("Prezzo: " + pizzaP.getPrezzo());


        Pizza pizzaF = new AggiuntaFunghi(pizzaM);
        System.out.println(pizzaF.getDescrizione());
        System.out.println("Prezzo: " + pizzaF.getPrezzo());

        pizzaF = new AggiuntaProsciutto(pizzaF);
        System.out.println(pizzaF.getDescrizione());
        System.out.println("Prezzo: " + pizzaF.getPrezzo());

    }
}


interface Pizza{ // COMPONENT
    public String getDescrizione();
    public double getPrezzo();
}


class PizzaMargherita implements Pizza { // CONCRETE COMPONENT
    public String getDescrizione() {
        return "Pizza Margherita";
    }
    
    public double getPrezzo() {
        return 5.00;
    }
}


abstract class IngredienteExtra implements Pizza{ // DECORATOR

    protected Pizza pizzaBase;
    public IngredienteExtra(Pizza pizza){
        this.pizzaBase = pizza;
    }

    public String getDescrizione(){
        return pizzaBase.getDescrizione();
    }

    public double getPrezzo(){
        return pizzaBase.getPrezzo();
    }
}




class AggiuntaProsciutto extends IngredienteExtra{ // CONCRETE DECORATOR
    public AggiuntaProsciutto(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getDescrizione(){
        return pizzaBase.getDescrizione() + " + Prosciutto";
    }

    @Override
    public double getPrezzo(){
        return pizzaBase.getPrezzo() + 2d;
    }

}



class AggiuntaFunghi extends IngredienteExtra{ // CONCRETE DECORATOR
    public AggiuntaFunghi(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getDescrizione(){
        return pizzaBase.getDescrizione() + " + Funghi";
    }

    @Override
    public double getPrezzo(){
        return pizzaBase.getPrezzo() + 1.5d;
    }

}
