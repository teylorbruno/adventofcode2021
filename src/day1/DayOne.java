package day1;

import util.AdventUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DayOne {

    private final List<Integer> inputList = inputToList();


    public int partOne() {
        int count = result(0, inputList);
        System.out.println("PART ONE -> " + count);
        return count;
    }

    public int partTwo() {
        List<Integer> measurements = new ArrayList<>();
        for (int i = 0; i < inputList.size() - 2; i++) {
            int first = inputList.get(i);
            int second = inputList.get(i + 1);
            int third = inputList.get(i + 2);
            measurements.add(first + second + third);
        }
        int count = result(0, measurements);
        System.out.println("PART TWO -> " + count);
        return count;
    }

    private int result(int count, List<Integer> measurements) {
        for (int k = 0; k < measurements.size() - 1; k++) {
            int current = measurements.get(k);
            int next = measurements.get(k + 1);
            if (current < next) {
                count++;
            }
        }
        return count;
    }

    /**
     * Creates List from the input file
     *
     * @return List of Integers
     */
    private List<Integer> inputToList() {
        List<Integer> inputList = null;
        try (BufferedReader bReader = new BufferedReader(new FileReader(AdventUtil.DAY1_PATH))) {
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
