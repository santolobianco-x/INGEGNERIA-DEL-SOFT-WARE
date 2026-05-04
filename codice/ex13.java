// ABSTRACT FACTORY
//Pattern creazionale che fornisce un’interfaccia per creare famiglie
//di oggetti correlati senza specificare le loro classi concrete.
//Il client utilizza solo le interfacce, garantendo coerenza tra i prodotti.
public class ex13 {
    public static void main(String args[]){
        GUIFactory macf = new MacFactory();
        GUIFactory windowsf = new WindowsFactory();
        Button mb = macf.createButton();
        Button wb = windowsf.createButton();

        CheckBox mc = macf.createCheckBox();
        CheckBox wc = windowsf.createCheckBox();

        mb.render();
        mc.render();
        wb.render();
        wc.render();

    }
}


interface Button{ // ABSTRACT PRODUCT 
    public void render();
}

interface CheckBox{ // ABSTRACT PRODUCT
    public void render();
}

interface GUIFactory{ // ABSTRACT FACTORY
    public Button createButton();
    public CheckBox createCheckBox();
}


class WindowsButton implements Button{ // CONCRETE PRODUCT
    public void render(){
        System.out.println("RENDERING WINDOWS BUTTON");
    }
}

class MacButton implements Button{ // CONCRETE PRODUCT
    public void render(){
        System.out.println("RENDERING MAC BUTTON");
    }
}


class WindowsCheckbox implements CheckBox{ // CONCRETE PRODUCT
    public void render(){
        System.out.println("RENDERING WINDOWS CHECKBOX");
    }
}

class MacCheckbox implements CheckBox{ // CONCRETE PRODUCT
    public void render(){
        System.out.println("RENDERING MAC CHECKBOX");
    }
}


class WindowsFactory implements GUIFactory{ // CONCRETE FACTORY
    public Button createButton(){
        return new WindowsButton();
    }

    public CheckBox createCheckBox(){
        return new WindowsCheckbox();
    }
}



class MacFactory implements GUIFactory{ // CONCRETE FACTORY
    public Button createButton(){
        return new MacButton();
    }

    public CheckBox createCheckBox(){
        return new MacCheckbox();
    }
}