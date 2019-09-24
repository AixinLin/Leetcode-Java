//There I was matching chars and strings, which allowed me
//to use the same map for both. Here I only have chars, so I
//turn the chars from t into strings.
public boolean isIsomorphic(String s, String t) {
    Map m = new HashMap();
    for (Integer i=0; i<s.length(); ++i)
        if (m.put(s.charAt(i), i) != m.put(t.charAt(i)+"", i))
            return false;
    return true;
}

1.为什么用integer?
不好意思，我的英语不是很好，中文为你解答一下，不知道你能看懂不？
如果你使用的变量是int类型：
if -127<i<128：int类型的变量和Integer类型的变量是完全相同的，自动封装。
but if i>128； 因为每次循环是int变量的值，而Map需要其封装类对象，
则int类型的值进入map需要有一个装换的过程，即 map.put(A , new Integer(i))，
两次put都是new Integer(i)对象，所以说存入map的是不同的Integer的对象。
所以在比较两个Integer的时，不相同。

2. 为什么加空格“”
it only use one map. If String s and t both use type char,the
process of put will conflict.so use type char and string distinguish
the content of s and t
for example s="egga" and t="addc" when s move to character 'a' and
t move to character 'c', map contains 'a' and put function will return 0
but map does not contain 'c' and put function will return null
In java, Character and String are two different datatypes.
The HashMap is currently has two different types in it (Character and String)


public class Solution {
    public boolean isIsomorphic(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
    }
}

public boolean isIsomorphic(String s, String t) {
	int[] map = new int[128];
	int[] book = new int[128];
	for (int i = 0; i < s.length(); i++) {
		int cs = (int) s.charAt(i);
		int ts = (int) t.charAt(i);
		if (map[cs] == 0 && book[ts] == 0) {
			map[cs] = ts;
			book[ts] = 1;
		} else if (map[cs] != ts)
			return false;
	}
	return true;
}


class Solution {
    public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) {return false;}
    HashMap<Character, Integer> mapS = new HashMap<>();
    HashMap<Character, Integer> mapT = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
        if (!mapS.containsKey(s.charAt(i))) {
            if (mapT.containsKey(t.charAt(i))) {return false;}
        } else {
            int index = mapS.get(s.charAt(i));
            if (!mapT.containsKey(t.charAt(i)) || mapT.get(t.charAt(i)) != index) {return false;}
        }
        mapS.put(s.charAt(i), i);
        mapT.put(t.charAt(i), i);
    }
    return true;
}
}
