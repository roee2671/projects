package Mavo_Le_Hisuve.Ex2;

import Mavo_Le_Hisuve.Ex2.Compute.*;
import Mavo_Le_Hisuve.Ex2.Compute.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ex2Sheet implements Sheet {
    private Cell[][] table;

    public Ex2Sheet(int x, int y) {
        table = new SCell[x][y];
        for (int i = 0; i < x; i = i + 1) {
            for (int j = 0; j < y; j = j + 1) {
                table[i][j] = new SCell(Ex2Utils.EMPTY_CELL, this, new CellEntry(i, j));
            }
        }
        eval();
    }

    public Ex2Sheet() {
        this(Ex2Utils.WIDTH, Ex2Utils.HEIGHT);
    }

    public static boolean isNumber(String s) {
        boolean ans = true;
        try {
            double d = Double.parseDouble(s);
        } catch (Exception e) {
            ans = false;
        }
        return ans;
    }

    public static int indOfMainOp(String form) {
        int ans = -1;
        int count = 0;
        char[] c = form.toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] == ')') {
                count++;
            }
            if (c[i] == '(') {
                count--;
            }
            if (count == 0) {
                if (("+-".contains(String.valueOf(c[i])))) {
                    ans = i;
                    break;
                } else if (ans == -1 && ("*/".contains(String.valueOf(c[i])))) {
                    ans = i;
                }
            }
        }
        return ans;
    }

    public Computable compute(String s) {
        if(s == null){
            return new ComFormErr();
        }
        if (s.startsWith("=")) {
            String sFixed = s.replaceAll(" ", "");
            sFixed = sFixed.substring(1);
            return calculate(sFixed);
        }
        if (isNumber(s)) {
            return new ComNum(Double.parseDouble(s));
        }
        return new ComText(s);
    }

    public static String removeParentheses(String s) {
        if (s == null){
            return "";
        }
        breakPoint:
        while (s.startsWith("(") && s.endsWith(")")) {
            int count = 0;
            char[] c = s.toCharArray();
            for (int i = 1; i < s.length() - 1; i++) {
                if (c[i] == '(') {
                    count++;
                }
                if (c[i] == ')') {
                    count--;
                }
                if (count < 0) {
                    break breakPoint;
                }
            }
            if (count != 0) {
                break breakPoint;
            }
            s = s.substring(1, s.length() - 1);
        }
        return s;
    }

    Computable calculate(String s) {
        s = removeParentheses(s);
        int mainInd = indOfMainOp(s);
        if (mainInd == -1) {
            if (isNumber(s)) {
                double d = Double.parseDouble(s);
                return new ComExprNum(d);
            }
            CellEntry coord = new CellEntry(s);
            if (coord.getX() != -1) {
                if (!isIn(coord.getX(), coord.getY())) {
                    return new ComFormErr();
                }
                SCell theCell = (SCell) get(coord.getX(), coord.getY());
                String contain = theCell.toString();
                Computable computed = compute(contain);
                if (computed instanceof ComText) {
                    return new ComFormErr();
                }
                if (computed instanceof ComNum comNum) {
                    return new ComExprNum(comNum.getNumValue());
                }
                return computed;
            }
            return new ComFormErr();
        }
        String part1 = s.substring(0, mainInd);
        String part2 = s.substring(mainInd + 1);
        if (part1.isEmpty()) {
            if (s.charAt(mainInd) == '+' || s.charAt(mainInd) == '-') {
                part1 = "0";
            } else {
                return new ComFormErr();
            }
        }
        if (part2.isEmpty()) {
            return new ComFormErr();
        }
        Computable com1 = calculate(part1);
        Computable com2 = calculate(part2);
        if (com1 instanceof ComFormErr || com2 instanceof ComFormErr) {
            return new ComFormErr();
        }
        double num1 = ((ComExprNum) com1).getNumValue();
        double num2 = ((ComExprNum) com2).getNumValue();

        switch (s.charAt(mainInd)) {
            case '+':
                return new ComExprNum(num1 + num2);
            case '-':
                return new ComExprNum(num1 - num2);
            case '/':
                return new ComExprNum(num1 / num2);
            case '*':
                return new ComExprNum(num1 * num2);
        }
        return new ComFormErr();
    }


    public boolean canBeComputedNow(String line, int[][] depths) {
        if (!line.startsWith("=")) {
            return true;
        }
        Set<CellEntry> inners = getCellEntries(line.substring(1));
        for (CellEntry inner : inners) {
            if(!isIn(inner.getX(),inner.getY())){
                continue;
            }
            if (depths[inner.getX()][inner.getY()] == -1)
                return false;
        }
        return true;
    }

    public static Set<CellEntry> getCellEntries(String line) {
        line = removeParentheses(line);

        CellEntry cellEntry = new CellEntry(line);
        if (cellEntry.getX() != -1 && cellEntry.getY() != -1) {
            Set<CellEntry> set = new HashSet<CellEntry>();
            set.add(cellEntry);
            return set;
        }

        int opI = indOfMainOp(line);
        if (opI == -1) {
            return new HashSet<>();
        }

        Set<CellEntry> set0 = getCellEntries(line.substring(0, opI));
        Set<CellEntry> set1 = getCellEntries(line.substring(opI + 1));

        for (CellEntry ce : set0) {
            set1.add(ce);
        }

        return set1;
    }


    @Override
    public int[][] depth() {
        String bla = table[0][0].getData();
        int[][] ans = new int[width()][height()];
        for (int x = 0; x < width(); x++) {
            for (int y = 0; y < height(); y++) {
                ans[x][y] = -1;
            }
        }
        int depth = 0;
        boolean flagC = true;
        while (flagC) {
            flagC = false;
            int[][] ansCopy = new int[ans.length][];
            for (int i = 0; i < ans.length; i++) {
                ansCopy[i] = ans[i].clone();
            }
            for (int x = 0; x < width(); x++) {
                for (int y = 0; y < height(); y++) {
                    if (canBeComputedNow(get(x, y).getData(), ans) && ans[x][y] == -1) {
                        ansCopy[x][y] = depth;
                        flagC = true;
                    }
                }
            }
            depth += 1;
            ans = ansCopy;
        }
        return ans;
    }

    @Override
    public String value(int x, int y) {
        String ans = Ex2Utils.EMPTY_CELL;
        Cell c = get(x, y);
        if (c != null) {
            ans = eval(x, y);
        }
        return ans;
    }

    @Override
    public Cell get(int x, int y) {
        return table[x][y];
    }

    @Override
    public Cell get(String cords) {
        Cell ans = null;
        CellEntry cellEntry = new CellEntry(cords);
        ans = get(cellEntry.getX(), cellEntry.getY());
        return ans;
    }

    @Override
    public int width() {
        return table.length;
    }

    @Override
    public int height() {
        return table[0].length;
    }

    @Override
    public void set(int x, int y, String s) {
        Cell c = new SCell(s, this, new CellEntry(x, y));
        table[x][y] = c;
    }

    @Override
    public void eval() {
        for (int x = 0; x < width(); x++) {
            for (int y = 0; y < height(); y++) {
                eval(x, y);
            }
        }
    }

    @Override
    public boolean isIn(int xx, int yy) {
        boolean ans = xx >= 0 && xx < width() && yy >= 0 && yy < height();
        return ans;
    }

    @Override
    public void load(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName));

        for (int x = 0; x < width(); x++) {
            for (int y = 0; y < height(); y++) {
                table[x][y].setData("");
            }
        }

        for (int i = 1; i < lines.size(); i++) {
            String[] split = lines.get(i).split(",");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);

            table[x][y].setData(split[2]);
        }
    }

    @Override
    public void save(String fileName) throws IOException {
        String content = "First line: just a header line - should not be parsed.\n";

        for (int y = 0; y < height(); y++) {
            for (int x = 0; x < width(); x++) {
                SCell cell = (SCell) table[x][y];
                String line = cell.getData();
                if (line != "") {
                    content += x + "," + y + "," + line + "\n";
                }
            }
        }
        FileWriter writer = new FileWriter(fileName);
        writer.write(content);
        writer.close();
    }

    @Override
    public String eval(int x, int y) {
        int[][] d = depth();
        Cell cell = get(x, y);
        if (d[x][y] == -1) {
            cell.setType(Ex2Utils.ERR_CYCLE_FORM);
            return Ex2Utils.ERR_CYCLE;
        }
        switch (compute(cell.toString())) {
            case ComExprNum cXNum:
                cell.setType(Ex2Utils.FORM);
                return String.valueOf(cXNum.getNumValue());
            case ComNum cNum:
                cell.setType(Ex2Utils.NUMBER);
                return String.valueOf(cNum.getNumValue());
            case ComText cText:
                cell.setType(Ex2Utils.TEXT);
                return cText.text;
            case ComFormErr cFErr:
                cell.setType(Ex2Utils.ERR_FORM_FORMAT);
                return Ex2Utils.ERR_FORM;
            default:
                return "BlaBla";
        }
    }
}
