public class Solution {
    public List<Integer> getRow(int k) {
        Integer[] arr = new Integer[k + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;

        for (int i = 1; i <= k; i++)
            for (int j = i; j > 0; j--)
                arr[j] = arr[j] + arr[j - 1];

        return Arrays.asList(arr);
    }
}


public List<Integer> getRow(int rowIndex) {
 List<Integer> list = new ArrayList<Integer>();
 if (rowIndex < 0)
   return list;

 for (int i = 0; i < rowIndex + 1; i++) {
   list.add(0, 1);
   for (int j = 1; j < list.size() - 1; j++) {
     list.set(j, list.get(j) + list.get(j + 1));
   }
 }
 return list;
}




Based on rules:

row k of Pascal's Triangle:

[C(k,0), C(k,1), ..., C(k, k-1), C(k, k)]

and

C[k,i] = C[k,i-1]*(k-i+1)/i

    public class Solution {
        public List<Integer> getRow(int rowIndex) {
            Integer[] rowList = new Integer[rowIndex+1];
            rowList[0] = 1;
            for(int i=1; i<rowList.length;i++) {
                rowList[i] = (int)((long)rowList[i-1]*(rowIndex-(i-1))/(i));
            }
            return Arrays.asList(rowList);
        }
    }
