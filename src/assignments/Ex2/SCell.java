package assignments.Ex2;
// Add your documentation below:

public class SCell implements Cell {
    private String line;
    private int type;
    private int order;
    private Ex2Sheet sheet;
    private int posX;
    private int posY;

    public SCell(String s,int x ,int y, Ex2Sheet sheet) {
        this.posX = x;
        this.posY = y;
        this.sheet = sheet;
        setData(s);
    }

    public SCell(String s) {
        return;
    }

    @Override
    public int getOrder() {
        if(this.type == Ex2Utils.TEXT || this.type == Ex2Utils.NUMBER){
            order = 0;
        }
        else {

        }
        return order;
    }

    //@Override
    @Override
    public String toString() {
        return getData();
    }

    @Override
    public void setData(String s) {
        int t = -2;
        if (Ex2.isText(s)){ t=Ex2Utils.TEXT; }
        if (Ex2.isNumber(s)){ t=Ex2Utils.NUMBER; }
        if (Ex2.isForm(s)){ t=Ex2Utils.FORM; }
        setType(t);
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
        // Add your code here


    }
}
