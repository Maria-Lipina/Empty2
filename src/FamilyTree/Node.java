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

    public Node(String[] fileData) { //TODO: Как бы скрыть его от случайного пользователя?

        // TODO: Как будет время, переделать switch в обратный порядок и без break. И по одной строке для каждого кейса, потому что DRY. не забыть о маленьком if на длину массива больше 5

        this.who = new Person();
        this.re = Type.undefined;
        this.toWhom = new Person();
        switch (fileData.length) {
            case 1:
            who.setFullName(fileData[0]);
            case 2:
            who.setFullName(fileData[0]);
            who.setS(Sex.translate(fileData[1]));
                break;
            case 3:
            who.setFullName(fileData[0]);
            who.setS(Sex.translate(fileData[1]));
            re = Type.translate(fileData[2]);
                break;
            case 4:
            who.setFullName(fileData[0]);
            who.setS(Sex.translate(fileData[1]));
            re = Type.translate(fileData[2]);
            toWhom.setFullName(fileData[3]);
                break;
            default:
            who.setFullName(fileData[0]);
            who.setS(Sex.translate(fileData[1]));
            re = Type.translate(fileData[2]);
            toWhom.setFullName(fileData[3]);
            who.setS(Sex.translate(fileData[4]));
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

}
