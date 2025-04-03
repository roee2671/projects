package Mavo_Le_Hisuve.Ex3;

import Mavo_Le_Hisuve.Ex3.pdfUtils.Point2D;

// ans 14:
public class Ellipse {
    private Point2D p,q;
    private double n;

    public Ellipse(double xp,double yp,double xq,double yq,double n){
        this.p = new Point2D(xp,yp);
        this.q = new Point2D(xq,yq);
        this.n = n;
    }

    public Ellipse(Ellipse o){
        this.p = new Point2D(o.p);
        this.q = new Point2D(o.q);
        this.n = o.n;
    }

    public int whare(Point2D r){
        double distance = r.distance(p) + r.distance(q);
        if (distance == n) {
            return 0;
        }
        else if (distance < n) {
            return -1;
        }
        else {
            return 1;
        }
    }

    public boolean equals(Ellipse o){
        if (this.p.equals(o.p) && this.q.equals(o.q) && this.n == o.n){
            return true;
        }
        return false;
    }
}
