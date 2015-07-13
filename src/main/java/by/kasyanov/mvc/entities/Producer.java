package by.kasyanov.mvc.entities;

public class Producer implements Comparable<Producer> {
    private int id;
    private String name;

    public Producer() {
    }

    public Producer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Producer o) {
        return Integer.compare(this.id, o.id);
    }
}
