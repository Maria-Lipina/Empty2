package FamilyTree;
/**
 * Person - создание персонажа. При создании указывается полное имя и пол "ж" или "м". Если пол не указать или указать неправильно, он определяется как Sex.na "not available" 
 */
public class Person {

    protected static enum Sex {
      male, 
      female, 
      na;
    
      protected static Sex translate(String ru) {
        switch (ru) {
          case "ж": return Sex.female;
          case "м": return Sex.male;
      }
      return Sex.na;
    } 
    }

    
    private String fullName;
    private Sex s;

  public Person(String fullName, String sex) {
    //TODO: здесь ещё нужна проверка, чтобы в имени содержались буквы. Только цифры и спец.символы не подойдет. 
    if (!fullName.isBlank() || fullName != "Файл отсутствует или имеет некорректный формат")
    this.fullName = fullName;
    else this.fullName = "N/А";
    this.s = Sex.translate(sex);
    }
    

    public Person(String fullName) {
      this(fullName, "");
    }

    protected Person() {
      this.fullName = "N/A";
      this.s = Sex.na;
    }

    public String getFullName() {
      return fullName;
    }
    
    public Sex getS() {
      return s;
    }

    public void setFullName(String fullName) {
      if (!fullName.isBlank()) this.fullName = fullName;
      else this.fullName = "N/A";
    }

    public void setS(Sex s) {
      this.s = s;
    }

    public String toString() {
      return String.format("<%s - %s", this.fullName, this.s);
  }

}