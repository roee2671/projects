package assignments.Ex1;

public class Ex1 {

    public static int number2Int(String num) {
        int ans = -1;
        if (!isNumber(num)) {
            return ans;
        } else if (!num.contains("b")) {
            ans = Integer.parseInt(num);
        } else {
            String sum = num.substring(0, num.length() - 2);

            char[] c = num.toCharArray();
            int base = 0;
            int last = c.length - 1;
            if (c[last] >= '2' && c[last] <= '9') {
                base += c[last] - '0';
            } else {
                base += c[last] - 'A' + 10;
            }
            ans = toDecimal(sum, base);
        }
        return ans;
    }

    public static int toDecimal(String num, int base) {
        int ans = 0;
        if (num == "0") {
            return ans;
        }
        char[] c = num.toCharArray();
        int last = c.length - 1;
        for (int i = 0; i < c.length; i++) {
            if (c[last - i] >= 'A' && c[last - i] <= 'G') {
                ans = ans + ((c[last - i] - 'A' + 10) * (int) Math.pow(base, i));
            } else {
                ans = ans + ((c[last - i] - '0') * (int) Math.pow(base, i));
            }
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
                        if (!("0123456789ABCDEF".contains(String.valueOf(c[i]))) || c[i] >= c[last]) {
                            ans = false;
                            break;
                        }
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
