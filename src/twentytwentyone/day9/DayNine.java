package twentytwentyone.day9;

import util.AdventUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DayNine {

    private final Map<Integer, List<Integer>> inputMap = AdventUtil.stringToMapOfIntegerAndIntegerList(AdventUtil.FILE_NINE);

    public void partOne() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < inputMap.size(); i++) {
            List<Integer> currentList = inputMap.get(i);
            for (int j = 0; j < currentList.size(); j++) {
                int currentNum = currentList.get(j);
                if (i == 0) {
                    firstRow(result, i, currentList, j, currentNum);
                } else if (i == inputMap.size() - 1) {
                    lastRow(result, i, currentList, j, currentNum);
                } else {
                    currentRow(result, i, currentList, j, currentNum);
                }
            }
        }
        int sum = 0;
        for (int num: result) {
            sum+=++num;
        }
        System.out.println(sum);
    }

    private void currentRow(List<Integer> result, int currentRow, List<Integer> currentList, int currentIndex, int currentNum) {
        List<Integer> previousList = inputMap.get(currentRow - 1);
        List<Integer> nextList = inputMap.get(currentRow + 1);
        if (currentIndex == 0) {
            boolean lessThanTop = currentNum < previousList.get(currentIndex);
            boolean lessThanTopNext = currentNum < previousList.get(currentIndex + 1);
            boolean lessThanNext = currentNum < currentList.get(currentIndex + 1);
            boolean lessThanBottom = currentNum < nextList.get(currentIndex);
            boolean lessThanBottomNext = currentNum < nextList.get(currentIndex + 1);
            if (lessThanNext && lessThanBottom && lessThanBottomNext && lessThanTop && lessThanTopNext) {
                result.add(currentNum);
            }
        } else if (currentIndex == currentList.size() - 1) {
            boolean lessThanTop = currentNum < previousList.get(currentIndex);
            boolean lessThanTopNPrevious = currentNum < previousList.get(currentIndex - 1);
            boolean lessThanPrevious = currentNum < currentList.get(currentIndex - 1);
            boolean lessThanBottom = currentNum < nextList.get(currentIndex);
            boolean lessThanBottomPrevious = currentNum < nextList.get(currentIndex - 1);
            if (lessThanPrevious && lessThanBottom && lessThanBottomPrevious && lessThanTopNPrevious && lessThanTop) {
                result.add(currentNum);
            }
        } else {
            boolean lessThanNext = currentNum < currentList.get(currentIndex + 1);
            boolean lessThanPrevious = currentNum < currentList.get(currentIndex - 1);
            boolean lessThanTop = currentNum < previousList.get(currentIndex);
            boolean lessThanTopNext = currentNum < previousList.get(currentIndex + 1);
            boolean lessThanTopPrevious = currentNum < previousList.get(currentIndex - 1);
            boolean lessThanBottomNext = currentNum < nextList.get(currentIndex + 1);
            boolean lessThanBottom = currentNum < nextList.get(currentIndex);
            boolean lessThanBottomPrevious = currentNum < nextList.get(currentIndex - 1);
            if (lessThanNext && lessThanTop && lessThanTopNext && lessThanPrevious && lessThanTopPrevious && lessThanBottomNext && lessThanBottom && lessThanBottomPrevious) {
                result.add(currentNum);
            }
        }
    }

    private void firstRow(List<Integer> result, int currentRow, List<Integer> currentList, int currentIndex, int currentNum) {
        List<Integer> nextList = inputMap.get(currentRow + 1);
        if (currentIndex == 0) {
            boolean lessThanNext = currentNum < currentList.get(currentIndex + 1);
            boolean lessThanBottom = currentNum < nextList.get(currentIndex);
            boolean lessThanBottomNext = currentNum < nextList.get(currentIndex + 1);
            if (lessThanNext && lessThanBottom && lessThanBottomNext) {
                result.add(currentNum);
            }
        } else if (currentIndex == currentList.size() - 1) {
            boolean lessThanPrevious = currentNum < currentList.get(currentIndex - 1);
            boolean lessThanBottom = currentNum < nextList.get(currentIndex);
            boolean lessThanBottomPrevious = currentNum < nextList.get(currentIndex - 1);
            if (lessThanPrevious && lessThanBottom && lessThanBottomPrevious) {
                result.add(currentNum);
            }
        } else {
            boolean lessThanNext = currentNum < currentList.get(currentIndex + 1);
            boolean lessThanPrevious = currentNum < currentList.get(currentIndex - 1);
            boolean lessThanBottom = currentNum < nextList.get(currentIndex);
            boolean lessThanBottomNext = currentNum < nextList.get(currentIndex + 1);
            boolean lessThanBottomPrevious = currentNum < nextList.get(currentIndex - 1);
            if (lessThanNext && lessThanBottom && lessThanBottomNext && lessThanPrevious && lessThanBottomPrevious) {
                result.add(currentNum);
            }
        }
    }

    private void lastRow(List<Integer> result, int currentRow, List<Integer> currentList, int currentIndex, int currentNum) {
        List<Integer> previousList = inputMap.get(currentRow - 1);
        if (currentIndex == 0) {
            boolean lessThanNext = currentNum < currentList.get(currentIndex + 1);
            boolean lessThanTop = currentNum < previousList.get(currentIndex);
            boolean lessThanTopNext = currentNum < previousList.get(currentIndex + 1);
            if (lessThanNext && lessThanTop && lessThanTopNext) {
                result.add(currentNum);
            }
        } else if (currentIndex == currentList.size() - 1) {
            boolean lessThanPrevious = currentNum < currentList.get(currentIndex - 1);
            boolean lessThanTop = currentNum < previousList.get(currentIndex);
            boolean lessThanTopPrevious = currentNum < previousList.get(currentIndex - 1);
            if (lessThanPrevious && lessThanTop && lessThanTopPrevious) {
                result.add(currentNum);
            }
        } else {
            boolean lessThanNext = currentNum < currentList.get(currentIndex + 1);
            boolean lessThanPrevious = currentNum < currentList.get(currentIndex - 1);
            boolean lessThanTop = currentNum < previousList.get(currentIndex);
            boolean lessThanTopNext = currentNum < previousList.get(currentIndex + 1);
            boolean lessThanTopPrevious = currentNum < previousList.get(currentIndex - 1);
            if (lessThanNext && lessThanTop && lessThanTopNext && lessThanPrevious && lessThanTopPrevious) {
                result.add(currentNum);
            }
        }
    }

}
