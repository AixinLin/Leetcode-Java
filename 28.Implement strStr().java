

public int strStr(String s, String t) {
    if (t.isEmpty()) return 0; // edge case: "",""=>0  "a",""=>0
    for (int i = 0; i <= s.length() - t.length(); i++) {
        for (int j = 0; j < t.length() && s.charAt(i + j) == t.charAt(j); j++)
            if (j == t.length() - 1) return i;
    }
    return -1;
}


public int strStr(String haystack, String needle) {
  for (int i = 0; ; i++) {
    for (int j = 0; ; j++) {
      if (j == needle.length()) return i;
      if (i + j == haystack.length()) return -1;
      if (needle.charAt(j) != haystack.charAt(i + j)) break;
    }
  }
}


//Knuth-Morris-Pratt algorithm in Java.
public class Solution {

    private int[] failureFunction(char[] str) {
        int[] f = new int[str.length+1];
        for (int i = 2; i < f.length; i++) {
            int j = f[i-1];
            while (j > 0 && str[j] != str[i-1]) j = f[j];
            if (j > 0 || str[j] == str[i-1]) f[i] = j+1;
        }
        return f;
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() <= haystack.length()) {
            int[] f = failureFunction(needle.toCharArray());
            int i = 0, j = 0;
            while (i < haystack.length()) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    i++; j++;
                    if (j == needle.length()) return i-j;
                } else if (j > 0) j = f[j];
                else i++;
            }
        }
        return -1;
    }
}



public int strStr1(String haystack, String needle) {
    return haystack.indexOf(needle);
}

public int strStr(String haystack, String needle) {
    if (haystack == null || needle == null)
        return -1;
    int l1 = haystack.length();
    int l2 = needle.length();
    for (int i = 0; i < l1-l2+1; i++) {
        int count = 0;
        while (count < l2 && haystack.charAt(i+count) == needle.charAt(count))
            count++;
        if (count == l2)
            return i;
    }
    return -1;
}
