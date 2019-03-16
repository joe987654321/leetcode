package leetcode.joe;

public class AdditiveNumber {
    public static void main(String[] args) {
        AdditiveNumber additiveNumber = new AdditiveNumber();
        boolean ret = additiveNumber.isAdditiveNumber("111122335588143");
        System.out.println(ret);
    }

    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) return false;

        for (int i = 0; i < num.length()-2; i++) {
            if (num.charAt(0) == '0' && i > 0) break;
            Long a = Long.parseLong(num.substring(0, i+1));
            for (int j = i+1; j < num.length()-1; j++) {
                if (num.charAt(i+1) == '0' && j > i+1) break;
                Long b = Long.parseLong(num.substring(i + 1, j + 1));
                Long c = a + b;
                String next = String.valueOf(c);
                if (!num.startsWith(next, j+1)) continue;

                Long preA = a;
                StringBuilder sb = new StringBuilder();
                sb.append(a).append(b);
                while (sb.length() < num.length()) {
                    next = String.valueOf(a + b);
                    sb.append(next);
                    b = a + b;
                    a = b - a;
                }
                a = preA; //recover
                if (num.equals(sb.toString())) return true;
            }
        }
        return false;
    }
}
