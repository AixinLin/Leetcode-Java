 class Solution {
    public int romanToInt(String s) {
        if(s==null || s.length() == 0){return 0;}
        // 用hashmap去存储罗马数与数字之间的关系
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X', 10);
        map.put('L',50);
        map.put('C',100);
        map.put('D', 500);
        map.put('M',1000);
        int num = 0;
        num += map.get(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(map.get(s.charAt(i)) <= map.get(s.charAt(i-1))){
                num += map.get(s.charAt(i));
            }else{
                //减去上一个循环中多加的数字
                num = num - 2*map.get(s.charAt(i-1)) + map.get(s.charAt(i));
            }
        }
        return num;
    }
}


    public static int romanToInt(String s) {
    if (s == null || s.length() == 0)
        return -1;
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
    int len = s.length(), result = map.get(s.charAt(len - 1));
    for (int i = len - 2; i >= 0; i--) {
        if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)))
            result += map.get(s.charAt(i));
        else
            result -= map.get(s.charAt(i));
    }
    return result;



class Solution {
   public int romanToInt(String s) {
    HashMap<Character, Integer> values = new HashMap<Character, Integer>();
    values.put('I',1);
    values.put('V',5);
    values.put('X',10);
    values.put('L',50);
    values.put('C',100);
    values.put('D',500);
    values.put('M',1000);
    
    int ptr = s.length() - 1;
    int curr;
    int prev = 0;
    int result = 0;
    
    while(ptr >= 0) {
        curr = values.get(s.charAt(ptr));
        result = curr >= prev ? (result + curr) : (result - curr);
        prev = curr;
        ptr--;
    }
    
    return result;
}
}