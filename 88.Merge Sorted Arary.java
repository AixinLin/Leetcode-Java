public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1;  //last index of nums1that has valid number
        int i2 = n - 1; // last index of nums2
        int lastIndex = m + n - 1; //last index of nums array
        while(i1 >= 0 && i2 >= 0){
            if(nums1[i1] > nums2[i2]){ //compare two numbers
                //if nums1[i1] is bigger, then place it in the last index in nums1
                nums1[lastIndex] = nums1[i1];
                i1 --;
            } else {
                nums1[lastIndex] = nums2[i2];
                i2 --;
            }
            lastIndex --;
        }
        // if i1 is greater than 0 but i2 is not, we don't need to do anything becuase it's a sorted array.
       // However, if i2 is greater than 0, this means the rest of spot is only n2.
        while( i2 >= 0){
            nums1[lastIndex] = nums2[i2];
            lastIndex --;
            i2 --;
        }
    }


//为什么不对
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = m+n;
        int j=0, i=0;
        int[] temp = new int[a-1];
        for(int b = 0; b<a; b++){
            if(nums1[i]<=nums2[j]){
                temp[b] = nums2[j];
                j++;
            }
            else if(nums1[i]<nums2[j] && nums1[i+1]>nums2[j]){
                temp[b] = nums1[i];
                i++;
            }
            else {
                temp[b] = nums2[j];
            }
        }
        nums1 = temp;
    }
}