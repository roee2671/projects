package Mavo_Le_Hisuve.Ex3.pdfUtils;

public class Circle2dErr extends Circle2D{


    public Circle2dErr(Point2D c, double r){
        super(c,r);
    }
    public double areaErr(){
        if(area() < 5){ return area()+5;}
        return area();
    }
}
