import java.util.Stack;

class MyBSTree {
    public TreeNode root;

    private static class TreeNode {
        char data;
        TreeNode left;
        TreeNode right;

        public TreeNode(char item) {
            data = item;
            left = null;
            right = null;
        }
    }

    public MyBSTree() {
        root = null;
    }

    public void inorderTraversal(TreeNode current) {
        if (current != null) {
            inorderTraversal(current.left);
            System.out.print(current.data + " ");
            inorderTraversal(current.right);
        }
    }

    void preorderTraversal(TreeNode current) {
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

    public void buildTree(String expression) {
        StringBuilder shuntyard = new StringBuilder();
        for (char c : Shuntyard.algorithm(expression).toCharArray()) {
            if (Character.isLetterOrDigit(c) || c == '^' || c == '*' || c == '/' || c == '+' || c == '-')
                shuntyard.append(c);
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        for (int i = 0; i < shuntyard.length(); i++) {
            char c = shuntyard.charAt(i);

            if (Character.isLetter(c)) {
                TreeNode node = new TreeNode(c);
                stack.push(node);
            } else {
                TreeNode right = stack.pop();
                TreeNode left = stack.pop();
                TreeNode node = new TreeNode(c);
                node.left = left;
                node.right = right;
                stack.push(node);
            }
        }

        root = stack.peek();
    }
}