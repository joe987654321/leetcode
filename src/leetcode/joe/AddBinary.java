package leetcode.joe;

/**
 * Created by joe321 on 2017/7/10.
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        int carry = 0;
        StringBuilder sb = new StringBuilder("");

        int index = 0;
        while(true) {
            int tmp = carry;

            if (index < aa.length) {
                tmp += aa[aa.length-1-index] - '0';
            }
            if (index < bb.length) {
                tmp += bb[bb.length-1-index] - '0';
            }
            sb.insert(0, tmp%2);
            carry = tmp/2;
            index++;

            if (index>=aa.length && index>=bb.length) {
                if (carry == 1) {
                    sb.insert(0, 1);
                }
                break;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        AddBinary addBinary = new AddBinary();

        System.out.println(addBinary.addBinary("1010","1011"));
    }
}
