package farmui.models;
public class Pesticide {
    private String name;
    private double price;
    /**
    Three args constructor
    @param name String name
    @param price double price
    */
    public Pesticide(String name, double price) {
        this.name = name;
        this.price = price;
    }
    /**
    Default no args constructor
    */
    public Pesticide() {
        this.name = "";
        this.price = 0;
    }

    /**
     * get name of plant
     * @return name of plant
     */
    public String getName() {
        return name;
    }

    /**
     * set name of plant
     * @param name name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get price of plant
     * @return price of plant
     */
    public double getPrice() {
        return price;
    }

    /**
     * set price of plant
     * @param price price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
}


