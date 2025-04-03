package Mavo_Le_Hisuve.Ex3;

import Mavo_Le_Hisuve.Ex3.pdfUtils.Parabula;

public class testNewClass {
    public static void main(String[] args) {
        try {
            Parabula p1 = new F2(1, -4, 3); // פרבולה: x^2 - 4x + 3
            Parabula p2 = new F2(2, 5, -1); // פרבולה: 2x^2 + 5x - 1

            System.out.println("p   1 at x=2: " + p1.f(2)); // מחשב ערך הפרבולה הראשונה בנקודה x=2
            System.out.println("p2 at x=-1: " + p2.f(-1)); // מחשב ערך הפרבולה השנייה בנקודה x=-1

            Parabula p3 = p1.add(p2); // פרבולה חדשה שהיא סכום של p1 ו-p2
            System.out.println("p3 coefficients: " + java.util.Arrays.toString(p3.get())); // מציג את המקדמים של p3

            System.out.println("Extrema of p1: " + p1.extream(p1)); // מציג את נקודת הקיצון של p1
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
