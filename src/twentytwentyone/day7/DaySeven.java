package twentytwentyone.day7;

import util.AdventUtil;

import java.util.*;

public class DaySeven {

    private List<Integer> inputList = AdventUtil.stringToIntegerList(AdventUtil.FILE_SEVEN, ",");

    public void partOne() {

        Map<Integer, Integer> fuelMap = new HashMap<>();
        List<Integer> crabsPositionsList = inputList;
        for (int i = 0; i < crabsPositionsList.size(); i++) {
            int value = 0;
            for (Integer crab : crabsPositionsList) {
                int dif = Math.abs(crab - i);
                int helper = 0;
                for (int j = 1; j <= dif; j++) {
                    helper += j;
                }
                value += helper;
            }
            fuelMap.put(i, value);
        }
        List<Integer> result = new ArrayList<>(fuelMap.values());
        Collections.sort(result);
        System.out.println(result.get(0));
    }

}
