package leetcode.joe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joe321 on 2017/6/11.
 */
public class StringIterator {

    private List<Character> listChar;
    private List<Integer> listInt;
    private int index = 0;
    private int indexUsed = 0;

    public StringIterator(String compressedString) {
        listChar = new ArrayList<>();
        listInt = new ArrayList<>();

        int i = 0;
        while (i<compressedString.length()) {
            char c = compressedString.charAt(i);
            listChar.add(c);
            i++;

            StringBuilder a = new StringBuilder("");
            while (i<compressedString.length() && compressedString.charAt(i) >= '0' && compressedString.charAt(i) <= '9') {
                a.append(compressedString.charAt(i));
                i++;
            }

            int count = Integer.parseInt(a.toString());
            listInt.add(count);
            //System.out.println(count);
        }
    }

    public char next() {
        if (hasNext()) {
            char ret = listChar.get(index);
            indexUsed++;
            if (indexUsed > listInt.get(index)-1) {
                index++;
                indexUsed = 0;
            }
            return ret;
        }
        return ' ';
    }

    public boolean hasNext() {
        return index < listChar.size();

    }

    public static void main(String[] args) {
        StringIterator abc1234 = new StringIterator("L10e2t1C1o1d1e1");
        while(abc1234.hasNext()) {
            System.out.println(    abc1234.next() );

        }
        System.out.println("&&" +    abc1234.next() + "&&");
    }
}
