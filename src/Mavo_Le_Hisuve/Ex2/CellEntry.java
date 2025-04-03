package Mavo_Le_Hisuve.Ex2;
// Add your documentation below:

public class CellEntry implements Index2D {

    private int x;
    private int y;

    public CellEntry(int x, int y){
        this.x = x;
        this.y = y;
    }

    public CellEntry(String s){
        if (s.isEmpty()){
            this.x = -1;
            this.y = -1;
            return;
        }
        s = s.toUpperCase();
        if(Character.isAlphabetic(s.charAt(0))){
            this.x = s.charAt(0) - 'A';
        }
        else {
            this.x = -1;
            this.y = -1;
            return;
        }
        try {
            this.y = Integer.parseInt(s.substring(1));
        }catch (NumberFormatException e){
            this.y = -1;
            this.x = -1;
            return;
        }
    }

    @Override
    public String toString(){
        return Ex2Utils.ABC[x] + String.valueOf(y);
    }

    @Override
    public boolean isValid() {
        return x >= 0 && x <= 25 && y >= 0 && y <= 99;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
