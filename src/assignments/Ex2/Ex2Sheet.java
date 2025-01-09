package assignments.Ex2;
import assignments.Ex2.Compute.*;

import java.io.IOException;
// Add your documentation below:

public class Ex2Sheet implements Sheet {
    private Cell[][] table;
    // Add your code here
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

    public Computable compute(String s){
        if (s.startsWith("=")){
            String sFixed = s.replaceAll(" ", "");
            sFixed = sFixed.substring(1);
            return calculate(sFixed);
        }
        if (isNumber(s)){
            return new ComNum(Double.parseDouble(s));
        }
        return new ComText(s);
    }

    Computable calculate (String s){
        breakPoint:
        while (s.charAt(0) == '(' && s.charAt(s.length()-1) == ')'){
            int count = 0;
            char[] c = s.toCharArray();
            for(int i = 1; i < s.length()-1; i++){
                if (c[i] == '(') {
                    count++;
                }
                if (c[i] == ')') {
                    count--;
                }
                if(count < 0){
                    break breakPoint;
                }
            }
            if(count != 0){
                break breakPoint;
            }
            s = s.substring(1, s.length()-1);
        }
        int mainInd = indOfMainOp(s);
        if(mainInd == -1) {
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
                    return new ComExprNum(comNum.value);
                }
                return computed;
            }
            return new ComFormErr();
        }
        String part1 = s.substring(0, mainInd);
        String part2 = s.substring(mainInd + 1);
        if(part1.isEmpty()){
            part1 = "0";
        }
        if (part2.isEmpty()){
            return new ComFormErr();
        }
        Computable com1 = calculate(part1);
        Computable com2 = calculate(part2);
        if(com1 instanceof ComFormErr || com2 instanceof ComFormErr){
            return new ComFormErr();
        }
        double num1 = ((ComExprNum) com1).numValue;
        double num2 = ((ComExprNum) com2).numValue;

        switch (s.charAt(mainInd)){
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

    // ///////////////////
    public Ex2Sheet(int x, int y) {
        table = new SCell[x][y];
        for(int i=0;i<x;i=i+1) {
            for(int j=0;j<y;j=j+1) {
                table[i][j] = new SCell(Ex2Utils.EMPTY_CELL);
            }
        }
        eval();
    }
    public Ex2Sheet() {
        this(Ex2Utils.WIDTH, Ex2Utils.HEIGHT);
    }

    @Override
    public String value(int x, int y) {
        String ans = Ex2Utils.EMPTY_CELL;
        Cell c = get(x,y);
        if(c!=null) {ans = c.toString();}
        return ans;
    }

    @Override
    public Cell get(int x, int y) {
        return table[x][y];
    }

    @Override
    public Cell get(String cords) {
        Cell ans = null;
        // Add your code here

        /////////////////////
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
        Cell c = new SCell(s);
        table[x][y] = c;
        // Add your code here

        /////////////////////
    }
    @Override
    public void eval() {
        int[][] dd = depth();
        // Add your code here

        // ///////////////////
    }

    @Override
    public boolean isIn(int xx, int yy) {
        boolean ans = xx>=0 && xx<width() && yy>=0 && yy<height();
        return ans;
    }

    @Override
    public int[][] depth() {
        int[][] ans = new int[width()][height()];

        // Add your code here


        // ///////////////////
        return ans;
    }

    @Override
    public void load(String fileName) throws IOException {
        // Add your code here

        /////////////////////
    }

    @Override
    public void save(String fileName) throws IOException {
        // Add your code here

        /////////////////////
    }

    @Override
    public String eval(int x, int y) {
        String ans = null;
        int[][] d = depth();
        if(d[x][y] == -1){
            return Ex2Utils.ERR_CYCLE;
        }
        if(get(x,y)!=null) {ans = get(x,y).toString();}
        // Add your code here

        /////////////////////
        return ans;
        }
}
