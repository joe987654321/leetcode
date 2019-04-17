package leetcode.practice100;

public class _043MultiplyStrings {
    public static void main(String[] args) {
        _043MultiplyStrings multiplyStrings = new _043MultiplyStrings();
        String multiply = multiplyStrings.multiply("839401893401", "173489012789341");
        System.out.println(multiply);
    }

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
            return null;
        }
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int [] storage = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                storage[num1.length()+num2.length()-1-i-j] +=
                        (num1.charAt(num1.length()-1-i)-'0') * (num2.charAt(num2.length()-1-j) -'0');
            }
        }
        int carry = 0;
        for (int i = storage.length-1; i >= 0 ; i--) {
            storage[i] += carry;
            carry = storage[i]/10;
            storage[i] %= 10;
        }
        int start = 0;
        while (storage[start] == 0) start++;
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < storage.length; i++) {
            sb.append(storage[i]);
        }
        return sb.toString();
    }

    //slow
    public String multiply2(String num1, String num2) {
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
            return null;
        }
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String result = "";
        for (int i = num1.length()-1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            if (num1.charAt(i) == '0') continue;
            int carry = 0;
            for (int j = num2.length()-1; j >= 0; j--) {
                int ret = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carry;
                sb.insert(0, ret%10);
                carry = ret/10;
            }
            if (carry != 0) {
                sb.insert(0, carry);
            }
            //System.out.println(sb);
            result = addString(result, sb.toString(), num1.length()-1-i);
        }
        return result;
    }

    private String addString(String a, String b, int tailOfB) {
        if (a.isEmpty() && tailOfB == 0) {
            return b;
        }
        if (tailOfB >= a.length()) {
            StringBuilder sb = new StringBuilder(b);
            for (int i = 0; i < tailOfB-a.length(); i++) {
                sb.append('0');
            }
            sb.append(a);
            return sb.toString();
        }

        String rest = a.substring(a.length()-tailOfB);
        String mainA = a.substring(0, a.length()-tailOfB);
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int index = 0;
        while (index < mainA.length() || index < b.length()) {
            int res = carry;
            if (index < mainA.length()) {
                res += mainA.charAt(mainA.length()-1-index) - '0';
            }
            if (index < b.length()) {
                res += b.charAt(b.length()-1-index) - '0';
            }
            sb.insert(0, res%10);
            carry = res/10;
            index++;
        }
        if (carry != 0) {
            sb.insert(0, carry);
        }
        return sb + rest;
    }
}
