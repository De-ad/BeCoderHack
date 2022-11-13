package objects;
import util.InputManager;

import java.io.IOException;


public class StartTest {

    public static void main(String[] args) throws Exception {
        InputManager inputManager = new InputManager();
        inputManager.print("================================================");
        inputManager.print("Please select source - console or json file name:");
        inputManager.readSource();
    }
}
