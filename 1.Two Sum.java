Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

//O(n) Using HashMap
public int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            int value = (map.containsKey(nums[i]))?map.get(nums[i])+i+nums.length:i;
            map.put(nums[i],value);
            
            int find = target-nums[i];
            
            if(map.containsKey(find))
            {
                if(find == nums[i])
                {
                    if(map.get(nums[i]) != i)
                    {
                        a[0] = i;
                        a[1] = map.get(find)-i-nums.length;
                        return a;
                    }
                    else
                    {
                        continue;
                    }
                }
                a[0] = i;
                a[1] = map.get(find);
                return a;
            }
        }
        return a;
    }


//Hash Map solution.
 public int[] twoSum(int[] nums, int target) 
    {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++)
        {
            int value = nums[i];
            
            if(map.containsKey(value))
            {
                return new int[]{map.get(value), i};
            }
            
            int complement = target - value;
            map.put(complement,i);
        }
        
        return new int[]{};
    }


//solution2. Wrong in some test case.
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(nums[i]+nums[j] == target){ //这里不对
                    return new int[] {i,j};
                }
            }
        }
      throw new IllegalArgumentException("No two sum solution");
    }
  
}

//这样才通过全部test case。
class Solution {
   public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == target - nums[i]) { //区别？？
                return new int[] { i, j };
            }
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}
  
}