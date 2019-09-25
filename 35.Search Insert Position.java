class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums[0] > target) return 0;
        if(nums[nums.length-1] < target) return nums.length;

        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] >= target){
                return i;
            }
        }

        return 0;

    }
}



class Solution {
	   public int searchInsert(int[] nums, int target) {
			int start = 0,end = nums.length,mid = 0;
			while(start < end){
				mid = (start+end)/2;
				if(target == nums[mid]) return mid;
				if(target > nums[mid]) start = mid + 1;
				if(target < nums[mid]) end = mid;
			}

			if(target < nums[mid]) return mid;
			else return mid + 1;
		}
	}


  class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] >= target) r = m;
            else l = m + 1;
        }
        return nums[l] >= target ? l : l + 1;
    }
}
