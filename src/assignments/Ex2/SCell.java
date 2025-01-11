package assignments.Ex2;

import assignments.Ex2.Compute.ComExprNum;
import assignments.Ex2.Compute.ComText;

public class SCell implements Cell {
    private Ex2Sheet sheet;
    private String line;
    private int type;
    private int order;

    public boolean isNumber(String text) {
        return Ex2Sheet.isNumber(text);
    }

    public boolean isText(String text) {
        return sheet.compute(text) instanceof ComText;
    }

    public boolean isForm(String text) {
        return sheet.compute(text) instanceof ComExprNum;
    }

    public double computeForm(String form) {
        if (sheet.compute(form) instanceof ComExprNum comExprNum) {
            return comExprNum.getNumValue();
        }
        return -1;
    }

    public SCell(String s,Ex2Sheet sheet,CellEntry cellEntry) {
        this.sheet = sheet;
        setData(s);
    }

    @Override
    public int getOrder() {
        return order;
    }

    //@Override
    @Override
    public String toString() {
        return getData();
    }

    @Override
    public void setData(String s) {
        line = s;
    }
    @Override
    public String getData() {
        return line;
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public void setType(int t) {
        type = t;
    }

    @Override
    public void setOrder(int t) {
        order = t;
    }
}
