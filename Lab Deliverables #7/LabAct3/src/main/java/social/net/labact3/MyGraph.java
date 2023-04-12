package social.net.labact3;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @brief Graph Data Structure
 */

public class MyGraph<E, F extends LinkedList<E>> {
    /**
     * properties
     */
    private HashMap<E, F> graph;

    /**
     * constructors
     */
    public MyGraph() {
        graph = new HashMap<>();
    }

    /**
     * behaviors
     */
    public void addEdge(E addr, E dest) {
        if (!graph.containsKey(addr)) {
            LinkedList<E> nodes = new LinkedList<>();
            nodes.add(dest);
            graph.put(addr, (F) nodes);
        } else {
            LinkedList<E> nodes = graph.get(addr);
            if (!nodes.contains(dest)) {
                nodes.add(dest);
                graph.put(addr, (F) nodes);
            }
        }
    }

    public void addVertex(E addr) {
        addEdge(addr, null);
        deleteEdge(addr, null);
    }

    public void modifyEdge(E addr, E modifyDest, E dest) {
        graph.get(addr).set(graph.get(addr).indexOf(modifyDest), dest);
    }

    public void deleteEdge(E addr, E dest) {
        graph.get(addr).remove(dest);
    }

    public Set getNodes() {
        return graph.keySet();
    }

    public LinkedList<E> getKey(String key) {
        return graph.get(key);
    }

    public void displayGraph() {
        System.out.println("Vertices = " + getNodes());
        for (Map.Entry m : graph.entrySet())
            System.out.println(m.getKey() + " ==> " + m.getValue());
    }

    public void buildGraph(String file_loc) throws IOException {
        Scanner scanner = new Scanner(new File(file_loc));
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(",");
            Object[] edge = new Object[]{line[0].charAt(0), line[1].charAt(0)};
            addEdge((E) edge[0], (E) edge[1]);
        }
        scanner.close();
    }

    public void depthFirstSearch(E src) {
        HashSet<E> visited = new HashSet<>();
        Stack<E> stack = new Stack<>();
        stack.push(src);

        while (!stack.isEmpty()) {
            E node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);
                System.out.print(node + " ");
                for (E neighbor : graph.get(node)) {
                    if (!visited.contains(neighbor))
                        stack.push(neighbor);
                }
            }
        }
    }

    public void breadthFirstSearch(E src) {
        HashSet<E> visited = new HashSet<>();
        Queue<E> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            E node = queue.poll();
            if (!visited.contains(node)) {
                visited.add(node);
                System.out.print(node + " ");
                for (E neighbor : graph.get(node)) {
                    if (!visited.contains(neighbor))
                        queue.add(neighbor);
                }
            }
        }
    }
}
