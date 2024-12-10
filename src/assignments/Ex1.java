package assignments;

public class Ex1 {

    public static int number2Int(String num) {
        int ans = -1;
        if (!isNumber(num)) {
            return ans;
        }
        char[] c = num.toCharArray();
        int sum = 0;
        int base = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'b') {
                if (c[i + 1] >= '2' && c[i + 1] <= '9') {
                    base += c[i + 1] - '0';
                } else {
                    base += c[i + 1] - 'A' + 10;
                }
                break;
            } else {
                if (c[i] >= 'A' && c[i] <= 'G') {
                    sum = sum * 10 + (c[i] - 'A' + 10);
                }
                if (c[i] >= '0' && c[i] <= '9') {
                    sum = sum * 10 + (c[i] - '0');
                }
            }
        }
        if (base == 0) {
            base = 10;
        }
        ans = toDecimal(sum, base);
        return ans;
    }

    public static int toDecimal(int num, int base) {
        int ans = 0;
        if (num == 0) {
            return ans;
        }
        for (int power = 0; num > 0; power++) {
            int digit = num % 10;
            ans += digit * (int) Math.pow(base, power);
            num = num / 10;
        }
        return ans;
    }

    public static boolean isNumber(String a) {
        boolean ans = true;
        if (a == null || a.isEmpty() || a.contains(" ")) {
            ans = false;
        } else {
            char[] c = a.toCharArray();
            int last = c.length - 1;
            int hasDigit = 0;
            int hasLetter = 0;
            if (!a.contains("b")) {
                for (char value : c) {
                    if (value < '0' || value > '9') {
                        ans = false;
                        break;
                    }
                }
            } else {
                if (last == 1 || c[last - 1] != 'b' || (c.length == 3 && c[0] == c[2]) || !"23456789ABCDEFG".contains(String.valueOf(c[last]))) {
                    ans = false;
                } else {
                    for (int i = 0; i < last - 1; i++) {
                        if ("0123456789".contains(String.valueOf(c[i]))) {
                            hasDigit = hasDigit + 1;
                        } else if ("ABCDEFG".contains(String.valueOf(c[i]))) {
                            hasLetter = hasLetter + 1;
                        } else {
                            ans = false;
                            break;
                        }
                    }
                    if (hasDigit != 0 && hasLetter != 0) {
                        ans = false;
                    }
                }
            }
        }
        return ans;
    }

    public static String int2Number(int num, int base) {
        String ans = "";
        if (num < 0 || base < 2 || base > 16) {
            return ans;
        }
        if (num == 0) {
            return "0";
        }
        String digits = "0123456789ABCDEFG";
        while (num > 0) {
            int remainder = num % base;
            ans = digits.charAt(remainder) + ans;
            num /= base;
        }
        return ans + "b" + digits.charAt(base);
    }

    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        if (number2Int(n1) != number2Int(n2)) {
            ans = false;
        }
        return ans;
    }

    public static int maxIndex(String[] arr) {
        int ans = 0;
        int maxVal = number2Int(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != null && number2Int(arr[i]) != -1) {
                int currentValue = number2Int(arr[i]);
                if (currentValue > maxVal) {
                    maxVal = currentValue;
                    ans = i;
                }
            }
        }
        return ans;
    }
}
