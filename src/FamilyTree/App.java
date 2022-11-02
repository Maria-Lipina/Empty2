package FamilyTree;

import FamilyTree.Baseable.FileData;
import FamilyTree.Node.Type;

public class App {
    public static void main(String[] args) throws Exception {

        FileData fd = new FileData("D:\\IT\\Java\\FamilyTree\\Source.txt", "\\s\\|\\s");        
    }
}

/* TODO: (как-нибудь) для работы с csv лучше прописывать отдельный класс и подгружать внешнюю библиотеку. Сейчас это точно не обязательная сложность


TODO: очевидно, пока в Node не прописан метод equals для сравнения двух объектов-экземпляров, при функции getInd будет выдавать -1 и метод remove будет работать неправильно
*/ 