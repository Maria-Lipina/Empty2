package FamilyTree;

import FamilyTree.Baseable.FileData;

public class App {
    public static void main(String[] args) throws Exception {

        FileData fd = new FileData("D:\\IT\\Java\\FamilyTree\\Source.txt", "\\s\\|\\s");

        for (int i = 0; i < fd.getSize(); i++) {
            System.out.println(fd.get(i).toString());
        }

    }
}
