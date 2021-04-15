public class RomeNumber {
    private static final char[] simbols = {'I','V','X','L','C','D','M'};

    static boolean isRomeNumber(String s) {
        s = s.toUpperCase();
        boolean result = true, buffer;
        for(char c1 : s.toCharArray()) {
            buffer = false;
            for (char c2 : simbols)
                if (c1 == c2) buffer = true;
            result = buffer;
        }
        return result;
    }

    static int decode(String s) {
        s = s.toUpperCase();
        char[] n = s.toCharArray();
        int result = 0;
        for (int i = 0; i < n.length - 1; i++) {
            if (simbolValue(n[i]) < simbolValue(n[i+1]))
                result -= simbolValue(n[i]);
            else
                result += simbolValue(n[i]);
        }
        result += simbolValue(n[n.length-1]);
        return result;
    }

    static String toRomeNumber(int n) {
        StringBuilder result = new StringBuilder();
        int value, buf;
        for (int i = simbols.length-1; i > 0; i--) {
            value = simbolValue(i);
            while (n >= value) {
                n -= value;
                result.append(simbols[i]);
            }
            buf = i % 2 == 1 ? 1 : 2;
            if (value - n <= simbolValue(i - buf)) {
                result.append(simbols[i - buf]);
                n += simbolValue(i - buf);
                result.append(simbols[i]);
                n -= simbolValue(i);
                i -= buf - 1;
            }
        }
        while (n >= 1) {
            n -= 1;
            result.append(simbols[0]);
        }
        return result.toString();
    }

    static int simbolValue(char s) {
        for (int i = 0; i < simbols.length; i++)
            if (simbols[i] == s)
                return simbolValue(i);
        return 0;
    }

    private static int simbolValue(int i) {
        return (i % 2 == 0 ? 1 : 5) * (int) Math.pow(10, i / 2); // 5 для нечётных или 1 для чётных умножается на порядок символа (1 для I или V, 10 для X и L и т.д.)
    }
}