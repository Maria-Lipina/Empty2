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
    public ArrayList<String> contents = new ArrayList<>(); //change to private
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
            this.file = Paths.get(filePath);
            this.contents = (ArrayList<String>)Files.readAllLines(file);
            }
            catch (IOException e) {
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
            if (
                ((n.getWho().getFullName() != "N/A") && (n.getToWhom().getFullName() != "N/A"))
                || (n.getRe() != Node.Type.undefined)) {
                    addToBase(n);
            }
        }

    }

    // @Override
    public void add(Node n) {
        
        super.add(n);

        String data = String.format("<%s | %s | %s | %s | %s>", 
        n.getWho().getFullName(), n.getWho().getS(), 
        n.getRe(), 
        n.getToWhom().getFullName(), n.getToWhom().getS()
        );
        this.contents.add(data);
        try {
            Files.writeString(file, data+"\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }


    
}
