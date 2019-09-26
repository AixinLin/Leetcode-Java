public int[] plusOne(int[] digits) {
        
    int n = digits.length;
    for(int i=n-1; i>=0; i--) {
        if(digits[i] < 9) {
            digits[i]++;
            return digits;
        }
        
        digits[i] = 0;
    }
    
    int[] newNumber = new int [n+1];
    newNumber[0] = 1;
    
    return newNumber;
}


public class Solution {
    public int[] plusOne(int[] digits) {
        return helper(digits,digits.length-1);
    }
    
    private int[] helper(int[] digits, int index){
        if(digits[index] < 9){
            digits[index]++;
            return digits;
        }else{
            if(index != 0){
                digits[index] = 0;
                return helper(digits,index-1);
            }else{
                int[] res = new int[digits.length+1];
                res[0] = 1;
                return res;
            }
        }
    }
}