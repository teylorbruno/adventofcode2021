package twentytwentyone.day1;

import util.AdventUtil;

import java.util.ArrayList;
import java.util.List;

public class DayOne {

    private final List<Integer> inputList = AdventUtil.inputToListOfInteger(AdventUtil.FILE_ONE.getPath());


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

}
