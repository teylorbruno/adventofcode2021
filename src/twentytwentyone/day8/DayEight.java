package twentytwentyone.day8;

import util.AdventUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayEight {

    private List<Display> displayList = AdventUtil.inputToDisplayList(AdventUtil.FILE_EIGHT);
    private final String ZERO = "abcdeg";
    private final String ONE = "ab";
    private final String TWO = "acdfg";
    private final String THREE = "abcdf";
    private final String FOUR = "abef";
    private final String FIVE = "bcdef";
    private final String SIX = "bcdefg";
    private final String SEVEN = "abd";
    private final String EIGHT = "abcdefg";
    private final String NINE = "abcdef";

    public void partOne() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 0);//length 2
        map.put(4, 0);//length 4
        map.put(3, 0);//length 3
        map.put(7, 0);//length 7
        for (Display display : displayList) {
            for (String digit : display.getDigits()) {
                if (digit.length() == 2 || digit.length() == 3 ||
                        digit.length() == 4 || digit.length() == 7)
                    if (display.getPattern().contains(digit)) {
                        int count = map.get(digit.length());
                        map.replace(digit.length(), ++count);
                    }
            }
        }
        System.out.println(map);
    }

    public void partTwo() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x = 0; x < displayList.size(); x++) {

            Display display = displayList.get(x);
            System.out.println(display);

            String str = "";
            for (int i = 0; i < display.getDigits().size(); i++) {
                String digit = display.getDigits().get(i);
                if (display.getPattern().contains(digit)) {
                    switch (digit){
                        case ONE -> {str+="1";}
                        case TWO -> {str+="2";}
                        case THREE -> {str+="3";}
                        case FOUR -> {str+="4";}
                        case FIVE -> {str+="5";}
                        case SIX -> {str+="6";}
                        case SEVEN -> {str+="7";}
                        case EIGHT -> {str+="8";}
                        case NINE -> {str+="9";}
                        case ZERO -> {str+="0";}
                    }
                }
            }
            int value = !str.equals("") ? Integer.parseInt(str) : 0;
            map.put(x, value);
        }
        System.out.println(map);
        int sum = 0;
        for (Integer num: map.values()) {
            sum+=num;
        }
        System.out.println(sum);
    }

}
