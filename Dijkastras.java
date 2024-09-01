
import java.util.Scanner;
import java.util.ArrayList;

public class Dijkastras
{
    public static int start = 47;
    public static int total = 0;
    public static int current = 0;
    static ArrayList<Integer> visited = new ArrayList<>();
    static ArrayList<Integer> unvisited = new ArrayList<>();
    static ArrayList<Integer> steps = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int edges = scanner.nextInt();
        int end = 79;
        current = start;

        // Creates adjacency matrix with 100 vertices
        int [][] adjMat = new int[100][100];

        // take in three numbers and sets as x, y, and wieght respectivly
        for(int i = 0; i < edges; i++)
        {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int w = scanner.nextInt();

            adjMat[x][y] = w;
        } 
        
        //add vertice to unvisited list if it hasnt been already
        for(int i = 0; i < 100; i++)
        {
            for(int j = 0; j < 100; j++)
            {
                if(adjMat[i][j] != 0)
                {
                    if(!unvisited.contains(i))
                    {
                        unvisited.add(i);
                    }

                    if(!unvisited.contains(j))
                    {
                        unvisited.add(j);
                    }
                }
            }
        }

        // recursivly calls Dijkstras algortihms, updating the total weight, untik row/column 79 is reached
        while(current != 79 && edges != 0)
        {
            total += Dijkstras(adjMat, current);
            edges --;
        }

        System.out.println(total);

        
        scanner.close();
    }

    //Dijkastras algorithm method, takes in adjMat which is unchanged and target which is the row/column to be checked
    public static int Dijkstras(int[][] adjMat, int target)
    {
        //int to track the smallet edge weight from current node
        int least = 0;

        //checks weight at all column of the current index
        for(int i = 0; i < adjMat.length; i++)
        {
            //if edge is there, add to steps
            if(adjMat[i][target] != 0)
            {
                steps.add(i);
            }
            //if wieght is not 0 and smaller than current saved smalled weight, save weight as least and update current to index of loction
            if(adjMat[i][target] != 0 && adjMat[i][target] < least)
            {
                least = adjMat[i][target];
                current = i;
                steps.remove(steps.size() - 1);
            }
        }

        //checks weight at all rows of current index
        for(int j = 0; j < adjMat[target].length; j++)
        {
            //if edge is there, add to steps
            if(adjMat[j][target] != 0)
            {
                steps.add(j);
            }

            //if wieght is not 0 and smaller than current saved weight, save weight as least and update current to index of location
            if(adjMat[target][j] != 0 && adjMat[target][j] < least)
            {
                least = adjMat[target][j];
                current = j;
                steps.remove(steps.size() - 1);
            }
        }

        // if the selected node has been visited already, change the current node to the last least value seen
        if(visited.contains(current))
        {
            current = steps.get(steps.size() - 1);
        }

        // add current node to list if visited vertices
        visited.add(current);

        // remove current node from list of unvisited vertices
        if(unvisited.contains(current)){
            if(current >= 0 && current < unvisited.size()){
                unvisited.remove(current);
            }
            
        }
        // return the updates total value
        return least;
    }
}