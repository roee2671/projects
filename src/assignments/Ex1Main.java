package assignments;
import java.util.Scanner;

public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";

        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();

            if (!num1.equals(quit)) {
                boolean isNum1Valid = Ex1.isNumber(num1);
                int value1 = isNum1Valid ? Ex1.number2Int(num1) : -1;

                System.out.println("num1= " + num1 + " is number: " + isNum1Valid + " , value: " + value1);

                if (isNum1Valid) {
                    System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                    num2 = sc.next();

                    if (!num2.equals(quit)) {
                        boolean isNum2Valid = Ex1.isNumber(num2);
                        int value2 = isNum2Valid ? Ex1.number2Int(num2) : -1;

                        System.out.println("num2= " + num2 + " is number: " + isNum2Valid + " , value: " + value2);

                        if (isNum2Valid) {
                            System.out.println("Enter a base for output: (a number [2,16])");
                            int base = sc.nextInt();

                            if (base == 10){
                                int decimalSum = Ex1.toDecimal(value1, 10) + Ex1.toDecimal(value2, 10);
                                int decimalProduct = Ex1.toDecimal(value1, 10) * Ex1.toDecimal(value2, 10);

                                System.out.println(num1 + " + " + num2 + " = " + decimalSum);
                                System.out.println(num1 + " * " + num2 + " = " + decimalProduct);

                                String[] numbers = {num1, num2, String.valueOf(decimalSum), String.valueOf(decimalProduct)};
                                int maxValue = Ex1.maxIndex(numbers);

                                System.out.println("Max number over [" + num1 + "," + num2 + "," + decimalSum + "," + decimalProduct + "] is: " + numbers[maxValue]);
                            }
                            else if (base >= 2 && base <= 16) {
                                String sum = Ex1.int2Number(value1 + value2, base);
                                String product = Ex1.int2Number(value1 * value2, base);

                                System.out.println(num1 + " + " + num2 + " = " + sum);
                                System.out.println(num1 + " * " + num2 + " = " + product);

                                String[] numbers = {num1, num2, String.valueOf(sum), String.valueOf(product)};
                                int maxValue = Ex1.maxIndex(numbers);

                                System.out.println("Max number over [" + num1 + "," + num2 + "," + sum + "," + product + "] is: " + Ex1.int2Number(maxValue, base));
                            } else {
                                System.out.println("ERR: Invalid base input! (" + base + ")");
                            }
                        }
                    }
                }
            }
        }
        System.out.println("quitting now...");
        sc.close();
    }
}
