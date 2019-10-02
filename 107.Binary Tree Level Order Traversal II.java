//DFS solution:
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null) return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(0, subList);
        }
        return wrapList;
    }
}

// BFS solution:
public class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
            levelMaker(wrapList, root, 0);
            return wrapList;
        }

        public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
            if(root == null) return;
            if(level >= list.size()) {
                list.add(0, new LinkedList<Integer>());
            }
            levelMaker(list, root.left, level+1);
            levelMaker(list, root.right, level+1);
            list.get(list.size()-level-1).add(root.val);
        }
    }


The addFirst() method of LinkedLinked save us from reverse final result.
// this is top-bottom
public List<List<Integer>> levelOrderBottom(TreeNode root) {
    LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();
    addLevel(list, 0, root);
    return list;
}

private void addLevel(LinkedList<List<Integer>> list, int level, TreeNode node) {
    if (node == null) return;
    if (list.size()-1 < level) list.addFirst(new LinkedList<Integer>());
    list.get(list.size()-1-level).add(node.val);
    addLevel(list, level+1, node.left);
    addLevel(list, level+1, node.right);
}



//solution 3
public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if(root == null)
        {
            return result;
        }

        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            int currentQueueSize = queue.size();
            List<Integer> level = new ArrayList<>();
            while(currentQueueSize != 0)
            {
                TreeNode node = queue.remove();
                level.add(node.val);
                currentQueueSize--;

                if(node.left != null)
                {
                    queue.add(node.left);
                }

                if(node.right != null)
                {
                    queue.add(node.right);
                }
            }

            stack.push(level);
        }

        while(!stack.isEmpty())
        {
            result.add(stack.pop());
        }

        return result;
    }
