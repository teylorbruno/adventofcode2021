package twentytwentyone.day4;

import util.AdventUtil;

import java.util.*;
import java.util.stream.Collectors;

public class DayFour {


    public static final int MINUS_ONE = -1;
    private List<String> inputList = AdventUtil.inputToListOfString(AdventUtil.FILE_FOUR.getPath());
    private int countLast = 0;

    public void partOne() {
        List<String[]> boards = splitList();
        List<Integer> randomNums = Arrays.stream(inputList.get(0).split(",")).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(randomNums);

        Map<Integer, List<int[]>> cardsMap = getIntegerListMap(boards);
        //searchForThewinningBoard(cardsMap, randomNums);
        searchForTheLastBoard(cardsMap, randomNums);
    }

    private void searchForTheLastBoard(Map<Integer, List<int[]>> cardsMap, List<Integer> randomNums) {
        int[][][] winner = new int[cardsMap.values().size()][5][5];
        initializeArray(winner);
        Map<Integer, int[][]> lastCard = new HashMap<>();
        for (int randomNum : randomNums) {
            countLast = 0;
            for (int i = 0; i < cardsMap.values().size(); i++) {
                List<int[]> arrList = cardsMap.get(i);
                for (int j = 0; j < arrList.size(); j++) {
                    int[] current = arrList.get(j);
                    for (int k = 0; k < current.length; k++) {
                        int currentNum = current[k];
                        if (randomNum == currentNum) {
                            winner[i][j][k] = currentNum;
                        }
                        if (checkRow(winner[i][j]) || checkColumn(winner[i], k)) {
                            if (!lastCard.containsKey(i)) {
                                lastCard.put(i, winner[i]);
                                System.out.println(Arrays.deepToString(winner[i]));
                                if (lastCard.size() == cardsMap.size()) {
                                    System.out.println(sumNumbers(cardsMap.get(i), winner[i]) * randomNum);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean checkcard(int[][] card) {
        boolean hasRow = false;
        boolean hasColumn = false;
        for (int[] row : card) {
            hasRow = checkRow(row);
            if (hasRow) {
                countLast++;
                return hasRow;
            }
        }
        for (int i = 0; i < card.length; i++) {
            hasColumn = checkColumn(card, i);
            if (hasColumn) {
                countLast++;
                return hasColumn;
            }
        }
        return false;
    }


    private int countMinusOnes(int[][][] current, int numOfSquares) {
        int result = 0;
        for (int[][] arr : current)
            for (int[] row : arr) {
                for (int num : row) {
                    if (num == MINUS_ONE) {
                        result++;
                    }
                }
            }
        return result;
    }

    private void searchForTheWinningBoard(Map<Integer, List<int[]>> cardsMap, List<Integer> randomNums) {
        int mapSize = cardsMap.values().size();
        int[][][] winner = new int[mapSize][5][5];
        //change 0 intial value to -1
        initializeArray(winner);
        String numbersTaken = "";
        for (int randomNum : randomNums) {
            for (int i = 0; i < cardsMap.values().size(); i++) {
                List<int[]> arrList = cardsMap.get(i);
                for (int j = 0; j < arrList.size(); j++) {
                    int[] current = arrList.get(j);
                    for (int k = 0; k < current.length; k++) {
                        int currentNum = current[k];
                        if (randomNum == currentNum) {
                            winner[i][j][k] = currentNum;
                        }
                        boolean checkRow = checkRow(winner[i][j]);
                        boolean checkColumn = checkColumn(winner[i], k);
                        if (checkColumn || checkRow) {
                            int sum = sumNumbers(cardsMap.get(i), winner[i]);
                            System.out.println(sum * currentNum);
                            return;
                        }
                    }
                }
                //System.out.println(i + " " + Arrays.deepToString(winner[i]) + " " + numbersTaken);
            }
            numbersTaken += randomNum + " ";
        }
    }

    private int sum(List<int[]> card, int[][] winArr) {
        int sum = 0;
        for (int i = 0; i < card.size(); i++) {
            int[] current = card.get(i);
            for (int j = 0; j < current.length; j++) {
                if (winArr[i][j] == MINUS_ONE) {
                    continue;
                }
                sum += card.get(i)[j];
            }
        }
        return sum;
    }

    private int sumNumbers(List<int[]> card, int[][] winArr) {
        int sum = 0;
        for (int i = 0; i < card.size(); i++) {
            int[] current = card.get(i);
            for (int j = 0; j < current.length; j++) {
                if (winArr[i][j] != MINUS_ONE) {
                    continue;
                }
                sum += card.get(i)[j];
            }
        }
        return sum;
    }

    private void initializeArray(int[][][] winner) {
        for (int i = 0; i < winner.length; i++) {
            int[][] arrList = winner[i];
            for (int j = 0; j < arrList.length; j++) {
                int[] current = arrList[j];
                Arrays.fill(current, MINUS_ONE);
            }
        }
    }

    private boolean checkRow(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num != MINUS_ONE) {
                count++;
            }
            if (count == arr.length) {
                break;
            }
        }
        return count == arr.length;
    }

    private boolean checkColumn(int[][] arr, int column) {
        int count = 0;
        for (int[] row : arr) {
            if (row[column] != MINUS_ONE) {
                count++;
            }
            if (count == arr.length) {
                break;
            }
        }
        return count == arr.length;
    }

    private List<String[]> splitList() {
        List<String[]> boards = new ArrayList<>();
        for (int i = 1; i < inputList.size(); i++) {
            String current = inputList.get(i);
            if (!current.equals("")) {
                current = current.replaceAll("\\s+", ",");
                if (current.charAt(0) == ' ' || current.charAt(0) == ',') {
                    current.substring(1);
                }
                String[] helper = current.split(", ");
                boards.add(helper);
            }
        }
        return boards;
    }

    private Map<Integer, List<int[]>> getIntegerListMap(List<String[]> boards) {
        Map<Integer, List<int[]>> cardsMap = new HashMap<>();
        List<int[]> helper = null;
        int j = 0;
        int cardKey = 0;
        for (int i = 0; i < boards.size(); i++) {
            String current = boards.get(i)[0];
            int[] currentConvertedToInt = convertStrToIntArr(current);
            if (j == 0) {
                helper = new ArrayList<>();
                helper.add(currentConvertedToInt);
                j++;
                continue;
            } else if (j > 0 && j < 5) {
                helper.add(currentConvertedToInt);
                j++;
            }
            if (j == 5) {
                j = 0;
                cardsMap.put(cardKey++, helper);
            }
        }
        return cardsMap;
    }

    private int[] convertStrToIntArr(String current) {
        String[] arr = current.split(",");
        if (arr[0].equals("")) {
            arr = current.substring(1).split(",");
        }
        int[] result = new int[5];
        for (int i = 0; i < arr.length; i++) {
            result[i] = Integer.parseInt(arr[i]);
        }
        return result;
    }


}
