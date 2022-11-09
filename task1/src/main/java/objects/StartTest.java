package objects;
import util.InputManager;


public class StartTest {


    public static void main(String[] args){
        InputManager inputManager = new InputManager();
        inputManager.print("================================================");
        inputManager.print("Please select source - console or json file name:");
        inputManager.readSource();



    }
}
