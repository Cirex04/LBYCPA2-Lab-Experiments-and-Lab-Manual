package tree.visualization.labact3;

class MyBSTree<E> {
    public TreeNode root;

    public class TreeNode {
        E data;
        TreeNode left;
        TreeNode right;

        public TreeNode(E data) {
            this.data = data;
            left = null;
            right = null;
        }

    }

    public MyBSTree() {
        root = null;
    }

    public boolean contains(E value) {
        if (root == null) {
            return false;
        }
        TreeNode current = root;

        while (current != null) {
            int cmp = compareVal(value, current.data);
            if (cmp == 0)
                return true;
            else if (cmp < 0)
                current = current.left;
            else
                current = current.right;
        }

        return false;
    }

    public TreeNode search(E data) {
        // make a traversal to compare that node's left and right branch if it's empty
        // if their left or right branch is empty insert it depending on which is greater or lesser
        // as long as they're not null

        TreeNode current = root;
        if (root == null)
            return null;

        while (current != null) {
            int cmp = compareVal(data, current.data);
            if (cmp == 0)
                return current;
            else if (cmp < 0)
                current = current.left;
            else
                current = current.right;
        }

        return null;
    }

    private int compareVal(E value, E current) {
        TreeNode val = new TreeNode(value);
        TreeNode curr = new TreeNode(current);
        if (curr.data == val.data)
            return 0;
        else if (val.data.toString().charAt(0) < curr.data.toString().charAt(0))
            return -1;
        else
            return 1;
    }

    public void insert(E data) {
        root = buildTree(root, data);
    }

    public TreeNode buildTree(TreeNode newRoot, E data) {
        if (newRoot == null) {
            newRoot = new TreeNode(data);
            return newRoot;
        } else if (data.toString().charAt(0) < newRoot.data.toString().charAt(0))
            newRoot.left = buildTree(newRoot.left, data);
        else if (data.toString().charAt(0) > newRoot.data.toString().charAt(0))
            newRoot.right = buildTree(newRoot.right, data);
        else
            newRoot.right = buildTree(newRoot.right, data);

        return newRoot;
    }

    public void remove(E data) {
        root = rebuildTree(root, data);
    }

    public TreeNode rebuildTree(TreeNode newRoot, E data) {
        if (newRoot == null) {
            System.out.println("Tree is empty or data not found");
            return null;
        }

        if (data.toString().charAt(0) < newRoot.data.toString().charAt(0)) {
            newRoot.left = rebuildTree(newRoot.left, data);
        } else if (data.toString().charAt(0) > newRoot.data.toString().charAt(0)) {
            newRoot.right = rebuildTree(newRoot.right, data);
        } else {
            if (newRoot.left == null) {
                return newRoot.right;
            } else if (newRoot.right == null) {
                return newRoot.left;
            }

            newRoot.data = minValue(newRoot.right);
            newRoot.right = rebuildTree(newRoot.right, newRoot.data);
        }

        return newRoot;
    }

    private E minValue(TreeNode root) {
        E minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }

        return minv;
    }
    public void inorderTraversal(TreeNode current) {
        if (current != null) {
            inorderTraversal(current.left);
            System.out.print(current.data + " ");
            inorderTraversal(current.right);
        }
    }

    public void preorderTraversal(TreeNode current) {
        if (current != null) {
            System.out.print(current.data + " ");
            preorderTraversal(current.left);
            preorderTraversal(current.right);
        }
    }

    public void postorderTraversal(TreeNode current) {
        if (current != null) {
            postorderTraversal(current.left);
            postorderTraversal(current.right);
            System.out.print(current.data + " ");
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    private void toStringHelper(TreeNode node, StringBuilder sb) {
        if (node == null)
            return;

        sb.append(node.data).append(" ");
        toStringHelper(node.left, sb);
        toStringHelper(node.right, sb);
    }

    @Override
    public String toString() {
        if (root == null)
            return "";

        StringBuilder sb = new StringBuilder();
        toStringHelper(root, sb);
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}