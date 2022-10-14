package FamilyTree.Baseable;

import java.util.ArrayList;
import FamilyTree.*;

public class ListData implements Baseable<Node> {

    private ArrayList<Node> base;

    public ListData() {
        this.base = new ArrayList<>();
    }

    @Override
    public void add(Node n) {
        this.base.add(n);
        
    }

    @Override
    public void remove(Node n) {
        this.base.remove(n);  
    }

    @Override
    public Node get(int ind) {
        return this.base.get(ind);    
    }

    @Override
    public void change(Node n, Node m) {
        this.base.set(this.base.indexOf(n), m);
    }

    @Override
    public int getSize() {
        return this.base.size();
        
    }
    
}
