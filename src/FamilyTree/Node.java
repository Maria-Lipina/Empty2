package FamilyTree;

import FamilyTree.Person.Sex;

/**
 * Node - связи между объектами класса Person, которые можно потом собирать вместе и сравнивать
 */

public class Node {

    public enum Type {
        mother, father, daughter, son, brother, sister, wife, husband, undefined;

        public static Type translate(String ru) {
            switch (ru) { 
                case "муж":
                    return Type.husband;
                case "жена":
                    return Type.wife;
                case "мать":
                    return Type.mother;
                case "отец":
                    return Type.father;
                case "сын":
                    return Type.son;
                case "дочь":
                    return Type.daughter;
                case "брат":
                    return Type.brother;
                case "сестра":
                    return Type.sister;
            }
            return undefined;
        }
    }

    Person who;
    Type re;
    Person toWhom;

    public Node(Person who, Type re, Person toWhom) {
        this.who = who;
        this.re = re;
        this.toWhom = toWhom;
    }
    
    public Node(Type re, Person toWhom) {
        this.who = new Person();
        this.re = re;
        this.toWhom = toWhom;
    }

    public Node(Person who, Type re) {
        this.who = who;
        this.re = re;
        this.toWhom = new Person();
    }

    public Node(String[] fileData) { //TODO: Как бы скрыть его от пользователя?

        this.who = new Person();
        this.re = Type.undefined;
        this.toWhom = new Person();

        int len = fileData.length;
        if (len>5) {
            len = 5;
        }

        switch (len) {
            case 5: 
            who.setS(Sex.translate(fileData[4]));
            case 4:
            toWhom.setFullName(fileData[3]);
            case 3:
            this.re = Type.translate(fileData[2]);
            case 2:
            who.setS(Sex.translate(fileData[1]));
            case 1:
            who.setFullName(fileData[0]);
            break;
        }
    }

    public Person getWho() {
        return who;
    }

    public Type getRe() {
        return re;
    }

    public Person getToWhom() {
        return toWhom;
    }

    
    public void setWho(Person who) { //private?
        this.who = who;
    }

    public void setRe(Type re) { //private?
        this.re = re;
    }

    public void setToWhom(Person toWhom) { //private?
        this.toWhom = toWhom;
    }

    public String toString() {
        return String.format("<%s | %s | %s>", who.getFullName(), re, toWhom.getFullName());
    }

    public String toFileString() { //как бы скрыть от пользователя?
        return String.format("<%s | %s | %s | %s | %s>", 
        this.getWho().getFullName(), this.getWho().getS(), 
        this.getRe(), 
        this.getToWhom().getFullName(), this.getToWhom().getS()
        );
    }

}
