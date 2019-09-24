Example 1:

Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.

It does not matter what you leave beyond the returned length.


//solution 1
class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length ==0)
            return 0;
        int count = 0;
        for(int i =0; i < nums.length; i++){
            if(nums[i] != val){
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}

https://leetcode.com/problems/remove-element/solution/