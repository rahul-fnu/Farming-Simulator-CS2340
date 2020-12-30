package farmui.models;

import java.util.Random;

public class Plant {
    private String name;
    private double price;
    private PlantStatus status;
    private int plantedFor;
    private int waterLevel;
    private boolean pest;
    private int fertLevel;

    public Plant(String name, boolean purchased) {
        this.name = name;
        this.price = CropPrices.getBuyMap(name);
        if (purchased) {
            this.status = PlantStatus.SEED;
        } else {
            Random rand = new Random();
            PlantStatus[] temp = PlantStatus.values();
            int num = rand.nextInt(3);
            this.status = temp[num];
        }
        this.waterLevel = 3;
        this.pest = false;
        this.fertLevel = 0;
    }

    public void evaluateStatus() {
        if (this.plantedFor >= 3 && this.waterLevel > 0 && this.waterLevel < 6) {
            if (this.status == PlantStatus.SEED) {
                if (fertLevel > 0) {
                    this.status = PlantStatus.MATURE_PLANT;
                } else {
                    this.status = PlantStatus.IMMATURE_PLANT;
                }
            } else {
                this.status = PlantStatus.MATURE_PLANT;
            }
            this.plantedFor = 0;
        } else if (this.plantedFor >= 3) {
            this.status = PlantStatus.DEAD_PLANT;
        } else if (this.waterLevel > 0 && this.waterLevel < 6) {
            this.plantedFor++;
        } else {
            this.status = PlantStatus.DEAD_PLANT;
        }
        this.waterLevel--;
    }

    /**
     * convert plant info to displayable values
     * @return string of plot contents
     */
    public String toString() {
        return name + ": " + status;
    }
    public boolean getPest() {
        return pest;
    }
    public void setPest() {
        this.pest = true;
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

    /**
     * get status of plant
     * @return plant status from enum
     */
    public PlantStatus getStatus() {
        return status;
    }

    /**
     * set status of plant
     * @param status plant status from enum
     */
    public void setStatus(PlantStatus status) {
        this.status = status;
    }

    public int getPlantedFor() {
        return plantedFor;
    }

    public void setPlantedFor(int plantedFor) {
        this.plantedFor = plantedFor;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public int getFert() {
        return fertLevel;
    }

    public void setFert() {
        this.fertLevel++;
    }
}
