//Solution 1
private boolean check = true;
public boolean isBalanced(TreeNode root) {
    helper(root);
    return check;
}

private int helper(TreeNode root){
    if(root == null) return 0;
    int left = helper(root.left);
    int right = helper(root.right);
    int diff = Math.abs(left - right);

    if(diff > 1) {
        check = false;
    }

    return 1 + Math.max(left, right);
}

//Solution 2
private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int L = getHeight(root.left);
        int R = getHeight(root.right);
        return 1 + Math.max(L, R);
    }
    public boolean isBalanced(TreeNode root) {
        return root == null || Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
