package twentytwentyone.day9;

import util.AdventUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayNine {

    private final Map<Integer, List<Integer>> inputMap = AdventUtil.stringToMapOfIntegerAndIntegerList(AdventUtil.FILE_NINE);
    private List<LowPoint> lowPointsList;

    public void partOne() {
        List<LowPoint> result = new ArrayList<>();
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
        lowPointsList = result;
        int sum = 0;
        for (LowPoint point : result) {
            sum += point.getLowPointValue() + 1;
            System.out.println(point);
        }
        System.out.println(sum);
    }

    private void currentRow(List<LowPoint> result, int currentRow, List<Integer> currentList, int currentIndex, int currentNum) {
        List<Integer> previousList = inputMap.get(currentRow - 1);
        List<Integer> nextList = inputMap.get(currentRow + 1);
        if (currentIndex == 0) {
            boolean lessThanTop = currentNum < previousList.get(currentIndex);
            boolean lessThanTopNext = currentNum < previousList.get(currentIndex + 1);
            boolean lessThanNext = currentNum < currentList.get(currentIndex + 1);
            boolean lessThanBottom = currentNum < nextList.get(currentIndex);
            boolean lessThanBottomNext = currentNum < nextList.get(currentIndex + 1);
            if (lessThanNext && lessThanBottom && lessThanBottomNext && lessThanTop && lessThanTopNext) {
                result.add(new LowPoint(currentNum, new int[]{currentRow, currentIndex}));
            }
        } else if (currentIndex == currentList.size() - 1) {
            boolean lessThanTop = currentNum < previousList.get(currentIndex);
            boolean lessThanTopNPrevious = currentNum < previousList.get(currentIndex - 1);
            boolean lessThanPrevious = currentNum < currentList.get(currentIndex - 1);
            boolean lessThanBottom = currentNum < nextList.get(currentIndex);
            boolean lessThanBottomPrevious = currentNum < nextList.get(currentIndex - 1);
            if (lessThanPrevious && lessThanBottom && lessThanBottomPrevious && lessThanTopNPrevious && lessThanTop) {
                result.add(new LowPoint(currentNum, new int[]{currentRow, currentIndex}));
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
                result.add(new LowPoint(currentNum, new int[]{currentRow, currentIndex}));
            }
        }
    }

    private void firstRow(List<LowPoint> result, int currentRow, List<Integer> currentList, int currentIndex, int currentNum) {
        List<Integer> nextList = inputMap.get(currentRow + 1);
        if (currentIndex == 0) {
            boolean lessThanNext = currentNum < currentList.get(currentIndex + 1);
            boolean lessThanBottom = currentNum < nextList.get(currentIndex);
            boolean lessThanBottomNext = currentNum < nextList.get(currentIndex + 1);
            if (lessThanNext && lessThanBottom && lessThanBottomNext) {
                result.add(new LowPoint(currentNum, new int[]{currentRow, currentIndex}));
            }
        } else if (currentIndex == currentList.size() - 1) {
            boolean lessThanPrevious = currentNum < currentList.get(currentIndex - 1);
            boolean lessThanBottom = currentNum < nextList.get(currentIndex);
            boolean lessThanBottomPrevious = currentNum < nextList.get(currentIndex - 1);
            if (lessThanPrevious && lessThanBottom && lessThanBottomPrevious) {
                result.add(new LowPoint(currentNum, new int[]{currentRow, currentIndex}));
            }
        } else {
            boolean lessThanNext = currentNum < currentList.get(currentIndex + 1);
            boolean lessThanPrevious = currentNum < currentList.get(currentIndex - 1);
            boolean lessThanBottom = currentNum < nextList.get(currentIndex);
            boolean lessThanBottomNext = currentNum < nextList.get(currentIndex + 1);
            boolean lessThanBottomPrevious = currentNum < nextList.get(currentIndex - 1);
            if (lessThanNext && lessThanBottom && lessThanBottomNext && lessThanPrevious && lessThanBottomPrevious) {
                result.add(new LowPoint(currentNum, new int[]{currentRow, currentIndex}));
            }
        }
    }

    private void lastRow(List<LowPoint> result, int currentRow, List<Integer> currentList, int currentIndex, int currentNum) {
        List<Integer> previousList = inputMap.get(currentRow - 1);
        if (currentIndex == 0) {
            boolean lessThanNext = currentNum < currentList.get(currentIndex + 1);
            boolean lessThanTop = currentNum < previousList.get(currentIndex);
            boolean lessThanTopNext = currentNum < previousList.get(currentIndex + 1);
            if (lessThanNext && lessThanTop && lessThanTopNext) {
                result.add(new LowPoint(currentNum, new int[]{currentRow, currentIndex}));
            }
        } else if (currentIndex == currentList.size() - 1) {
            boolean lessThanPrevious = currentNum < currentList.get(currentIndex - 1);
            boolean lessThanTop = currentNum < previousList.get(currentIndex);
            boolean lessThanTopPrevious = currentNum < previousList.get(currentIndex - 1);
            if (lessThanPrevious && lessThanTop && lessThanTopPrevious) {
                result.add(new LowPoint(currentNum, new int[]{currentRow, currentIndex}));
            }
        } else {
            boolean lessThanNext = currentNum < currentList.get(currentIndex + 1);
            boolean lessThanPrevious = currentNum < currentList.get(currentIndex - 1);
            boolean lessThanTop = currentNum < previousList.get(currentIndex);
            boolean lessThanTopNext = currentNum < previousList.get(currentIndex + 1);
            boolean lessThanTopPrevious = currentNum < previousList.get(currentIndex - 1);
            if (lessThanNext && lessThanTop && lessThanTopNext && lessThanPrevious && lessThanTopPrevious) {
                result.add(new LowPoint(currentNum, new int[]{currentRow, currentIndex}));
            }
        }
    }

    public void partTwo() {
        Map<LowPoint, List<Integer>> basins = new HashMap<>();
        for (LowPoint lowPoint : lowPointsList) {
            findBasins(basins, inputMap, lowPoint);
        }
    }

    private void findBasins(Map<LowPoint, List<Integer>> basins, Map<Integer, List<Integer>> inputMap, LowPoint lowPoint) {
        int row = lowPoint.getPosition()[0];
        int column = lowPoint.getPosition()[1];
        int lowPointValue = inputMap.get(row).get(column);
        for (int i = lowPointValue + 1; i <= 8; i++) {

        }
    }
}
