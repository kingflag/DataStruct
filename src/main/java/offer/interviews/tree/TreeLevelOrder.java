package offer.interviews.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeLevelOrder {
    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Queue queue = new LinkedList();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = (TreeNode) queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    list.add(node.left.val);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    list.add(node.right.val);
                }
            }
        }

        return list;
    }
}
