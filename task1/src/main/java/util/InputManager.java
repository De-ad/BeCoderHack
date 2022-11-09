package util;

import objects.Boat;

import java.util.Scanner;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

public class InputManager {
    private static Scanner scanner;

    public InputManager(){
        scanner = new Scanner(System.in);
    }

    public void print(String str){
        System.out.println(str);
    }

    public static String read(){
        String str = scanner.nextLine();
        return str;
    }

    public void readSource(){
        String str = scanner.nextLine();
        print("================================================");
        if (str.trim().equals("console")){
            Boat boat = boatCreator();
            testBoat(boat);

        }

    }

    public void testBoat(Boat boat){
        TestBoat testBoat = new TestBoat();
        testBoat.test(boat);

    }

    public static Boat boatCreator(){
        System.out.println("Enter area of boat:");
        int area = parseInt(read());
        System.out.println("Enter is there a fence (true/false):");
        boolean fence = parseBoolean(read());
        System.out.println("Enter material:");
        String material = read();
        System.out.println("Enter is there a stabilization (true/false):");
        boolean stabilization = parseBoolean(read());
        System.out.println("Enter is there door that is suitable for average horse (true/false):");
        boolean door = parseBoolean(read());
        System.out.println("Enter power source:");
        String power = read();
        System.out.println("Enter is there a place for human to drive boat (true/false):");
        boolean capacity = parseBoolean(read());
        return new Boat(area, fence, material, stabilization, door, power, capacity);
    }
}
