package objects;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public enum Material {
    WOOD(0.75),
    DURALUMIN(0.88),
    POLYMER(0.79),
    PLASTIC(0.85);

    private final double efficiency;
    private static final Map<Material, Double> BY_EFFICIENCY = new HashMap<>();

    static {
        for (Material material : values()){
            BY_EFFICIENCY.put(material, material.efficiency);
        }
    }

    public static Material getName(String value){
        for(Material material: Material.values()){
            if (material.name().equals(value.trim().toUpperCase(Locale.ROOT))){
                return material;
            }
        }
        return null;
    }

    private Material(double efficiency){
        this.efficiency = efficiency;
    }
    public static Double valueOfEfficiency(Material material){
        return BY_EFFICIENCY.get(material);
    }
    public static boolean contains(String value){
        for(Material material: Material.values()){
            if (material.name().equals(value.trim().toUpperCase(Locale.ROOT))){
                return true;
            }
        }
        return false;
    }
}
