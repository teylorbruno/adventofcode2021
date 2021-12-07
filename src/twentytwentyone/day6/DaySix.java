package twentytwentyone.day6;

import util.AdventUtil;

import java.util.LinkedList;
import java.util.List;

public class DaySix {

    public static final int MAX_DAYS = 256;
    List<Integer> inputList = AdventUtil.stringToIntegerList(AdventUtil.FILE_SIX);

    public void partOne() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        List<Integer> lanternfishList = new LinkedList<>(inputList);
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
            System.out.println(lanternfishList.size());
            listSize = lanternfishList.size();
            days++;
        }
        System.out.println(lanternfishList.size());
    }

}
