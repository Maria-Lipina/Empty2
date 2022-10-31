package FamilyTree;

import FamilyTree.Baseable.FileData;
import FamilyTree.Node.Type;

public class App {
    public static void main(String[] args) throws Exception {

        FileData fd = new FileData("D:\\IT\\Java\\FamilyTree2.0\\Source1.txt", "\\s\\|\\s");

        for (int i = 0; i < fd.getSize(); i++) {
            System.out.println(fd.get(i).toFileString());
        }

        Node test = fd.get(0);
        System.out.println(test.getRe());
    }
}

/* TODO: (как-нибудь) для работы с csv нужно прописывать отдельный класс и подгружать внешнюю библиотеку
https://www.geeksforgeeks.org/reading-csv-file-java-using-opencsv/
Сейчас это точно не обязательно
FileData fd = new FileData("D:\\IT\\Java\\FamilyTree2.0\\source.csv", ";");

/usr/bin/env C:\\Program\ Files\\Java\\jdk-19\\bin\\java.exe --enable-preview -XX:+ShowCodeDetailsInExceptionMessages -cp D:\\IT\\Java\\FamilyTree2.0\\Family\ Tree\\bin FamilyTree.App 
*/ 