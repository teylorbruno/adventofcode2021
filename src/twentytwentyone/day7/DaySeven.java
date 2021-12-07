package twentytwentyone.day7;

import util.AdventUtil;

import java.util.*;

public class DaySeven {

    private List<Integer> inputList = AdventUtil.stringToIntegerList(AdventUtil.FILE_SEVEN);

    public void partOne() {

        Map<Integer, Integer> fuelMap = new HashMap<>();
        List<Integer> crabsPositionsList = inputList;
        for (int i = 0; i < crabsPositionsList.size(); i++) {
            int value = 0;
            for (Integer crab : crabsPositionsList) {
                value += Math.abs(crab - i);
            }
            fuelMap.put(i, value);
        }
        List<Integer> result = new ArrayList<>(fuelMap.values());
        Collections.sort(result);
        System.out.println(result.get(0));
    }

}
