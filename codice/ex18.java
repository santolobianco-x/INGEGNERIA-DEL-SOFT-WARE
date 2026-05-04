public class ex18{
    public static void main(String args[]){

        // CLASSE ANONIMA
        Thread t = new Thread(new Runnable(){
            public void run(){
                for(int i = 1; i <= 5; i++){
                    System.out.println("Messaggio classe anonima " + i + " thread");
                    try{
                        Thread.sleep(500);
                    }catch(InterruptedException e){
                        System.err.println(e);
                    }
                }
            }
        });
        t.start();

        //interfaccia che può essere utilizzata da qualsiasi thread per eseguire un metodo.
        //essa ha un solo metodo ossia il metodo    'run()'
        Runnable r = () -> System.out.println("Esempio di funzione lambda");
        r.run();

        
        

        //implementa l'interfaccia somma ritornando ciò che è specificato nel metodo calcola
        Somma s = (a,b) -> a+b;
        s.calcola(5, 6);


        //funzione anonima su più righe
        Thread t2 = new Thread((
            () ->{
                for(int i = 1; i <= 5; i++){
                    System.out.println("Messaggio espressione lambda "+ i + " thread");
                    try{
                        Thread.sleep(500);
                    }catch(InterruptedException e){
                        System.err.println(e);
                    }
                }
            }
        ));

        t2.start();
        
        

        System.out.println("Esecuzione thread principale finita");
    }
}

interface Somma{
    public int calcola(int a, int b);
}