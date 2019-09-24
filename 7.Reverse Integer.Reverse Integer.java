Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store 
integers within the 32-bit signed integer range: [−231,  231 − 1]. 
For the purpose of this problem, assume that your function returns 0 
when the reversed integer overflows.


//正确答案
class Solution {
    public int reverse(int x) {
        
        int result = 0;

        while(x!=0){
            int pop = x%10;
            x /= 10;
            
            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && pop > 7))
                return 0;
            if(result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && pop < -8))
                return 0;
            
            result = result*10 + pop;
            
        }
        return result;
    }
}

//疑问
class Solution {
    public int reverse(int x) {
        
        int result = 0;

        while(x!=0){
            int pop = x%10;
            x /= 10;
            result = result*10 + pop;
            //为什么放这里就错了，有test case不通过
            if(result > Integer.MAX_VALUE || (result == Integer.MAX_VALUE && pop > 7))
                return 0;
            if(result < Integer.MIN_VALUE || (result == Integer.MIN_VALUE && pop < -8))
                return 0;
        }
        return result;
    }
}