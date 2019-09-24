
//solution 1(自己)
class Solution {
    public boolean isPalindrome(int x) {
        String str=Integer.toString(x), temp="";
        int n=str.length();
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i)==str.charAt(n-1)){
                n--;
            }else{
                return false;
            }
           
        }
         return true;
    }
}

//solution 2
public boolean isPalindrome(int x) {
    if (x<0 || (x!=0 && x%10==0)) return false;
    int rev = 0;
    while (x>rev){
        rev = rev*10 + x%10;
        x = x/10;
    }
    return (x==rev || x==rev/10);
}