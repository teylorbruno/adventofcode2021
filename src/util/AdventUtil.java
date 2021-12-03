package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdventUtil {

    public static File FILE_ONE = new File("src/day1/input.txt");
    public static final File FILE_TWO = new File("src/day2/input.txt");
    public static final File FILE_THREE = new File("src/day3/input.txt");


    /**
     * Creates List from the input file
     *
     * @return List of String
     */
    public static List<String> inputToListOfString(String path) {
        List<String> inputList = null;
        try (BufferedReader bReader = new BufferedReader(new FileReader(path))) {
            inputList = new ArrayList<>();
            String line;
            while ((line = bReader.readLine()) != null) {
                inputList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputList;
    }

    /**
     * Creates List from the input file
     *
     * @return List of Integers
     */
    public static List<Integer> inputToListOfInteger(String path) {
        List<Integer> inputList = null;
        try (BufferedReader bReader = new BufferedReader(new FileReader(path))) {
            inputList = new ArrayList<>();
            String line = "";
            while ((line = bReader.readLine()) != null) {
                inputList.add(Integer.valueOf(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputList;
    }

}
