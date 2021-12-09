package twentytwentyone.day5;

import util.AdventUtil;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class DayFive {

    public static final String ONE = "1";
    private static final String DOT = ".";
    public static final String COLUMN = "column";
    public static final String ROW = "row";
    public static final String EMPTY_STRING = "";
    List<Coord> coordsList = AdventUtil.coordsList(AdventUtil.FILE_FIVE);

    private int minX = 0;
    private int maxX = 0;
    private int minY = 0;
    private int maxY = 0;
    private int overlaps = 0;

    public void partOne() {
        findMinAndMax();
        Coord tableLimits = new Coord(minX, minY, maxX, maxY);
        String[][] table = AdventUtil.dotTable(tableLimits);
        fillTable(table, coordsList);
        writeToFile(table);
        for (String[] row : table) {
            for (String num : row) {
                if (!num.equals(DOT) && !num.equals(ONE)) {
                    overlaps++;
                }
            }
        }
        System.out.println(overlaps);
    }

    private void fillTable(String[][] table, List<Coord> coordsList) {
        for (Coord coord : coordsList) {
            String rowOrColumn = coord.getX1() == coord.getX2() ? COLUMN : (coord.getY1() == coord.getY2() ? ROW : EMPTY_STRING);
            switch (rowOrColumn) {
                case COLUMN -> {
                    int minY = Math.min(coord.getY1(), coord.getY2()) - 10;
                    int maxY = Math.max(coord.getY1(), coord.getY2()) - 10;
                    for (int i = minY; i <= maxY; i++) {
                        String cell = table[i][coord.getX1() - 10];
                        cell = cell.equals(DOT) ? ONE : intersection(cell);
                        table[i][coord.getX1() - 10] = cell;
                    }
                }
                case ROW -> {
                    int minX = Math.min(coord.getX1(), coord.getX2()) - 10;
                    int maxX = Math.max(coord.getX1(), coord.getX2()) - 10;
                    for (int i = minX; i <= maxX; i++) {
                        String cell = table[coord.getY1() - 10][i];
                        cell = cell.equals(DOT) ? ONE : intersection(cell);
                        table[coord.getY1() - 10][i] = cell;
                    }
                }
                default -> {
                    int yAxis = Math.abs((coord.getY1() - 10) - (coord.getY2() - 10));
                    System.out.println(coord);
                    fillDiagonal(table, coord, yAxis);
                }
            }
        }

    }

    private void fillDiagonal(String[][] table, Coord coord, int length) {
        int y = coord.getY1() - 10;
        int x = coord.getX1() - 10;
        int y1 = coord.getY2() - 10;
        int x1 = coord.getX2() - 10;
        int counter = 0;
        /*int minX = Math.min(x, x1);
        int minY = Math.min(y, y1);
        int maxX = Math.max(x, x1);
        int maxY = Math.max(y, y1);
        while (minX <= maxX && minY <= maxY) {
            String cell = table[minY][minX];
            cell = cell.equals(DOT) ? ONE : intersection(cell);
            table[minY][minX] = cell;
            minX++;
            minY++;
        }*/
        if (coord.getX1() < coord.getX2() && coord.getY1() < coord.getY2()) {
            while (counter <= length) {
                String cell = table[y + counter][x + counter];
                cell = cell.equals(DOT) ? ONE : intersection(cell);
                table[y + counter][x + counter] = cell;
                System.out.println(table[y + counter][x + counter]);
                counter++;
            }
        } else if (coord.getX1() > coord.getX2() && coord.getY1() < coord.getY2()) {
            counter = length;
            while (counter >= 0) {
                String cell = table[y + counter][x - counter];
                cell = cell.equals(DOT) ? ONE : intersection(cell);
                table[y + counter][x - counter] = cell;
                counter--;
            }
        } else if (coord.getX1() > coord.getX2() && coord.getY1() > coord.getY2()) {
            counter = length;
            while (counter >= 0) {
                String cell = table[y - counter][x - counter];
                cell = cell.equals(DOT) ? ONE : intersection(cell);
                table[y - counter][x - counter] = cell;
                counter--;
            }
        } else {
            counter = length;
            while (counter >= 0) {
                String cell = table[y - counter][x + counter];
                cell = cell.equals(DOT) ? ONE : intersection(cell);
                table[y - counter][x + counter] = cell;
                counter--;
            }
        }
    }

    private String intersection(String cell) {
        int cellValue = Integer.parseInt(cell);
        return String.valueOf(++cellValue);
    }


    private void findMinAndMax() {
        for (Coord coord : coordsList) {
            if (minX == 0) {
                minX = Math.min(coord.getX1(), coord.getX2());
            } else {
                minX = Math.min(minX, Math.min(coord.getX1(), coord.getX2()));
            }
            if (maxX == 0) {
                maxX = Math.max(coord.getX1(), coord.getX2());
            } else {
                maxX = Math.max(maxX, Math.max(coord.getX1(), coord.getX2()));
            }
            if (minY == 0) {
                minY = Math.min(coord.getY1(), coord.getY2());
            } else {
                minY = Math.min(minY, Math.min(coord.getY1(), coord.getY2()));
            }
            if (maxY == 0) {
                maxY = Math.max(coord.getY1(), coord.getY2());
            } else {
                maxY = Math.max(maxY, Math.max(coord.getY1(), coord.getY2()));
            }

        }
    }

    private void writeToFile(String[][] table) {
        try (BufferedWriter writer = new BufferedWriter(new PrintWriter("src/twentytwentyone/day5/output.txt"))) {
            for (String[] row : table) {
                for (String cell : row) {
                    writer.write(cell);
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
