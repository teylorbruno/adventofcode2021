package twentytwentyone.day6;

import util.AdventUtil;

import java.util.ArrayList;
import java.util.List;

public class DaySix {

    public static final int MAX_DAYS = 80;
    List<Integer> inputList = AdventUtil.stringToIntegerList(AdventUtil.FILE_SIX);

    public void partOne() {
        List<Integer> lanternfishList = inputList;
        int days = 1;
        int listSize = lanternfishList.size();
        while (days <= MAX_DAYS) {
            for (int i = 0; i < listSize; i++) {
                int current = lanternfishList.get(i);
                if (current == 0) {
                    lanternfishList.set(i, 6);
                    lanternfishList.add(8);
                } else {
                    lanternfishList.set(i, --current);
                }
            }
            listSize = lanternfishList.size();
            days++;
        }
        System.out.println(lanternfishList.size());
    }

}
