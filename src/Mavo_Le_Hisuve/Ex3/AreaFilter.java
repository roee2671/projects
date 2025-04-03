// Question 17.1
package Mavo_Le_Hisuve.Ex3;

import Mavo_Le_Hisuve.Ex3.pdfUtils.GeoShape;

public class AreaFilter implements ShapeFilter {
    GeoShape shape;

    public AreaFilter(GeoShape shape) {
      this.shape = shape;
    }

    @Override
    public boolean filter(GeoShape s) {
      return s.area() > shape.area();
    }
}
