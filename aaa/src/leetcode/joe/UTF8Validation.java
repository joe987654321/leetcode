package leetcode.joe;

public class UTF8Validation {
    static public boolean validUtf8(int[] data) {
        int now = 0;
        int length = data.length;
        while (now != length) {
            int first = data[now];

            //count 1
            int count = 0;
            while ((first & 0x80) == 0x80) {
                count++;
                first = first << 1;
            }

            if (count == 1 || count == 8) {
                return false; //invalid
            }
            if (count == 0) {
                now++;
            } else {
                if (now + count -1 > length-1) {
                    return false;
                }
                for (int i = now+1; i < now+count; i++) {
                    if ((data[i] & 0xC0) != 0x80) {
                        return false;
                    }
                }
                now += count;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int [] a = {235, 140, 4};
        System.out.println(validUtf8(a));
    }
}
