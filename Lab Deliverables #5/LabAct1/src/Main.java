import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyBSTree tree = new MyBSTree();
        String sampleExpression = "(((A + B) * (N - I)) / (M * E))";
//        System.out.print("Input an sampleExpression: ");
//        String input = scanner.nextLine();

        tree.buildTree(sampleExpression);
        System.out.println("Inorder traversal:");
        tree.inorderTraversal(tree.root);
        System.out.println("\nPreorder traversal:");
        tree.preorderTraversal(tree.root);
        System.out.println("\nPostorder traversal:");
        tree.postorderTraversal(tree.root);
    }
}