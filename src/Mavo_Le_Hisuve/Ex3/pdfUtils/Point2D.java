package Mavo_Le_Hisuve.Ex3.pdfUtils;

/** This class represents a simple 2D Point in the plane */
public class Point2D {
  public static final double EPS = 0.001;
  public static final Point2D ORIGIN = new Point2D(0, 0);
  private double _x, _y;

  public Point2D(double a, double b) {
    _x = a;
    _y = b;
  } // Standard Constructor.

  public Point2D(Point2D p) { this(p.x(), p.y()); }; // Copy Constructor

  /**
   * String Constructor: following this String structure: "-1.2,5.3" -->
   * (-1.2,5.3) ;
   */
  public Point2D(String s) {
    String[] a = s.split(",");
    _x = Double.parseDouble(a[0]);
    _y = Double.parseDouble(a[1]);
  }

  public double x() {
    return _x;
  }

  public double y() {
    return _y;
  }

  public Point2D add(Point2D p) {
    return new Point2D(p.x() + x(), p.y() + this.y());
  }

  /** Translates this point by a vector like representation of p. */
  public void move(Point2D p) {
    _x += p.x();
    _y += p.y();
  }

  public String toString() {
    return _x + "," + _y;
  }

  public double distance() {
    return this.distance(ORIGIN);
  }

  /** distance(this,p2) = Math.sqrt(dx^2 + dy^2) */
  public double distance(Point2D p2) {
    double dx = this.x() - p2.x(), dy = this.y() - p2.y();
    return Math.sqrt(dx * dx + dy * dy);
  }

  /** return true iff: this point equals to p. */
  public boolean equals(Object p) {
    if (p == null || !(p instanceof Point2D)) {
      return false;
    }
    Point2D p2 = (Point2D) p;
    return (_x == p2._x) && (_y == p2.y());
  }

  public boolean equals(Point2D p) {
    if (p == null) {
      return false;
    }
    return ((_x == p._x) && (_y == p._y));
  }

  public boolean close2equals(Point2D p2, double eps) {
    return (this.distance(p2) < eps);
  }
}
