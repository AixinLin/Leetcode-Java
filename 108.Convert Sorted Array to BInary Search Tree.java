//Simple Java solution using DFS for slow learners like myself
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return nums == null ? null : convert(nums, 0, nums.length - 1);
    }

    private TreeNode convert(int[] nums, int i, int j) {
        if (i > j)
            return null;
        int mid = i + (j - i) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = convert(nums, i, mid - 1);
        root.right = convert(nums, mid + 1, j);
        return root;
    }
}


//Recursion Java Solution
class Solution {
    public TreeNode sortedArrayToBST(int[] nums)
    {
        if(nums.length == 0)
            return null;
        if(nums.length == 1)
            return new TreeNode(nums[0]);

        int mid = nums.length / 2;
        TreeNode midNode = new TreeNode(nums[mid]);
        midNode.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
        midNode.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));

        return midNode;
    }
}
