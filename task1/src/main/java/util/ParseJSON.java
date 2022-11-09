package util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import objects.Boat;

public class ParseJSON {
    private File file;
    private FileReader fileReader;
    private Gson gson;

    public void parse(String fileName) throws Exception {
        File file = new File(fileName);
        try {

            if (!file.exists()) {
                throw new Exception("File doesn't exist!");
            }
            if (!file.canRead()) {
                throw new Exception("File doesn't provide reading writes!");
            }
            if (!file.canWrite()) {
                throw new Exception("File doesn't provide writing writes!");
            }
        }
        catch (Exception e) {
            System.out.println("Error in work with file");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        this.file = file;
        this.fileReader = new FileReader(file);
        this.gson = new Gson();
    }

    public ArrayList<Boat> getCollection() {
        ArrayList<Boat> boatsArrayList = new ArrayList<Boat>();
        try {
            JsonReader reader = new JsonReader(this.fileReader);
            if (!reader.hasNext()) {
                return boatsArrayList;
            }
            Boat[] boats = this.gson.fromJson(reader, Boat[].class);
            if (boats == null || boats.length == 0) {
                return boatsArrayList;
            }
            boatsArrayList.addAll(Arrays.asList(boats));
        } catch (Exception e) {
            System.out.println("Error in getting files");
        }
        return boatsArrayList;
    }

}
