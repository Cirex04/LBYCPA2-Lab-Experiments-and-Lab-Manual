package social.net.labact3;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @brief Friends data structure for an account
 */

public class FriendDatabase {
    /**
     * properties
     */
    private MyGraph<String, LinkedList<String>> friends_graph;

    /**
     * constructors
     */
    public FriendDatabase() {
        friends_graph = new MyGraph<>();
    }

    /**
     * behaviors
     */
    public void accountConnection(String loggedIn) throws IOException {
        FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\" +
                "main\\" +
                "resources\\" +
                "social\\" +
                "net\\" +
                "labact3\\" +
                "database\\" +
                "friends_list\\" +
                loggedIn + "\\" +
                "friend_graph.csv");
        Scanner scanner = new Scanner(file);

        scanner.nextLine();
        if (scanner.hasNextLine()) {
            while (scanner.hasNextLine())
                friends_graph.addEdge(loggedIn, scanner.nextLine());
        } else
            friends_graph.addVertex(loggedIn);


        scanner.close();
        file.close();
    }

    public MyGraph<String, LinkedList<String>> getFriends_graph() {
        return friends_graph;
    }
}
