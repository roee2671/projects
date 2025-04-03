package Mavo_Le_Hisuve.Ex3.pdfUtils;

public interface GeoShape {
  /** Computes if the point (ot) falls inside this (closed) shape. */
  public boolean contains(Point2D ot);

  /** Computes the area of this shape */
  public double area();

  /** Computes the perimeter of this shape. */
  public double perimeter();

  /**
   * Move this shape by the vector 0,0-->vec
   * Note: this method changes the inner state of the object.
   */
  public void move(Point2D vec);

  /** This method computes a new (deep) copy of this GeoShape. */
  public GeoShape copy();

  /** This method returns an String representing this shape. */
  public String toString();

  /** This method returns an inner point – within this GeoShape. */
  public Point2D innerPoint();
}
