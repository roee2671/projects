// ans 17.2
package Mavo_Le_Hisuve.Ex3;

import Mavo_Le_Hisuve.Ex3.pdfUtils.GeoShape;
import Mavo_Le_Hisuve.Ex3.pdfUtils.Point2D;

// ans 17.2
public class PointsFilter implements ShapeFilter {
  Point2D[] filterPoints;

  public PointsFilter(Point2D[] points) {
    this.filterPoints = points;
  }

  @Override
  public boolean filter(GeoShape s) {
    for (int i = 0; i < filterPoints.length; i++)
      if (!s.contains(filterPoints[i])) {
        return false;
      }
    return true;
  }
}
