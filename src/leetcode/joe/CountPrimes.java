package leetcode.joe;

public class CountPrimes {
    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        int i = countPrimes.countPrimes(100);
        System.out.println(i);
    }

    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean [] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i*i < n; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j < n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
}
