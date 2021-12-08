package twentytwentyone.day6;

import util.AdventUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaySix {

    public static final int MAX_DAYS = 256;
    List<Integer> inputList = AdventUtil.stringToIntegerList(AdventUtil.FILE_SIX);

    public void result() {
        Map<Integer, Long> map = listToMap(inputList);
        System.out.println(map);
        int day = 1;
        while (day <= MAX_DAYS) {
            Long total = 0L;
            System.out.println(day);
            map = generateLanternFishes(map);
            for (Long value : map.values()) {
                total += value;
            }
            System.out.println(total);
            day++;
        }
    }

    private Map<Integer, Long> generateLanternFishes(Map<Integer, Long> map) {
        Map<Integer, Long> helpMap = new HashMap<>(map);
        Long zero = 0L;
        for (int i = 0; i <= 8; i++) {
            if (!map.containsKey(i)) {
                helpMap.put(i, 0L);
                continue;
            }
            Long value = map.get(i);
            if (i == 0) {
                zero = value;
                helpMap.put(8, value);
                helpMap.put(6, map.get(6) + value);
                map.put(i, 0L);
            } else {
                helpMap.put(i - 1, map.get(i));
                if (i != 8) {
                    helpMap.put(i, 0L);
                }
            }
        }
        helpMap.put(6, helpMap.get(6) + zero);
        System.out.println(helpMap);
        return helpMap;
    }

    private Map<Integer, Long> listToMap(List<Integer> list) {
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (!map.containsKey(num)) {
                map.put(num, 1L);
                continue;
            }
            Long aux = map.get(num);
            map.replace(num, ++aux);
        }
        return map;
    }

}