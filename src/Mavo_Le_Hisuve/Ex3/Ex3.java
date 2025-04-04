package Mavo_Le_Hisuve.Ex3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import Mavo_Le_Hisuve.Ex3.pdfUtils.*;
import Mavo_Le_Hisuve.Ex3.pdfUtils.*;

public class Ex3 {
    public static void main(String[] args) {
        ArrayList<GeoShape> arr1 = new ArrayList<GeoShape>();
        arr1.add(new Circle2D(new Point2D(0,0),5));
        arr1.add(new Pizza(new Circle2D(new Point2D(0,0),20),50,90));
        arr1.get(0).area();
        Circle2D d = new Circle2D(new Point2D(0,0),5);
        System.out.println(d.area());



        int n = 3;
        int m = 3;
        int[][] matrix = Q1(n, m);
        System.out.println("ans 1: ");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        String str = "aaabbbcccxxyaaa";
        System.out.println("ans 2: " + q2(str));
        String s1 = "to be or not to be";
        String s2 = "be";
        System.out.println("ans 3: " + Q5(s1, s2));
        double[] arr = new double[6];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 5;
        arr[4] = 8;
        arr[5] = 9.6;
        int[] test = Q12(arr);
        System.out.println("ans 7: " + Arrays.toString(test));
        String s = "abcdcb";
        String ss = "abracadabra";
        System.out.println("ans 12 a: " + Q12(s));
        System.out.println("ans 12 b: " + Q12(ss));
    }

    // ans 1:
    public static int[][] Q1(int n, int m) {
        int[][] metrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            metrix[i][0] = 1;
        }
        for (int j = 0; j < m; j++) {
            metrix[0][j] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                metrix[i][j] = metrix[i][j - 1] + metrix[i - 1][j];
            }
        }
        return metrix;
    }

    // ans 2:
    public static String q2(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        if (str.length() == 1) {
            return str;
        }
        if (str.charAt(0) == str.charAt(1)) {
            str = str.substring(1);
            return q2(str);
        }
        String str0 = str.substring(0, 1);
        return str0 + q2(str.substring(1));
    }

    // ans 3:
    public static int Q5(String s1, String s2) {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty() || !s1.contains(s2)) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i <= s1.length() - s2.length(); i++) {
            String st1 = s1.substring(i, i + s2.length());
            if (st1.equals(s2)) {
                count++;
            }
        }
        return count;
    }

    // ans 4a 3.1:
    public static <T> boolean isSet(MyListInterface<T> l) {
        for (int i = 0; i < l.size() - 1; i++) {
            for (int j = i + 1; j < l.size(); j++) {
                if (l.get(i).equals(l.get(j)) || l.get(i) == l.get(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // ans 4a 3.2:
    public static <T> MyListInterface<T> toSet(MyListInterface<T> l) {
        if (isSet(l)) {
            return l;
        }
        MyListInterface<T> newl = new MyList<T>();
        for (int i = 0; i < l.size(); i++) {
            int count = 0;
            for (int j = i; j < l.size(); j++) {
                if (l.get(i).equals(l.get(j)) || l.get(i) == l.get(j)) {
                    count++;
                }
            }
            if (count == 1) {
                newl.addAt(l.get(i), newl.size());
            }
        }
        return newl;
    }

    // ans 4b 4.1:
    public static <T> MyListInterface<T> intersect(MyListInterface<T> l1, MyListInterface<T> l2) {
        toSet(l1);
        toSet(l2);
        MyListInterface<T> newl = new MyList<T>();
        for (int i = 0; i < l1.size(); i++) {
            for (int j = 0; j < l2.size(); j++) {
                if (l1.get(i) == l2.get(j)) {
                    newl.addAt(l1.get(i), newl.size());
                }
            }
        }
        return newl;
    }

    // ans 4b 4.2:
    public static <T> MyListInterface<T> union(MyListInterface<T> l1, MyListInterface<T> l2) {
        MyListInterface<T> newl = new MyList<T>();
        for (int i = 0; i < l1.size(); i++) {
            newl.addAt(l1.get(i), newl.size());
        }
        for (int j = 0; j < l2.size(); j++) {
            newl.addAt(l2.get(j), newl.size());
        }
        return toSet(newl);
    }

    // ans 5:
    public static <T> int Q7(MyListInterface<T> l) {
        MyListInterface<String> newl = new MyList<String>();

        for (int i = 0; i < l.size(); i++) {
            String lType = l.get(i).getClass().getSimpleName();
            if (!newl.contains(lType)) {
                newl.addAt(lType, newl.size());
            }
        }
        return newl.size();
    }

    // ans 6:
    public static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0 || n <= 1) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static Boolean Q10(int n) {
        if (n <= 29) {
            return false;
        }
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0 && isPrime(i)) {
                count++;
                n /= i;
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        return count == 3;
    }

    // ans 7:
    public static int[] Q12(double[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int start = 0, end = 0;
        int breakPoint = 0, newStart = 0;

        for (int b = 1; b < arr.length; b++) {
            if (arr[b - 1] <= arr[b]) {
                end = b;
            } else {
                if (end - start > breakPoint - newStart) {
                    newStart = start;
                    breakPoint = end;
                }
                start = b;
                end = b;
            }
        }

        if (end - start > breakPoint - newStart) {
            newStart = start;
            breakPoint = end;
        }

        int[] ans = new int[breakPoint - newStart + 1];
        for (int j = 0; j < ans.length; j++) {
            ans[j] = (int) arr[newStart + j];
        }
        return ans;
    }

    // ans 8 8.1:
    /* אם אחד העצים הוא ריק (הוא null) אז הם לא תואמים. אם שנהים ריקים אז הם תואמים.
    אחרת , נבדוק באופן רקורסיבי את השורשים של תתי-העצים (השמאלי והימני) של שני העצים אם כולם מחזירים אמת אז העצים תואמים אחרת הם לא תואמים.  *
    */
    // ans 8 8.2:
    public static boolean isOfTheSameStructure(BinaryTree<?> bt1, BinaryTree<?> bt2) {
        if (bt1 == null && bt2 == null) {
            return true;
        }
        if (bt1 == null || bt2 == null) {
            return false;
        }
        return isOfTheSameStructure(bt1.getLeft(), bt2.getLeft()) && isOfTheSameStructure(bt1.getRight(), bt2.getRight());
    }

    // ans 9:
    public static <T> int q9(BinaryTree<T> tree, int min, int max) {
        ArrayList<BinaryTree<T>> currentLevel = new ArrayList<>();
        ArrayList<BinaryTree<T>> nextLevel = new ArrayList<>();

        currentLevel.add(tree);

        int leafCount = 0;
        for (int level = 0; level < max; level++) {
            for (BinaryTree<T> node : currentLevel) {
                if (node != null) {
                    if (node.getLeft() != null) nextLevel.add(node.getLeft());
                    if (node.getRight() != null) nextLevel.add(node.getRight());

                    if (level >= min && node.getLeft() == null && node.getRight() == null) {
                        leafCount++;
                    }
                }
            }

            currentLevel = nextLevel;
            nextLevel = new ArrayList<>();
        }

        return leafCount;
    }

    // ans 10:
    public static <T> void inOrderTraversal(BinaryTree<T> bt1, ArrayList<T> leaves) {
        if (bt1 == null) {
            return;
        }
        inOrderTraversal(bt1.getLeft(), leaves);
        if (bt1.getLeft() == null && bt1.getRight() == null) {
            leaves.add(bt1.getRoot());
        }
        inOrderTraversal(bt1.getRight(), leaves);
    }

    public static <T> ArrayList<T> q10(BinaryTree<T> bt1) {
        ArrayList<T> leaves = new ArrayList<>();
        inOrderTraversal(bt1, leaves);
        return leaves;
    }
    // ans 11:
    static <T> int getHeight(BinaryTree<T> tree) {
        if (tree == null)
            return 0;

        return 1 + Math.max(getHeight(tree.getLeft()), getHeight(tree.getRight()));
    }

    public static <T> double q11(BinaryTree  bt){
        int height = getHeight(bt);
        int minHeight = (int) Math.ceil(Math.log(bt.size()+1)/Math.log(2)) - 1 ;

        return (double) height/minHeight;
    }

    // ans 12:
    public static String Q12(String s) {
        String sFixed = "";
        if (s == null || s.isEmpty()) {
            return sFixed;
        }
        int[] countChars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            countChars[s.charAt(i) - 'a'] += 1;
        }
        for (int j = 0; j < s.length(); j++) {
            if (countChars[s.charAt(j) - 'a'] == 1) {
                sFixed += s.charAt(j);
            }
        }
        return sFixed;
    }

    //ans 13:
    public static <T> void mySort(T[] p, Comparator<T> comp){
        int n = p.length;
        boolean swap = true;
        while (swap){
            swap = false;
            for (int i = 0; i < n-1; i++) {
                if (comp.compare(p[i],p[i+1]) > 0) {
                    T temp = p[i];
                    p[i] = p[i+1];
                    p[i+1] = temp;
                    swap = true;
                }
            }
            n--;
        }
    }
    // ans 16.1:
    static int numberOfRealRoots(Parabula p) {
        double[] params = p.get();
        double a = params[0];
        double b = params[1];
        double c = params[2];
        double inRoot = b * b - 2 * a * c;

        if (inRoot > 0) {
            return 2;
        } else if (inRoot == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    // ans 16.2:
    static void sort(ArrayList<Parabula> a) {

    }


    // ans 18:
    public static String[] allCodes() {
        String[] digits = {"1", "2", "3", "4", "5"};
        ArrayList<String> validCodes = new ArrayList<>();

        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < digits.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    for (int l = 0; l < digits.length; l++) {
                        if (l == i || l == j || l == k) {
                            continue;
                        }
                        String code = digits[i] + digits[j] + digits[k] + digits[l] + "#";
                        validCodes.add(code);
                    }
                }
            }
        }
        return validCodes.toArray(new String[0]);
    }

}














