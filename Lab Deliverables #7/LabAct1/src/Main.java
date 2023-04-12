import java.util.Scanner;

public class Main {
    static int N = 5;
    static Scanner scanner = new Scanner(System.in);
    static int[][] g = new int[N][N];
    static int i;
    static int j;

    public Main() {
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++)
                g[i][j] = 0;
        }

        while (true) {
            System.out.print("Do you want to add a vertex(V) or create edges(E)? ");
            char c = scanner.next().charAt(0);
            if (Character.toLowerCase(c) == 'e') {
                int e;
                System.out.print("Enter number of edges you want to graph of " + N + " vertices:");  
                e = scanner.nextInt();
                for (i = 0; i < e; i++)
                    addEdge();

                show();

                modifyEdge();
                deleteEdge();

                show();
            } else if (Character.toLowerCase(c) == 'v') {
                N += 1;
                int[][] temp = new int[N][N];
                for (i = 0; i < g.length; i++) {
                    for (j = 0; j < g.length; j++)
                        temp[i][j] = g[i][j];
                }

                g = temp;
            } else
                break;
        }
    }

    public Main(int edge) {
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++)
                g[i][j] = 0;
        }
        i = 0;
        while (i < edge) {
            addEdge();
            i++;
        }
    }

    public void addEdge() {
        int v1, v2;
        System.out.println("Enter two vertex you want to connect.");
        v1 = scanner.nextInt();
        v2 = scanner.nextInt();
        g[v1 - 1][v2 - 1] = 1;
        g[v2 - 1][v1 - 1] = 1;
    }

    public void modifyEdge() {
        int v1, v2;
        System.out.println("Enter two vertex you want to modify.");
        v1 = scanner.nextInt();
        v2 = scanner.nextInt();
        System.out.println("Enter their connection.");
        g[v2 - 1][v1 - 1] = scanner.nextInt();
        g[v1 - 1][v2 - 1] = scanner.nextInt();
    }

    public void deleteEdge() {
        int v1, v2;
        System.out.println("Enter two vertex you want to delete edge.");
        v1 = scanner.nextInt();
        v2 = scanner.nextInt();
        g[v2 - 1][v1 - 1] = 0;
        g[v1 - 1][v2 - 1] = 0;
    }

    public static void show() {
        System.out.print("\t\t\t");
        for (int i = 0; i < N; i++)
            System.out.printf("\t%s%d", "V", (i + 1));
        System.out.println();
        for (i = 0; i < N; i++) {
            System.out.print("Edge from V" + (i + 1) + " to");
            for (j = 0; j < N; j++) {
                System.out.print("\t ");
                System.out.print(g[i][j]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}