package day2;

import util.AdventUtil;

import java.util.List;

public class DayTwo {

    private final String FORWARD = "forward";
    private final String DOWN = "down";
    private final String UP = "up";
    private final List<String> inputList = AdventUtil.inputToListOfString(AdventUtil.DAY2_PATH);


    public void partOne() {
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

}
