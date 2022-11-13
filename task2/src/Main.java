import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {
    public static boolean findH2(String str) {

        boolean headerDetected = false;
        boolean insideBrace = false;


        boolean starComment = false;

        String currentInsideBrace = "";

        for(int i = 0; i < str.length(); i++) {


            if(str.startsWith("/*", i)){
                starComment = true;
                continue;
            }
            if(str.startsWith("*/", i)){
                i++;
                starComment = false;
                continue;
            }


            if(starComment)
                continue;
            //h2 detection
            if(!insideBrace && str.startsWith("h2", i)
                    && (str.charAt(i+2) == ' ' || str.charAt(i+2) == '{' || str.charAt(i+2) == ',' || (str.charAt(i+2) == '\n')) //checking if next symbol is valid or its the last symbol
            )
            {
                if(i == 0){//checking if previous symbol is valid or if theres no previous symbol
                    headerDetected = true;
                } else if ((str.charAt(i-1) == ' ') || (str.charAt(i-1) == ',') || (str.charAt(i-1) == '\n')) {
                    headerDetected = true;
                }
                continue;
            }


            //detection of content inside figure braces
            if(headerDetected && str.charAt(i) == '{') {
                insideBrace = true;
                continue;
            }
            if(insideBrace) {
                if(str.charAt(i) == '}') {
                    //System.out.println("FOUND: " + currentInsideBrace);
                    if(currentInsideBrace.contains("color:"))
                        return true;

                    headerDetected = false;
                    insideBrace = false;
                    currentInsideBrace = "";

                    continue;
                }
                currentInsideBrace += str.charAt(i);
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        File[] listOfFiles = new File(".").listFiles();




        for (File file : listOfFiles) {
            if(!file.getName().endsWith(".css"))
                continue;

            String oneFileInfo = String.join("\n", Files.readAllLines(file.toPath()));
            System.out.println(file.getName() + "     " + (findH2(oneFileInfo)?"changes h2 color":"does not change h2 color"));
        }
    }
}
