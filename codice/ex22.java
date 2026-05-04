import java.util.ArrayList;
import java.util.List;


// DESIGN PATTERN COMPOSITE 
// Permette di rappresentare strutture ad albero trattando in modo uniforme
// oggetti singoli (Leaf) e composti (Composite).

public class ex22{
    public static void main(String args[]){

        // root
        Directory root = new Directory("root", null);

        // sottodirectory
        Directory dir1 = new Directory("dir1", root);
        Directory dir2 = new Directory("dir2", root);

        // file
        NormalFile f1 = new NormalFile("file1");
        NormalFile f2 = new NormalFile("file2");
        NormalFile f3 = new NormalFile("file3");

        
        root.add(dir1);
        root.add(dir2);

        dir1.add(f1);
        dir1.add(f2);
        dir2.add(f3);

        
        System.out.println("Size root: " + root.size());
        NormalFile f4 = new NormalFile("file4");
        dir1.add(f4);

        System.out.println("Size root dopo aggiunta: " + root.size());

        dir1.remove("file1");
        root.remove("dir1");
        System.out.println("Size root dopo rimozione: " + root.size());
    }
}



interface File{ //  COMPONENT
    public int size();
    public String getName();
    public File getComposite();
}


class NormalFile implements File{ //  LEAF
    String name;
    int size;
    public NormalFile(String s){
        name = s;
        size = (int)(Math.random()*100);
    }
    public int size(){return size;}
    public String getName(){return name;}
    public File getComposite(){return null;}
}

class Directory implements File{ //  COMPOSITE 
    String name;
    int size;
    boolean dirty;
    List<File> dir;
    Directory parent;

    public Directory(String s, Directory p){
        name = s;
        size = 0;
        dirty = true;
        parent = p;
        dir = new ArrayList<>();
    }

    private boolean alredyExists(String s){
        return dir.stream().map(x -> x.getName()).anyMatch(x -> x.equals(s));
    }

    public boolean add(File fileToAdd){
        if(alredyExists(fileToAdd.getName())) return false;
        if(fileToAdd.getComposite() != null){
            ((Directory)fileToAdd).parent = this;
        }
        boolean added = dir.add(fileToAdd);
        if(added) invalidateCache();
        return added;
    }

    public boolean remove(String fileToRemove){
        boolean removed =  dir.removeIf(x -> x.getName().equals(fileToRemove));
        if(removed) invalidateCache();
        return removed;
    }


    public int size(){
        if(dirty){
            dirty = false;
            size =  dir.stream()
            .map(x -> x.size())
            .reduce(0,(accum, x) -> accum +x);
        }
        return size;
    }

    private void invalidateCache(){
        dirty = true;
        if(parent != null){
            parent.invalidateCache();
        }
    }

    public File getComposite(){return this;}
    public String getName(){return name;}

    
}