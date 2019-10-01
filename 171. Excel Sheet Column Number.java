public class Solution {
    public int titleToNumber(String s) {
    
        int result  = 0;
        for (int i = 0; i < s.length(); i++){
            result *= 26;
            result += ((s.charAt(i) - 'A') + 1); 
			//The reason for - 'A', is that it "shifts" the ascii/unicode value so that A - Z have values 0 - 25. And are thus more suitable as an array index.   
        }
    
        return result;
    }
}