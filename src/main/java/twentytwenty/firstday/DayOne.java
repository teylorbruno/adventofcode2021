package twentytwenty.firstday;

import util.AdventUtil;

import java.util.List;

public class DayOne {

    private List<String> inputList = AdventUtil.inputToListOfString(AdventUtil.FILE_ONE_2020.getPath());
    private final int TWENTY_TWENTY = 2020;

    public void partOne() {
        int result = 0;
        for (int i = 0; i < inputList.size(); i++) {
            for (int k = i + 1; k < inputList.size(); k++) {
                int current = Integer.parseInt(inputList.get(i));
                int compare = Integer.parseInt(inputList.get(k));
                if (current + compare == TWENTY_TWENTY) {
                    result = current * compare;
                    break;
                }
            }
        }
        System.out.println(result);
    }

    public void partTwo() {
        int result = 0;
        for (int i = 0; i < inputList.size(); i++) {
            int current = Integer.parseInt(inputList.get(i));
            for (int k = i + 1; k < inputList.size(); k++) {
                int compare = Integer.parseInt(inputList.get(k));
                for (int l = k + 1; l < inputList.size(); l++) {
                    int other = Integer.parseInt(inputList.get(l));
                    if (current + compare + other == TWENTY_TWENTY) {
                        result = current * compare * other;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }

}
