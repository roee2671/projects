package assignments.Ex2;


public class Ex2 {
    public static boolean isNumber(String s) {
        boolean ans = true;
        try {
            double d = Double.parseDouble(s);
        } catch (Exception e) {
            ans = false;
        }
        return ans;
    }

    public static boolean isText(String s) {
        boolean ans = true;
        s = s.trim();
        if (s == null || s.isEmpty() || isNumber(s) || s.startsWith("=")) {
            ans = false;
        }
        return ans;
    }

    public static boolean isForm(String s) {
        boolean ans = true;
        if (s == null) {
            ans = false;
        } else {
            s = s.replaceAll("\\s+", "");
            if (!s.startsWith("=")) {
                ans = false;
            } else {
                s = s.substring(1).trim();
                if (!s.matches("[0-9\\+\\-\\*\\/\\(\\)\\s\\.]+")) {
                    ans = false;
                } else {
                    int count = 0;
                    char[] c = s.toCharArray();
                    int last = c.length - 1;
                    if (c[0] == '/' || c[0] == '*' || c[0] == ')' || ("/*-+(".contains(String.valueOf(c[last])))) {
                        ans = false;
                    }
                    if (c[0] == '(') {
                        count++;
                    }
                    for (int i = 1; i <= last; i++) {
                        if ((("/*-+".contains(String.valueOf(c[i - 1]))) && !("0123456789(".contains(String.valueOf(c[i]))))) {
                            ans = false;
                        }
                        if(c[i - 1] == ')' && ("0123456789".contains(String.valueOf(c[i]))) || (c[i - 1] == '(' && c[i] == ')')){
                            ans = false;
                        }
                        if (c[i] == '(') {
                            count++;
                        }
                        if (c[i] == ')') {
                            count--;
                        }
                        if (count < 0) {
                            break;
                        }
                    }
                    if (count != 0) {
                        ans = false;
                    }
                }
            }
        }
        return ans;
    }

    public static int indOfMainOp(String form) {
        int ans = 0;
        int count = 0;
        char[] c = form.toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] == ')') {
                count++;
            }
            if (c[i] == '(') {
                count--;
            }
            if (count == 0) {
                if (("+-".contains(String.valueOf(c[i])))) {
                    ans = i;
                    break;
                } else if (ans == 0 && ("*/".contains(String.valueOf(c[i])))) {
                    ans = i;
                }
            }
        }
        return ans;
    }

    public static Double computeFormRec(String form) { // form: "((3))"  (((2+(3-1))))  ((((2)+(3-1))))
        double result = 0;
        while (isForm("=" + form) && form.charAt(0) == '(' && form.charAt(form.length() - 1) == ')') {
            form = form.substring(1, form.length() - 1);
        }
        if (!isForm("=" + form) && !isNumber(form)) {
            form = "(" + form + ")";
        }
        if (isNumber(form)) {
            result = Double.parseDouble(form);
            return result;
        } else {
            int opp = indOfMainOp(form); // opp: 5
            String part1 = form.substring(0, opp); // part1: (1+2)
            String part2 = form.substring(opp + 1); // part2: 2
            if (part1.isEmpty()) {
                part1 = "0";
            }
            switch (form.charAt(opp)) {
                case '+':
                    return computeFormRec(part1) + computeFormRec(part2);
                case '-':
                    return computeFormRec(part1) - computeFormRec(part2);
                case '*':
                    return computeFormRec(part1) * computeFormRec(part2);
                case '/':
                    return computeFormRec(part1) / computeFormRec(part2);
            }
        }
        return result;
    }

    public static Double computeForm(String form) { // =5*5*5*5
        double result = Double.NaN;
        if (!isForm(form)) {
            return result;
        } else {
            form = form.replaceAll("\\s+", "");
            result = computeFormRec(form.substring(1));
        }
        return result;
    }
}

