import java.io.IOException;
import java.util.LinkedList;

/**
 * @brief HashMap P-set: DFS and BFS
 */

public class Main {
    /**
     * properties
     */

    /**
     * constructors
     */

    /**
     * behaviors
     */
    public static void main(String[] args) throws IOException {
        MyGraph<Character, LinkedList<Character>> graph = new MyGraph<>();
        graph.buildGraph(System.getProperty("user.dir") + "\\src\\" +
                "resources\\" +
                "problem.csv");
        graph.sortRelations();
        graph.displayGraph();
        System.out.println();
        System.out.println("Depth-First-Search:");
        graph.depthFirstSearch('M');
        System.out.println();
        System.out.println("Breadth-First-Search:");
        graph.breadthFirstSearch('M');

        /**
         * Additional functions
         */
        //        graph.deleteEdge('O', 'J');
//        graph.displayGraph();
//        graph.addEdge('O', 'J');
//        System.out.println();
//        graph.displayGraph();
//        graph.modifyEdge('O', 'J', 'L');
//        System.out.println();
//        graph.displayGraph();

        /**
         * Sample Run
         */
        //        MyGraph<Integer, LinkedList<Integer>> g = new MyGraph<>();
//        g.addEdge(1, 4);
//        g.addEdge(1, 3);
//        g.addEdge(2, 5);
//        g.addEdge(2, 1);
//        g.addEdge(3, 4);
//        g.addEdge(3, 2);
//        g.displayGraph();
    }
}
