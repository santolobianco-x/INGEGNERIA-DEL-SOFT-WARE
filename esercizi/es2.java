


public class es2{
    public static void main(String args[]){
        Negozio Euronics = new Negozio();

        System.out.println("PC da Gaming:");
        Computer pcgaming = Euronics.compraPCGaming();
        pcgaming.printComponent();
        System.out.println("");

        System.out.println("MAC mini:");
        Computer mini = Euronics.compraMacMini();
        mini.printComponent();
        System.out.println("");

        System.out.println("MAC M1:");
        Computer m1 = Euronics.compraMacM1();
        m1.printComponent();
        System.out.println("");
    }
}



class Computer{
    public final String CPU;
    public final int RAM;
    public final int memoria;
    public final boolean GPU;

    public Computer(String CPU, int RAM, int memoria, boolean GPU){
        this.CPU = CPU;
        this.RAM = RAM;
        this.memoria = memoria;
        this.GPU = GPU;
    }

    public void printComponent(){
        System.out.println("CPU model: "+ CPU);
        System.out.println("RAM size: "+ RAM + " GB");
        System.out.println("Memory size: "+ memoria + " GB");
        if(GPU){
            System.out.println("GPU installed");
        }
    }

}




interface BuilderPc{
    public void setCpu(String cpu);
    public void setRam(int ram);
    public void setMemoria(int memoria);
    public void setSchedaVideo(boolean gpu);
    public Computer getComputer();
}


class ConcreteBuilderPC implements BuilderPc{
    public String CPU; 
    public int RAM; 
    public int memoria; 
    public boolean GPU;

    public void setCpu(String cpu){
        CPU = cpu;
    }
    public void setRam(int ram){
        RAM = ram;
    }
    public void setMemoria(int memoria){
        this.memoria = memoria;
    }
    public void setSchedaVideo(boolean gpu){
        this.GPU = gpu;
    }

    public Computer getComputer(){
        return new Computer(CPU, RAM, memoria, GPU);
    }
}

class Negozio{
    public Computer compraPCGaming(){
        BuilderPc b = new ConcreteBuilderPC();
        b.setCpu("i9");
        b.setRam(32);
        b.setMemoria(1000);
        b.setSchedaVideo(true);
        return b.getComputer();
    }

    public Computer compraMacMini(){
        BuilderPc b = new ConcreteBuilderPC();
        b.setCpu("M4");
        b.setRam(32);
        b.setMemoria(512);
        b.setSchedaVideo(false);
        return b.getComputer();
    }

    public Computer compraMacM1(){
        BuilderPc b = new ConcreteBuilderPC();
        b.setCpu("M1");
        b.setRam(16);
        b.setMemoria(256);
        b.setSchedaVideo(true);
        return b.getComputer();
    }
}