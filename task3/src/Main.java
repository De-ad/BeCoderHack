import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static int countPron(String line, String pron) {
        String spaceLine = " " + line + " ";
        Pattern pattern = Pattern.compile(" " + pron + "[\\.\\!\\:\\?\\; ]");
        Matcher matcher = pattern.matcher(spaceLine);
        int count = 0;
        while(matcher.find())
            count++;
        return count;
    }
    public static boolean isEmpty(String str) {
        return str == null || str.equals("");
    }
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://se.ifmo.ru/~s335191/index.html");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream(), "UTF-8"));

        String[] pron1 = new String[]{"я", "мы"};
        String[] pron23 = new String[] {"ты", "вы", "он", "она", "оно", "они"};

/*
        String str = "он  он  он  он";

        for(int j = 0; j < 2; j++) {
            System.out.print(pron1[j] + ":" + countPron(str, pron1[j]) + "    ");
        }
        for(int j = 0; j < 6; j++) {
            System.out.print(pron23[j] + ":" + countPron(str, pron23[j]) + "    ");
        }
*/
        while (true) {
            String line = reader.readLine();
            if (line == null)
                break;
            line = line.toLowerCase();

            String subString = "";
            boolean readStart = false;
            for(int i = 0; i < line.length(); i++) {
                if(readStart && line.charAt(i) == '<') {
                    readStart = false;
                    if(!isEmpty(subString.trim())){
                        for(int j = 0; j < 2; j++) {
                           System.out.print(pron1[j] + ":" + countPron(subString, pron1[j]) + "    ");
                        }
                        for(int j = 0; j < 6; j++) {
                           System.out.print(pron23[j] + ":" + countPron(subString, pron23[j]) + "    ");
                        }
                        System.out.println("       " + subString);
                    }

                    subString = "";
                    continue;
                }
                if(readStart) {
                    subString += line.charAt(i);
                    continue;
                }
                if(line.charAt(i) == '>') {
                    readStart = true;
                }
            }
        }
    }
}
