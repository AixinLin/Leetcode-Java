public class Solution {
       public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder(); 
        // Google immutability string vs stringbuilder 
        // if you don't know why we use this instead of
        // regular string

        int i = a.length() - 1, j = b.length() -1, carry = 0; 
        //two pointers starting from the back, just think of 
        //adding two regular ints from you add from back
        while (i >= 0 || j >= 0) {
            int sum = carry; 
            //if there is a carry from the last addition, 
            //add it to carry 
            if (j >= 0) sum += b.charAt(j--) - '0'; 
            if (i >= 0) sum += a.charAt(i--) - '0';
            //- '0' is becase b.charAt(j--) return char, but sum
            //is int. Convert the char to int by  - '0'
            sb.append(sum % 2); 
            //if sum==2 or sum==0 append 0 cause 1+1=0 
            //in this case as this is base 2 
            //(just like 1+9 is 0 if adding ints in columns)
            carry = sum / 2; 
            //if sum==2 we have a carry, 
            //else no carry 1/2 rounds down to 0 in integer arithematic
        }
        if (carry != 0) sb.append(carry); //leftover carry, add it
        return sb.reverse().toString();
    }
}


public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        while(i >= 0 || j >= 0 || carry != 0){
            int sum = carry;
            if(i>=0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if(j>=0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            carry = sum / 2;
            if(sum %2 == 0)sb.append('0');
            else sb.append('1');
        }
        return sb.reverse().toString();
    }


public String addBinary(String a, String b) {
    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;
    StringBuilder sb = new StringBuilder();
    
    while (i >= 0 || j >= 0 || carry > 0){
        int sum = ((i < 0) ? 0 : (a.charAt(i--) - '0')) + 
                    ((j < 0) ? 0 : (b.charAt(j--) - '0')) + 
                    carry; 
        
        sb.append(Integer.toString(sum & 1));
        carry = (sum >> 1) & 1;
    }
    
    return sb.reverse().toString();
}


Good job! very clean.
it can also be done by Stack, not use reverse().
//用栈的方法，不用栈可以sb.append(sum % 2)、sb.reverse().toString()，或者sb.insert(0, sum % 2)
    public String addBinary(String a, String b) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0, sum = 0;
        while(i >= 0 || j >= 0) {
            sum = carry;
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            carry = sum / 2;
            stack.push(sum % 2);
        }
        if(carry != 0)
            sb.append(1);
        while(!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();
    }



public String addBinary(String a, String b) {
    int lena = a.length();
    int lenb = b.length();
    int i =0, carry = 0;
    String res = "";
    while(i<lena || i<lenb || carry!=0){
        int x = (i<lena) ? Character.getNumericValue(a.charAt(lena - 1 - i)) : 0;
        int y = (i<lenb) ? Character.getNumericValue(b.charAt(lenb - 1 - i)) : 0;
        res = (x + y + carry)%2 + res;
        carry = (x + y + carry)/2;
        i++;
    }
    return res;
}