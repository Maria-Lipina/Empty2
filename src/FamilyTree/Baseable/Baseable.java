package FamilyTree.Baseable;
/**
 * DataBase - интерфейс для работы с источниками информации, на основе которой проводятся исследования генеалогического древа - в данном случае это файл .txt и ArrayList
 */
public interface Baseable<E> {

    void add(E ob);
    void remove(E ob);
    int getInd(E ob);
    E get(int index);
    void change(E obOld, E obNew);
    int getSize();

}