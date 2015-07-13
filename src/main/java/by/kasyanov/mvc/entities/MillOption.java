package by.kasyanov.mvc.entities;

public class MillOption {
    private int id;
    private String name;
    private int millId;

    public MillOption() {
    }

    public MillOption(int id, String name, int millId) {
        this.id = id;
        this.name = name;
        this.millId = millId;
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

    public int getMillId() {
        return millId;
    }

    public void setMillId(int millId) {
        this.millId = millId;
    }
}
