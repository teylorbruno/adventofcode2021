package twentytwentyone.day8;

import java.util.List;

public class Display {

    private List<String> pattern;
    private List<String> digits;

    public Display() {
    }

    public Display(List<String> pattern, List<String> digits) {
        this.pattern = pattern;
        this.digits = digits;
    }

    public List<String> getPattern() {
        return pattern;
    }

    public void setPattern(List<String> pattern) {
        this.pattern = pattern;
    }

    public List<String> getDigits() {
        return digits;
    }

    public void setDigits(List<String> digits) {
        this.digits = digits;
    }

    @Override
    public String toString() {
        return "Display{" +
                "pattern=" + pattern +
                ", digits=" + digits +
                '}';
    }
}
