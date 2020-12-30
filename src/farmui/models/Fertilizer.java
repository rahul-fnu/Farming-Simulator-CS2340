package farmui.models;

public class Fertilizer {
    private String name;
    private int price;
    private int level;

    public Fertilizer(String name, int price, int level) {
        this.name = name;
        this.price = price;
        this.level = level;
    }
    public Fertilizer() {
        this("", 0, 0);
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    public void setLevel(int newF) {
        this.level = newF;
    }
    public int getLevel() {
        return level;
    }
}
