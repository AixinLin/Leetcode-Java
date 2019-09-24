

public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        //They will be initialized to false by default.
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
                //下面这种 outof boundary，runtime error，为什么？
                // for(int j=2; j < n; j++){
                //     if(i*j < n){
                //         notPrime[i*j] = true;
                //     }
                // }
            }
        }

        return count;
    }
}
