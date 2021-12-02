package day2;

import util.AdventUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DayTwo {


    public void plannedCourse() {
        List<String> inputList = inputToList();
        System.out.println(inputList.size());
        int hPos = 0;
        int depth = 0;
        int aim = 0;
        for (String current : inputList) {
            String[] helper = current.split(" ");
            String level = helper[0];
            int value = Integer.parseInt(helper[1]);
            final String FORWARD = "forward";
            final String DOWN = "down";
            final String UP = "up";
            switch (level) {
                case DOWN -> {
                    depth += value;
                    aim += value;
                }
                case UP -> {
                    depth -= value;
                    aim -= value;
                }
                case FORWARD -> {
                    hPos += value;
                    depth += aim * value;
                    //System.out.println(level + " " + value + "-" + " H->" + hPos + " D->" + depth + " A->" + aim);
                }
            }
        }
        System.out.println(hPos + " " + depth);
        int result = hPos * depth;
        System.out.println(result);
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
