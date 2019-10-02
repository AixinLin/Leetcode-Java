class Solution {
    public int minDepth(TreeNode root) {
        return findMinDepth(root);
    }

    private int findMinDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        if (root.left == null || root.right == null)
            return root.left == null ? findMinDepth(root.right) + 1 : findMinDepth(root.left) + 1;
        return Math.min(findMinDepth(root.left), findMinDepth(root.right)) + 1;
    }
}
