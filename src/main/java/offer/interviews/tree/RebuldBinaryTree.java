package offer.interviews.tree;


import java.util.List;

/**
 * RebuldBinaryTree类，实现重建二叉树
 * * @author kingflag
 *
 * @Date:2017/11/27
 */
public class RebuldBinaryTree {

    /**
     * 使用数组拷贝的方法
     *
     * @param pre 先根遍历
     * @param in  中序遍历
     * @return
     */
    public static TreeNode reConstructBinaryTree1(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                int[] leftPre = new int[i];
                int[] leftIn = new int[i];
                System.arraycopy(pre, 1, leftPre, 0, i);
                System.arraycopy(in, 0, leftIn, 0, i);
                treeNode.left = reConstructBinaryTree(leftPre, leftIn);
                int[] rightPre = new int[pre.length - i - 1];
                int[] rightIn = new int[in.length - i - 1];
                System.arraycopy(pre, i + 1, rightPre, 0, pre.length - i - 1);
                System.arraycopy(in, i + 1, rightIn, 0, in.length - i - 1);
                treeNode.right = reConstructBinaryTree(rightPre, rightIn);
                break;
            }
        }
        return treeNode;
    }

    //主功能函数
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        TreeNode mm = reConstructBinaryTreeCore(pre, in, 0, pre.length - 1, 0, in.length - 1);
        return mm;
    }

    /**
     * 核心递归
     *
     * @param pre
     * @param in
     * @param preStart
     * @param preEnd
     * @param inStart
     * @param inEnd
     * @return
     */
    public static TreeNode reConstructBinaryTreeCore(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        TreeNode tree = new TreeNode(pre[preStart]);
        tree.left = null;
        tree.right = null;
        if (preStart == preEnd && inStart == inEnd) {
            return tree;
        }
        int root = 0;
        for (root = inStart; root < inEnd; root++) {
            if (pre[preStart] == in[root]) {
                break;
            }
        }
        int leifLength = root - inStart;
        int rightLength = inEnd - root;
        if (leifLength > 0) {
            tree.left = reConstructBinaryTreeCore(pre, in, preStart + 1, preStart + leifLength, inStart, root - 1);
        }
        if (rightLength > 0) {
            tree.right = reConstructBinaryTreeCore(pre, in, preStart + 1 + leifLength, preEnd, root + 1, inEnd);
        }
        return tree;
    }

    /**
     * 将二叉树先序遍历，用于测试结果
     *
     * @param node
     */
    public static void preTraverseBinTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + ",");
        if (node.left != null) {
            preTraverseBinTree(node.left);
        }
        if (node.right != null) {
            preTraverseBinTree(node.right);
        }
    }

    /**
     * 将二叉树中序遍历，用于测试结果
     *
     * @param node
     */
    public static void inTraverseBinTree(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inTraverseBinTree(node.left);
        }
        System.out.print(node.val + ",");
        if (node.right != null) {
            inTraverseBinTree(node.right);
        }
    }

    /**
     * 将二叉树后序遍历，用于测试结果
     *
     * @param node
     */
    public static void postTraverseBinTree(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            postTraverseBinTree(node.left);
        }
        if (node.right != null) {
            postTraverseBinTree(node.right);
        }
        System.out.print(node.val + ",");
    }


    /**
     * 思路是这样的, pre[]第一个元素1就是根节点啦 遍历in[]找到1，那么1前面的元素(4,7,2)都是
     * 根节点的左子树，1后面的元素(5,3,8,6)都是根节点的右子树 当然我们可以得知根节点的左子树的节点数为3，右子树的节点数为4，
     * 那么回到pre[]，我们知道1后面的3个元素（2,4,7）是根节点左子树的先序遍历
     * 同样的回到in[]，1前面的3个元素（4,7,2）是根节点左子树的中序遍历
     * 这样的话，我们最终得到了左子树的先序遍历和中序遍历，由此可以再次得到该左子树的根节点是谁。
     * 这样相当于本题的规模变小了，有了递归的性质，显然递归可以得到结果
     */

    /**
     * 主函数，用于测试结果
     *
     * @param args
     */
    public static void main(String[] args) {
        int pre[] = {1, 2, 4, 7, 3, 5, 8, 9, 6};
        int in[] = {4, 7, 2, 1, 8, 5, 9, 3, 6};
        TreeNode tree = reConstructBinaryTree(pre, in);
        System.out.print("先序遍历结果:  {");
        preTraverseBinTree(tree);
        System.out.println("}");
        System.out.print("中序遍历结果:  {");
        inTraverseBinTree(tree);
        System.out.println("}");
        System.out.print("后序遍历结果:  {");
        postTraverseBinTree(tree);
        System.out.println("}");

        List list = TreeLevelOrder.levelOrder(tree);
        System.out.println(list);
    }
}