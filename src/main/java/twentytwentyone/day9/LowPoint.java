package twentytwentyone.day9;

import java.util.Arrays;

public class LowPoint {

    private int lowPointValue;
    /**
     * first index:row
     * second index: column
     */
    private int[] position;

    public LowPoint() {
    }


    public LowPoint(int lowPointValue, int[] position) {
        this.lowPointValue = lowPointValue;
        this.position = position;
    }

    public int getLowPointValue() {
        return lowPointValue;
    }

    public void setLowPointValue(int lowPointValue) {
        this.lowPointValue = lowPointValue;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "LowPoint{" +
                "lowPointValue=" + lowPointValue +
                ", position=" + Arrays.toString(position) +
                '}';
    }
}
