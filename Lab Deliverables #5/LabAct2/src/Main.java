public class Main {
    private static void f(String expression) {
        String[] data = expression.split(" ");
        MyBSTree tree = new MyBSTree();

        for (String datum : data)
            tree.insert(datum);

        System.out.print("Inorder: ");
        tree.inorderTraversal(tree.root);
    }

    public static void main(String[] args) {
        String givenExpression = "The quick brown fox jumps over the lazy dog";
//        Scanner scanner = new Scanner(System.in);
//        String inputExpression = scanner.nextLine();

        f(givenExpression);
    }
}