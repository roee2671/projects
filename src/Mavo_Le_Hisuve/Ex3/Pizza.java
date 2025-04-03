package Mavo_Le_Hisuve.Ex3;


import Mavo_Le_Hisuve.Ex3.pdfUtils.Circle2D;
import Mavo_Le_Hisuve.Ex3.pdfUtils.GeoShape;
import Mavo_Le_Hisuve.Ex3.pdfUtils.Point2D;

// ans 18
public class Pizza implements GeoShape {
    double startAngle;
    double endAngle;
    Circle2D circle;

    public Pizza(Circle2D circle, double startAngle,double endAngle){
        this.circle = circle;
        this.startAngle = startAngle;
        this.endAngle = endAngle;
    }

    @Override
    public boolean contains(Point2D ot) {
        double angle = Math.atan2(ot.y() - circle.getCenter().y(),ot.x() - circle.getCenter().x());
        return startAngle < angle && endAngle > angle;
    }

    @Override
    public double area() {
        return circle.area() * (endAngle-startAngle)/360;
    }

    @Override
    public double perimeter() {
        return 2 * circle.getRad() + circle.perimeter() * (endAngle-startAngle)/360;
    }

    @Override
    public void move(Point2D vec) {
         throw new UnsupportedOperationException();
    }

    @Override
    public GeoShape copy() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Point2D innerPoint() {
        return null;
    }
}
