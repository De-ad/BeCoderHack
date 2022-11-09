package util;

import objects.Boat;
import objects.Material;
import objects.PowerSource;

public class Calculator {
    private double efficiency;

    public double countEfficiency(Boat boat){
        double material = Material.valueOfEfficiency(Material.getName(boat.getMaterial()));
        double powerSource = PowerSource.valueOfEfficiency(PowerSource.getName(boat.getPower()));
        double area = boat.getArea() * 0.98;
        efficiency = material * powerSource * area;
        return efficiency;
    }
}
