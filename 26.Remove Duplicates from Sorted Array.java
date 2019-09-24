Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by REFERENCE, 
which means modification to the input array will be known 
to the caller as well.


class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j=1; j<nums.length; j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
}