package util;

import objects.Boat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;


public class InputManager {
    private static Scanner scanner;
    private ParseJSON parser;
    private Validator validator;

    public InputManager(){
        scanner = new Scanner(System.in);
        parser = new ParseJSON();
        validator = new Validator();
    }

    public void print(String str){
        System.out.println(str);
    }

    public static String read(){
        String str = scanner.nextLine();
        return str;
    }

    public void readSource() throws Exception {
        String str = scanner.nextLine();
        print("================================================");
        if (str.trim().equals("console")){
            Boat boat = boatCreator();
            testBoat(boat);
        }
        else{
            ArrayList<Boat> boats = parser.parse(str);
            for (Boat boat : boats){
                testBoat(boat);
                }
            }
    }

    public void testBoat(Boat boat){
        TestBoat testBoat = new TestBoat();
        testBoat.test(boat);
    }

    public Boat boatCreator(){
        System.out.println("Enter area of boat:");
        int area = validator.checkInt(read());
        System.out.println("Enter is there a fence (true/false):");
        boolean fence = validator.checkBoolean(read());
        System.out.println("Enter material:");
        String material = read();
        System.out.println("Enter is there a stabilization (true/false):");
        boolean stabilization = parseBoolean(read());
        System.out.println("Enter is there door that is suitable for average horse (true/false):");
        boolean door = validator.checkBoolean(read());
        System.out.println("Enter power source:");
        String power = read();
        System.out.println("Enter is there a place for human to drive boat (true/false):");
        boolean capacity = validator.checkBoolean(read());
        return new Boat(area, fence, material, stabilization, door, power, capacity);
    }
}
