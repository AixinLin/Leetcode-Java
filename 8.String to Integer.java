//solution 1
class Solution {
    public int myAtoi(String str) {
        
        // time complexity : O(log(str.length()))
        // space complexity : O(1)
        
        str = str.trim();  // remove whitespaces
        int sign = 1;   // positive then 1 else negative -1
        int cnum = 0,num = 0;
        for(int i = 0; i < str.length();i++) {
            // To get the current number

            cnum = str.charAt(i) - 48; // current digit,为什么-48?

            if(cnum >= 0 && cnum <= 9) {
                // if number is greater than max value return max value
                if (num > Integer.MAX_VALUE/10 || (num == Integer.MAX_VALUE / 10 && cnum > 7)) return Integer.MAX_VALUE;
                
                // if number is less than min value return min value
                else if (num < Integer.MIN_VALUE/10 || (num == Integer.MIN_VALUE / 10 && cnum > 8)) return Integer.MIN_VALUE;
                
                
                else {
                    num = num *10 + sign * cnum;
                }
            }
            else if(i == 0) {
                if(str.charAt(i) == '+') 
                    continue;
                else if(str.charAt(i) == '-')
                    sign  = -1;
                else break;
            }
            else break;
        }
        return num;
    }
}


//solution 2
public int myAtoi(String str) {
    int index = 0, sign = 1, total = 0;
    //1. Empty string
    if(str.length() == 0) return 0;

    //2. Remove Spaces
    while(str.charAt(index) == ' ' && index < str.length())
        index ++;

    //3. Handle signs
    if(str.charAt(index) == '+' || str.charAt(index) == '-'){
        sign = str.charAt(index) == '+' ? 1 : -1;
        index ++;
    }
    
    //4. Convert number and avoid overflow
    while(index < str.length()){
        int digit = str.charAt(index) - '0';
        if(digit < 0 || digit > 9) break;

        //check if total will be overflow after 10 times and add digit
        if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        total = 10 * total + digit;
        index ++;
    }
    return total * sign;
}


//solution 3, test case error.
class Solution {
public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        char chs[] = str.toCharArray();
        long base = 0;
        int i = 0, sign = 1;
        
        str = str.trim();   // Trim whitespace
        if (chs[i] == '-') {        // sign: '-' 
            i++;
            sign = -1; 
        } else if (chs[i] == '+') { // sign: '+'
            i++;
        }
        while (i < str.length() && (chs[i] >= '0' && chs[i] <= '9')) {
            // Parse numerical digits
            base = base * 10 + (chs[i] - '0');
            // Check integer boundary
            if (sign * base > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * base < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int)(sign * base);
    }
}