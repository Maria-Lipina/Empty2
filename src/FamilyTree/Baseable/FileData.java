package FamilyTree.Baseable; //можно ли в даве так поиграться с пакетами, чтобы защищенный класс в основном пакете был так же виден в подпакетах? Джава - это пакет с пакетами, о да

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import FamilyTree.*;


public class FileData extends ListData {

    private BufferedReader fr;
    private ArrayList<String> contents;
    private String template;

    // ******
    public FileData(String filePath, String template) {

        this.template = template;
        load(filePath);
        prepareData();
    }
    // ******

    private void load (String filePath) {
        try{
            this.fr = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8));
            this.contents = (ArrayList<String>)fr.lines().collect(Collectors.toList());
            this.fr.close();
            }
            catch (IOException e) {
                this.contents.add("Файл отсутствует или имеет некорректный формат");
            }
    }

    private String[] parse(int lineNo) { // Change to private
        return Pattern.compile(this.template).split(this.contents.get(lineNo));
    }

    private void prepareData() {

        for (int i = 0; i < contents.size(); i++) {
            Node n = new Node(parse(i));
            if (((n.getWho().getFullName() != "N/A") &&
                (n.getToWhom().getFullName() != "N/A"))||
                (n.getRe() != Node.Type.undefined)) {
                    add(n);
            }
        }

    }
}
