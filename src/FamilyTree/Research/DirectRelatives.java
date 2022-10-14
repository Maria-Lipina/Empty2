package FamilyTree.Research;

import java.util.ArrayList;

import FamilyTree.Node;
import FamilyTree.Person;
import FamilyTree.Baseable.ListData;
import FamilyTree.Node.Type;

public class DirectRelatives extends Research { // объект ради объекта?

    private ArrayList<Node> res = new ArrayList<>();
    private Person root;

    public DirectRelatives(Person p, ListData source) { //Здесь нужно использовать интерфейс как тип, но как? Не разобралась пока
        
        this.root = p;
        for (int i = 0; i < source.getSize(); i++) {
            if (p == source.get(i).getWho() || p == source.get(i).getToWhom()) {
                res.add(source.get(i));
            }
        }
    }

    public String getFullToString() {

        StringBuilder sb = new StringBuilder();

        for (Node node : this.res) {
            sb.append(node.toString() + "\n");
        }

        return sb.toString();
    }

    public String getParentsToString() {

        StringBuilder sb = new StringBuilder();
        for (Node node : this.res) {
            if (node.getWho() == this.root && 
            ((node.getRe() == Type.daughter) || (node.getRe() == Type.son))) {

                sb.append(node.toString() + "\n");
            }

            if (node.getToWhom() == this.root && 
            ((node.getRe() == Type.father) || (node.getRe() == Type.mother))) {
                
                sb.append(node.toString() + "\n");
            }
        }
        return sb.toString();
    }

    public String getChildrenToString() {

        StringBuilder sb = new StringBuilder();
        for (Node node : this.res) {
            if (node.getWho() == this.root &&
                ((node.getRe() == Type.father) || (node.getRe() == Type.mother))) {
                sb.append(node.toString() + "\n");
            }

            if (node.getToWhom() == this.root && 
            ((node.getRe() == Type.son) || (node.getRe() == Type.daughter))) {
                
                sb.append(node.toString() + "\n");
            }
        }
        return sb.toString();
    }

    public String getSiblingsToString() {

        StringBuilder sb = new StringBuilder();
        for (Node node : this.res) {
            if ((node.getRe() == Type.brother) || (node.getRe() == Type.sister)) {
                sb.append(node.toString() + "\n");
            }
        }
        return sb.toString();
    }

}
