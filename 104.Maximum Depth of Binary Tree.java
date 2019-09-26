Recursion solution:

public class Solution {
    public int maxDepth(TreeNode root) {
        return root==null? 0 : Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}


class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1; 
    }
}



Using BFS

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int depth = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            depth++;
            while (size-- > 0) {
                TreeNode node = nodes.poll();
                if (node.left != null) nodes.offer(node.left);
                if (node.right != null) nodes.offer(node.right);
            }
        }
        return depth;
    }
}