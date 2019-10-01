class Solution {
    public int majorityElement(int[] nums) {
        
        for(int i=0; i< nums.length; i++){
            int count = 0;
            int a = nums[i];
            for(int j=0; j< nums.length; j++){
                if(a == nums[j])
                    count++;
               
            }
             if(count>(nums.length/2))
                    return a;
            
        }
        return -1;
    }
}