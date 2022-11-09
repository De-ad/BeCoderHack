package util;

import objects.Boat;
import objects.Material;
import objects.PowerSource;

public class TestBoat {
    private final int MAX_AREA = 1000;
    private final int MIN_AREA = 3;
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RESET = "\u001B[0m";
    private Boolean result = true;
    private Calculator calculator;

    TestBoat(){
        this.calculator = new Calculator();
    }

    public void test(Boat boat){
        printMessage("Testing boat №" + boat.getId());
        testArea(boat.getArea());
        testFence(boat.isHasFence());
        testMaterial(boat.getMaterial());
        testDoorWidth(boat.isDoorWidth());
        testHumanCapacity(boat.isHumanCapacity());
        testStabilization(boat.isStabilization());
        testPower(boat.getPower());
        if (result){
            printMessage("Boat №"+ boat.getId() + "successfully passed the test!");
            double efficiency = calculator.countEfficiency(boat);
            printMessage("The efficiency equals " + efficiency);
            printResult(efficiency > 0.5
            ? "Boat will likely to cross river"
            : "Boat will hardly cross river ");
        }

    }
    public void printMessage(String message){
        System.out.println(ANSI_GREEN
                + message
                + ANSI_RESET);
    }

    public void printResult(String message){
        System.out.println(ANSI_RED
                + message
                + ANSI_RESET);
    }

    public void testMaterial(String material){
        printMessage("Testing material...");
        printResult(Material.contains(material)
                ? "OK"
                : "Material is not suitable for boat");
        result = result && Material.contains(material);
    }
    public void testStabilization(Boolean stabilization){
        printMessage("Testing stabilization...");
        printResult(stabilization
                ? "OK"
                : "Boat is not suitable for river flow");
        result = result && stabilization;
    }
    public void testDoorWidth(Boolean doorWidth){
        printMessage("Testing width of door...");
        printResult(doorWidth
                ? "OK"
                : "Door width is too small for average horse");
        result = result && doorWidth;
    }
    public void testPower(String power){
        printMessage("Testing power source...");
        printResult(PowerSource.contains(power)
                ? "OK"
                : "Power source is not valid");
        result = result && PowerSource.contains(power);
    }

    public void testHumanCapacity(Boolean humanCapacity){
        printMessage("Testing human capacity...");
        printResult(humanCapacity
                ? "OK"
                : "Should be place for at least one human");
        result = result && humanCapacity;
    }
    public void testArea(int area){
        printMessage("Testing area value...");
        printResult(area > MIN_AREA
                ? (area < MAX_AREA ? "OK" : "Area is bigger than maximum")
                : "Area is smaller than minimum");
        result = result && (area > MIN_AREA) && (area < MAX_AREA);
    }
    public void testFence(boolean hasFence){
        printMessage("Testing fence...");
        printResult(hasFence
                ? "OK"
                : "Should be fence to bind horse");
        result = result && hasFence;
    }

}
