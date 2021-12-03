package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdventUtil {

    public static final String DAY1_PATH = "C:\\Users\\bruno.domingues\\IdeaProjects\\adventOfCode2021\\src\\day1\\input.txt";
    public static final String DAY2_PATH = "C:\\Users\\bruno.domingues\\IdeaProjects\\adventOfCode2021\\src\\day2\\input.txt";
    public static final String DAY3_PATH = "C:\\Users\\bruno.domingues\\IdeaProjects\\adventOfCode2021\\src\\day3\\input.txt";


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
