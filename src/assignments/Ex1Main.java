package assignments;
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");

            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (num1.equals("quit")) {
                break;
            }

            System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
            num2 = sc.next();
            if (num2.equals("quit")) {
                break;
            }

            boolean isNum1Valid = Ex1.isNumber(num1);
            boolean isNum2Valid = Ex1.isNumber(num2);

            if(!isNum1Valid){
                System.err.println("ERR: num1 is in the wrong format! (" + num1 + ")");
                continue;
            }
            if(!isNum2Valid){
                System.err.println("ERR: num2 is in the wrong format! (" + num2 + ")");
                continue;
            }

            int num1value = Ex1.number2Int(num1);
            System.out.println("num1 = " + num1 + " is number: " + isNum1Valid + ", value: " + num1value);
            int num2value = Ex1.number2Int(num2);
            System.out.println("num1 = " + num2 + " is number: " + isNum2Valid + ", value: " + num2value);

            System.out.println("Enter a base for output: (a number [2,16]) ");
            int base = sc.nextInt();

        }
        //System.out.println("quiting now...");
    }
}
