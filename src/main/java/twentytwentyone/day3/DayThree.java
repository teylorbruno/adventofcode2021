package twentytwentyone.day3;

import util.AdventUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayThree {

    private List<String> inputList = AdventUtil.inputToListOfString(AdventUtil.FILE_THREE.getPath());

    public void partOne() {
        StringBuilder gammaRate = new StringBuilder();
        StringBuilder epsilonRate = new StringBuilder();
        int countOne;
        int countZero;
        for (int i = 0; i < 12; i++) {
            countOne = 0;
            countZero = 0;
            for (int k = 0; k < inputList.size(); k++) {
                int current = Character.getNumericValue(inputList.get(k).charAt(i));
                if (current == 1) {
                    countOne++;
                } else {
                    countZero++;
                }
            }
            if (countOne > countZero) {
                gammaRate.append(1);
                epsilonRate.append(0);
            } else {
                gammaRate.append(0);
                epsilonRate.append(1);
            }
        }
        System.out.println("Day 3: Part One -> " + Integer.valueOf(gammaRate.toString(), 2) * Integer.valueOf(epsilonRate.toString(), 2));
    }

    public void partTwo() {
        int lengthOfEachString = inputList.get(0).length();
        Map<Integer, List<String>> map = determineOnesAndZeroLists(inputList, 0);
        Map<Integer, List<String>> O2Map = getO2(lengthOfEachString, map);
        Map<Integer, List<String>> CO2Map = getCO2(lengthOfEachString, map);
        result(O2Map, CO2Map);
    }

    private void result(Map<Integer, List<String>> mapOne, Map<Integer, List<String>> mapTwo) {
        int co2 = 0, o2 = 0;

        if (mapOne.get(0).size() == mapOne.get(1).size()){
            o2 = Integer.parseInt(mapOne.get(1).get(0),2);
        }

        for (List<String> list : mapTwo.values()) {
            if (!list.isEmpty()) {
                co2 = Integer.parseInt(list.get(0),2);
            }
        }
        System.out.println("Day 3: Part Two -> " + o2 * co2);
    }

    private Map<Integer, List<String>> getCO2(int lengthOfEachString, Map<Integer, List<String>> map) {
        for (int i = 1; i < lengthOfEachString; i++) {
            if (map.get(1).isEmpty() || map.get(0).isEmpty()) {
                break;
            }
            if (map.get(0).size() <= map.get(1).size()) {
                map = determineOnesAndZeroLists(map.get(0), i);
            } else {
                map = determineOnesAndZeroLists(map.get(1), i);
            }
        }
        return map;
    }

    private Map<Integer, List<String>> getO2(int lengthOfEachString, Map<Integer, List<String>> map) {
        for (int i = 1; i < lengthOfEachString; i++) {

            if (map.get(1).size() >= map.get(0).size()) {
                map = determineOnesAndZeroLists(map.get(1), i);
            } else {
                map = determineOnesAndZeroLists(map.get(0), i);
            }
        }
        return map;
    }

    private Map<Integer, List<String>> determineOnesAndZeroLists(List<String> inputList, int index) {
        Map<Integer, List<String>> map = new HashMap<>();
        List<String> ones = new ArrayList<>();
        List<String> zeros = new ArrayList<>();
        for (String s : inputList) {
            if (Character.getNumericValue(s.charAt(index)) == 1) {
                ones.add(s);
            } else {
                zeros.add(s);
            }
        }
        map.put(1, ones);
        map.put(0, zeros);
        return map;
    }
}
