import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of nodes
        System.out.print("Enter the number of nodes: ");
        int numNodes = scanner.nextInt();

        // Create an adjacency matrix
        int[][] adjMatrix = new int[numNodes][numNodes];

        // Get the edges and their weights
        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        for (int i = 0; i < numEdges; i++) {
            System.out.print("Enter the nodes connected by edge " + (i + 1) + ": ");
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();

            System.out.print("Enter the weight of edge " + (i + 1) + ": ");
            int weight = scanner.nextInt();

            // Update the adjacency matrix
            adjMatrix[node1 - 1][node2 - 1] = weight;
            adjMatrix[node2 - 1][node1 - 1] = weight;
        }

        // Implement Dijkstra's algorithm
        int sourceNode = 1; // Assuming the source node is 1
        int[] distances = new int[numNodes];
        boolean[] visited = new boolean[numNodes];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[sourceNode - 1] = 0;

        for (int i = 0; i < numNodes - 1; i++) {
            int minIndex = findMinDistance(distances, visited);
            visited[minIndex] = true;

            for (int j = 0; j < numNodes; j++) {
                if (!visited[j] && adjMatrix[minIndex][j] != 0 && distances[minIndex] + adjMatrix[minIndex][j] < distances[j]) {
                    distances[j] = distances[minIndex] + adjMatrix[minIndex][j];
                }
            }
        }

        // Print the shortest distances from the source node
        System.out.println("Shortest distances from node " + sourceNode + ":");
        for (int i = 0; i < numNodes; i++) {
            System.out.println("Node " + (i + 1) + ": " + distances[i]);
        }

        scanner.close();
    }

    private static int findMinDistance(int[] distances, boolean[] visited) {
        int minIndex = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < distances.length; i++) {
            if (!visited[i] && distances[i] < minDistance) {
                minIndex = i;
                minDistance = distances[i];
            }
        }

        return minIndex;
    }
}