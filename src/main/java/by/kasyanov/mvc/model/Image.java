package by.kasyanov.mvc.model;

public class Image {
    private int id;
    private String src;
    private int millId;

    public Image() {
    }

    public Image(int id, String src, int millId) {
        this.id = id;
        this.src = src;
        this.millId = millId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getMillId() {
        return millId;
    }

    public void setMillId(int millId) {
        this.millId = millId;
    }
}
