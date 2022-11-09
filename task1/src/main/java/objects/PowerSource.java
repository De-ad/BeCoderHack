package objects;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public enum PowerSource {
    MOTOR(0.95),
    OARS(0.70),
    SAIL(0.33);

    private final double efficiency;
    private static final Map<PowerSource, Double> BY_EFFICIENCY = new HashMap<>();

    static {
        for (PowerSource powerSource : values()){
            BY_EFFICIENCY.put(powerSource, powerSource.efficiency);
        }
    }

    public static PowerSource getName(String value){
        for(PowerSource powerSource : PowerSource.values()){
            if (powerSource.name().equals(value.trim().toUpperCase(Locale.ROOT))){
                return powerSource;
            }
        }
        return null;
    }

    private PowerSource(double efficiency){
        this.efficiency = efficiency;
    }
    public static Double valueOfEfficiency(PowerSource powerSource){
        return BY_EFFICIENCY.get(powerSource);
    }

    public static boolean contains(String value){
        for(PowerSource powerSource : PowerSource.values()){
            if (powerSource.name().equals(value.trim().toUpperCase(Locale.ROOT))){
                return true;
            }
        }
        return false;
    }
}


