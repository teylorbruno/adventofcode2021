package day3;

import util.AdventUtil;

import java.util.List;

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
                if (current==1){
                    countOne++;
                }else {
                    countZero++;
                }
            }
            if (countOne > countZero){
                gammaRate.append(1);
                epsilonRate.append(0);
            }else {
                gammaRate.append(0);
                epsilonRate.append(1);
            }
        }
        System.out.println(Integer.valueOf(gammaRate.toString(),2) * Integer.valueOf(epsilonRate.toString(),2));
    }
}
