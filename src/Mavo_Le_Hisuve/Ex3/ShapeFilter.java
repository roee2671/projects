package Mavo_Le_Hisuve.Ex3;

import Mavo_Le_Hisuve.Ex3.pdfUtils.GeoShape;

public interface ShapeFilter {
  public boolean filter(GeoShape s); // returns true iff s passes this Filter.
}
