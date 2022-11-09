package util;

import objects.Boat;
import objects.Material;
import objects.PowerSource;

import static util.TextPrintManager.printGreenText;
import static util.TextPrintManager.printRedText;

public class TestBoat {
    private final int MAX_AREA = 1000;
    private final int MIN_AREA = 3;
    private Boolean result = true;
    private final Calculator calculator;

    TestBoat(){
        this.calculator = new Calculator();
    }

    public void test(Boat boat){
        printGreenText("Testing boat №" + boat.getId());
        testArea(boat.getArea());
        testFence(boat.isHasFence());
        testMaterial(boat.getMaterial());
        testDoorWidth(boat.isDoorWidth());
        testHumanCapacity(boat.isHumanCapacity());
        testStabilization(boat.isStabilization());
        testPower(boat.getPower());
        if (result){
            printGreenText("Boat №"+ boat.getId() + " successfully passed the test!");
            double efficiency = calculator.countEfficiency(boat);
            printGreenText("The efficiency equals " + efficiency);
            printRedText(efficiency > 0.5
            ? "Boat will likely cross river"
            : "Boat will hardly cross river ");
        }
        else{
            printRedText("Boat №"+ boat.getId() + " failed the test!");
        }

    }


    public void testMaterial(String material){
        printGreenText("Testing material...");
        printRedText(Material.contains(material)
                ? "OK"
                : "Material is not suitable for boat");
        result = result && Material.contains(material);
    }
    public void testStabilization(Boolean stabilization){
        printGreenText("Testing stabilization...");
        printRedText(stabilization
                ? "OK"
                : "Boat is not suitable for river flow");
        result = result && stabilization;
    }
    public void testDoorWidth(Boolean doorWidth){
        printGreenText("Measuring width of door...");
        printRedText(doorWidth
                ? "OK"
                : "Door width is too small for average horse");
        result = result && doorWidth;
    }
    public void testPower(String power){
        printGreenText("Testing power source...");
        printRedText(PowerSource.contains(power)
                ? "OK"
                : "Power source is not valid");
        result = result && PowerSource.contains(power);
    }

    public void testHumanCapacity(Boolean humanCapacity){
        printGreenText("Checking for human capacity...");
        printRedText(humanCapacity
                ? "OK"
                : "There must be room for at least one person");
        result = result && humanCapacity;
    }
    public void testArea(int area){
        printGreenText("Measuring area value...");
        printRedText(area > MIN_AREA
                ? (area < MAX_AREA ? "OK" : "Area is bigger than maximum")
                : "Area is smaller than minimum");
        result = result && (area > MIN_AREA) && (area < MAX_AREA);
    }
    public void testFence(boolean hasFence){
        printGreenText("Checking for a fence...");
        printRedText(hasFence
                ? "OK"
                : "There must be a fence to tie horse up");
        result = result && hasFence;
    }

}
