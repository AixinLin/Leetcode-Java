public TreeNode sortedArrayToBST(int[] num) {
    if (num.length == 0) {
        return null;
    }
    TreeNode head = helper(num, 0, num.length - 1);
    return head;
}

public TreeNode helper(int[] num, int low, int high) {
    if (low > high) { // Done
        return null;
    }
    int mid = (low + high) / 2;
    TreeNode node = new TreeNode(num[mid]);
    node.left = helper(num, low, mid - 1);
    node.right = helper(num, mid + 1, high);
    return node;
}



the normal DFS

class MyTreeNode {
    TreeNode root;
    int start;
    int end;

    MyTreeNode(TreeNode r, int s, int e) {
        this.root = r;
        this.start = s;
        this.end = e;
    }
}
public TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length == 0) {
        return null;
    }
    Stack<MyTreeNode> rootStack = new Stack<>();
    int start = 0;
    int end = nums.length;
    int mid = (start + end) >>> 1;
    TreeNode root = new TreeNode(nums[mid]);
    TreeNode curRoot = root;
    rootStack.push(new MyTreeNode(root, start, end));
    while (end - start > 1 || !rootStack.isEmpty()) {
        //Consider the left subtree
        while (end - start > 1) {
            mid = (start + end) >>> 1; //Current root node
            end = mid;//End of the left subtree
            mid = (start + end) >>> 1;//mid of the left subtree
            curRoot.left = new TreeNode(nums[mid]);
            curRoot = curRoot.left;
            rootStack.push(new MyTreeNode(curRoot, start, end));
        }
        //pop and consider the right subtree
        MyTreeNode myNode = rootStack.pop();
        // start, end and  mid of current node
        start = myNode.start;
        end = myNode.end;
        mid = (start + end) >>> 1;
        start = mid + 1; //start of the right subtree
        curRoot = myNode.root; //current root
        if (start < end) {  
            mid = (start + end) >>> 1; //mid of the right subtree
            curRoot.right = new TreeNode(nums[mid]);
            curRoot = curRoot.right;
            rootStack.push(new MyTreeNode(curRoot, start, end));
        }

    }

    return root;
}



The idea is making the middle element as root and recursively calling the method until the length of the array is zero.

public class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if(nums.length==0)return null;
            int ptr=nums.length/2;
            TreeNode root=new TreeNode(nums[ptr]);
            root.left=sortedArrayToBST(Arrays.copyOfRange(nums,0,ptr));
            root.right=sortedArrayToBST(Arrays.copyOfRange(nums,ptr+1,nums.length));
            return root;
        }
    }