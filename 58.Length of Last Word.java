
Your solution is very practical, but note that what your interviewer wants to hear more about is probably how you would deal with this problem on a lower level, without the help of those standard library functions. If you give an answer like this, then your interviewer will probably ask you to implement two more functions: trim and lastIndexOf.

public int lengthOfLastWord(String s) {
    return s.trim().length()-s.trim().lastIndexOf(" ")-1;
}


This one single line solution is just used to compare the time cost with the solution below:
(Time cost: 348ms vs. 344ms, almost the same)

public int lengthOfLastWord(String s) {
    int len=s.length(), lastLength=0;
    
    while(len > 0 && s.charAt(len-1)==' '){
        len--;
    }
    
    while(len > 0 && s.charAt(len-1)!=' '){
        lastLength++;
        len--;
    }
    
    return lastLength;
}


	public int lengthOfLastWord(String s) {
		char[] ca = s.toCharArray();
		
		int index = ca.length - 1;
		
		while (index >= 0 && ca[index] == ' ') index--;
		if (index == -1) return 0;

		int end = index;
		index--;

		while (index >= 0 && ca[index] != ' ') index--;

		return end - index;
	}




class Solution {
    public int lengthOfLastWord(String s) {
        int lastLen = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && lastLen > 0) {
                return lastLen;
            } else if (s.charAt(i) != ' ') {
                lastLen++;
            }
        }
        return lastLen;
    }
}


class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        int n = s.length();
        if(s==null || n==0)
            return 0;//这里不需要
        for(int i=n-1; i>=0; i--){
            if(s.charAt(i) == ' ' && count > 0){
                return count;
            }
            else if(s.charAt(i) != ' '){
                count++;
            }
        }
        return count;
    }
}