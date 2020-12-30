package farmui.models;

import java.util.HashMap;

public class CropPrices {
    private static HashMap<String, Double>  buyMap;

    static {
        buyMap = new HashMap<>();
        buyMap.put("", 0.0);
        buyMap.put("Sunflower", 20.0);
        buyMap.put("Apple", 30.0);
        buyMap.put("Tomato", 40.0);
        buyMap.put("Cucumber", 50.0);
        buyMap.put("Bellpepper", 60.0);
        buyMap.put("Blackberry", 70.0);
    }

    public static double getBuyMap(String cropName) {
        return buyMap.get(cropName);
    }

    public static void setBuyMap(String cropName, Double price) {
        CropPrices.buyMap.put(cropName, price);
    }
}
