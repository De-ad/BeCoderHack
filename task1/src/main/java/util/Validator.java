package util;

import static util.TextPrintManager.printRedText;

public class Validator {

    public int checkInt(String str){
        try {
            return Integer.parseInt(str);
        }
        catch (Exception e){
            printRedText("Input in not valid");
            System.exit(1);
        }
        return 0;
    }

    public boolean checkBoolean(String str){
        try {
            if(str.equalsIgnoreCase("true") || str.equalsIgnoreCase("false"))
            {return Boolean.parseBoolean(str);}
            else throw new Exception();
        }
        catch (Exception e){
            printRedText("Input in not valid");
            System.exit(1);
        }
        return false;
    }

}
