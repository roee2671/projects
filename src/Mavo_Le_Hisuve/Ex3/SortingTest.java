package Mavo_Le_Hisuve.Ex3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import static Mavo_Le_Hisuve.Ex3.Ex3.mySort;

public class SortingTest {

    private static String randomString(Random random, int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000};
        Random random = new Random();

        for (int size : sizes) {
            String[] array1 = new String[size];
            String[] array2 = new String[size];

            for (int i = 0; i < size; i++) {
                String str = randomString(random, 5);
                array1[i] = str;
                array2[i] = str;
            }

            Comparator<String> comp = String::compareTo;

            long start = System.currentTimeMillis();
            mySort(array1, comp);
            long mySortTime = System.currentTimeMillis() - start;

            start = System.currentTimeMillis();
            Arrays.sort(array2, comp);
            long arraysSortTime = System.currentTimeMillis() - start;

            System.out.println("Size: " + size);
            System.out.println("mySort: " + mySortTime + " ms");
            System.out.println("Arrays.sort: " + arraysSortTime + " ms");
            System.out.println();
        }
    }
}
