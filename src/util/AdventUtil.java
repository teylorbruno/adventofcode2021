package util;

import twentytwentyone.day5.Coord;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdventUtil {

    private static final String SRC_PATH = "src/twentytwentyone/";

    //2021
    public static File FILE_ONE = new File(SRC_PATH + "day1/input.txt");
    public static final File FILE_TWO = new File(SRC_PATH + "day2/input.txt");
    public static final File FILE_THREE = new File(SRC_PATH + "day3/input.txt");
    public static final File FILE_FOUR = new File(SRC_PATH + "day4/input.txt");
    public static final String FILE_FIVE = SRC_PATH + "day5/input.txt";

    //2020
    public static final File FILE_ONE_2020 = new File("src/twentytwenty/firstday/input.txt");

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
            String line;
            while ((line = bReader.readLine()) != null) {
                inputList.add(Integer.valueOf(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputList;
    }

    public static int binaryToDecimal(String binary) throws Exception {
        return binToDecimal(binary);
    }

    public static int binaryToDecimal(Integer binary) throws Exception {
        return binToDecimal(binary.toString());
    }

    private static int binToDecimal(String binary) throws Exception {
        int decimal = 0;
        char[] charArr = binary.toCharArray();
        for (int i = charArr.length - 1; i >= 0; i--) {
            int current = Character.getNumericValue(charArr[i]);
            if (current != 1 && current != 0) {
                Logger.getAnonymousLogger().log(Level.WARNING, "Not a Binary Number");
                throw new Exception();
            }
            decimal += current * Math.pow(2, (charArr.length - 1) - i);
        }
        System.out.println(decimal);
        return decimal;
    }


    public static int decimalToBinary(Integer decimal) {
        int binary = 0;
        String numToStr = decimal.toString();
        String result = "";
        while (true) {
            result += decimal % 2 == 0 ? 0 : 1;
            decimal = (int) Math.floor(decimal / 2);
            if (decimal == 0) {
                break;
            }
        }
        System.out.println(result);
        return Integer.parseInt(result);
    }

    public static List<Coord> coordsList(String path) {
        List<Coord> inputList = null;
        try (BufferedReader bReader = new BufferedReader(new FileReader(path))) {
            inputList = new ArrayList<>();
            String line;
            while ((line = bReader.readLine()) != null) {
                String[] aux = line.split(" -> ");
                Coord coord = new Coord(
                        Integer.parseInt(aux[0].split(",")[0]),
                        Integer.parseInt(aux[0].split(",")[1]),
                        Integer.parseInt(aux[1].split(",")[0]),
                        Integer.parseInt(aux[1].split(",")[1]));
                inputList.add(coord);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputList;
    }

    public static String[][] dotTable(Coord coord) {
        String[][] table = new String[coord.getY2()-coord.getY1()+1][coord.getX2()-coord.getX1()+1];
        for (int y = 0; y < table.length; y++) {
            Arrays.fill(table[y], ".");
        }
        return table;
    }

}