package Mavo_Le_Hisuve.Ex3.pdfUtils;
public interface Parabula {
  double f(double x);
  Parabula add(Parabula p);
  double[] get();
  double extream(Parabula p) throws Exception;
}