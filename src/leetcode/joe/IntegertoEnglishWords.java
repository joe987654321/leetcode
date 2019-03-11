package leetcode.joe;

public class IntegertoEnglishWords {
    public static void main(String[] args) {
        IntegertoEnglishWords integertoEnglishWords = new IntegertoEnglishWords();
        String s = integertoEnglishWords.numberToWords(12345);
        System.out.println(s);
    }

    private static String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static String[] elevens = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        int count = 1;
        while (num != 0) {
            int parseNum = num % 1000;
            if (parseNum > 0) {
                if (count == 2) sb.insert(0, "Thousand ");
                if (count == 3) sb.insert(0, "Million ");
                if (count == 4) sb.insert(0, "Billion ");

                if (parseNum % 100 >= 20 || parseNum % 100 <= 10) {
                    if (parseNum % 10 != 0) {
                        sb.insert(0, ones[parseNum % 10] + " ");
                    }
                    parseNum /= 10;

                    if (parseNum % 10 != 0) {
                        sb.insert(0, tens[parseNum % 10] + " ");
                    }
                    parseNum /= 10;
                } else {
                    sb.insert(0, elevens[parseNum % 100 - 10] + " ");
                    parseNum /= 100;
                }

                if (parseNum % 10 != 0) {
                    sb.insert(0, ones[parseNum%10] + " Hundred ");
                }
            }
            num/=1000;
            count++;

           // System.out.println(sb.toString());
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();
    }
}
