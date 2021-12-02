package day2;

import util.AdventUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DayTwo {

    private final String FORWARD = "forward";
    private final String DOWN = "down";
    private final String UP = "up";


    public void partOne() {
        List<String> inputList = inputToList();
        int hPos = 0;
        int depth = 0;
        for (String current : inputList) {
            String[] helper = current.split(" ");
            String level = helper[0];
            int value = Integer.parseInt(helper[1]);

            switch (level) {
                case DOWN -> {
                    depth += value;
                }
                case UP -> {
                    depth -= value;
                }
                default -> {
                    hPos += value;
                }
            }
        }
        int result = hPos * depth;
        System.out.println("Part One -> " + result);
    }

    public void partTwo() {
        List<String> inputList = inputToList();
        int hPos = 0;
        int depth = 0;
        int aim = 0;
        for (String current : inputList) {
            String[] helper = current.split(" ");
            String level = helper[0];
            int value = Integer.parseInt(helper[1]);

            switch (level) {
                case DOWN -> {
                    aim += value;
                }
                case UP -> {
                    aim -= value;
                }
                default -> {
                    hPos += value;
                    depth += aim * value;
                }
            }
        }
        int result = hPos * depth;
        System.out.println("Part Two -> " + result);
    }

    private List<String> inputToList() {
        List<String> inputList = null;
        try (BufferedReader bReader = new BufferedReader(new FileReader(AdventUtil.DAY2_PATH))) {
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


}
