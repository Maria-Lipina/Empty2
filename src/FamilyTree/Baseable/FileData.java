package FamilyTree.Baseable;

import java.io.IOException;
import java.util.regex.Pattern;
import FamilyTree.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.nio.file.StandardOpenOption;

public class FileData extends ListData {

    private Path file;
    public ArrayList<String> contents = new ArrayList<>(); // change to private
    private String template;

    // ******
    public FileData(String filePath, String template) {

        this.template = template;
        load(filePath);
        prepareData();
    }
    // ******

    private void load(String filePath) {
        try {
            this.file = Paths.get(filePath);
            this.contents = (ArrayList<String>) Files.readAllLines(file);
        } catch (IOException e) {
            this.contents.add("Файл отсутствует или имеет некорректный формат");
        }
    }

    private String[] parse(int lineNo) {
        return Pattern.compile(this.template).split(this.contents.get(lineNo));
    }

    private void addToBase(Node n) {
        super.add(n);
    }

    private void prepareData() {

        for (int i = 0; i < contents.size(); i++) {
            Node n = new Node(parse(i));
            if (((n.getWho().getFullName() != "N/A") && (n.getToWhom().getFullName() != "N/A"))
                    || (n.getRe() != Node.Type.undefined)) {
                addToBase(n);
            }
        }

    }

    public void add(Node n) {

        super.add(n);

        String data = n.toFileString();
        this.contents.add(data);
        try {
            Files.writeString(file, data + "\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void change(Node n, Node m) {
        int index = getInd(n);
        // Такой способ основан на том, что у рабочего ArrayList и файлового всегда идентичное содержание. А что если нет? TODO: подумать над проверкой или предотвращением такого положения дел

        super.change(n, m);
        String data = m.toFileString();
        contents.set(index, data);
        try {
            Files.write(file, contents);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void remove(Node n) {
        int index = getInd(n);
        contents.remove(index);
        super.remove(n);
        try {
            Files.write(file, contents);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
