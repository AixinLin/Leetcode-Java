this problem was discussed by Jon Bentley 
(Sep. 1984 Vol. 27 No. 9 Communications of the ACM P885)

the paragraph below was copied from his paper 
(with a little modifications)

algorithm that operates on arrays: it starts at the left end 
(element A[1]) and scans through to the right end (element A[n]), 
keeping track of the maximum sum subvector seen so far. The maximum 
is initially A[0]. Suppose we have solved the problem for A[1 .. i - 1]; 
how can we extend that to A[1 .. i]? The maximum
sum in the first I elements is either the maximum sum in the 
first i - 1 elements (which we will call MaxSoFar), or it is that of a 
subvector that ends in position i (which we will call MaxEndingHere).

MaxEndingHere is either A[i] plus the previous MaxEndingHere, or just A[i], whichever is larger.

//solution 1
public static int maxSubArray(int[] A) {
    int maxSoFar=A[0], maxEndingHere=A[0];
    for (int i=1;i<A.length;++i){
    	maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
    	maxSoFar=Math.max(maxSoFar, maxEndingHere);	
    }
    return maxSoFar;
}

//solution 2
public class Solution {
public int maxSubArray(int[] A) {
    int max = Integer.MIN_VALUE, sum = 0;
    for (int i = 0; i < A.length; i++) {
        if (sum < 0) 
            sum = A[i];
        else 
            sum += A[i];
        if (sum > max)
            max = sum;
    }
    return max;
}
}