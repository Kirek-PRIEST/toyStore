package Store.toys;

public class Toy {
    private int id;
    private String name;
    private int count;
    private int value;


    public Toy(int id, String name, int count, int value) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.value = value;
    }

    public Toy() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("ID = %s \n" +
                "Название = %s\n" +
                "Количество = %s\n" +
                "Частота выпадения = %s", id, name, count, value) +
                "\n \n";
    }
}
