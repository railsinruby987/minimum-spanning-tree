/**
 * Created by enosh on 6/18/17.
 */
import java.util.Scanner;
import java.util.Random;

public class PrimTestDrive {

    static Scanner scan;
    //Example input for size of 4
//        0 2 0 6 0
//        2 0 3 8 5
//        0 3 0 0 7
//        6 8 0 0 9
//        0 5 7 9 0
    public static void main(String[] args) {
        scan = new Scanner(System.in);
        System.out.println("Enter the size of matrix");
        int n = scan.nextInt();
        int[][] matrix = new int[n][n];
        int[] visited = new int[n];                                             //stores all the visited vertices
        System.out.println("Enter the matrix");
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            visited[i] = 0;
            for (int j = 0; j < n; j++) {
              int randomNum = rand.nextInt((9 - 1) + 1) + 1;
                matrix[i][j] = randomNum;
                System.out.print(matrix[i][j] + " ");
                if (matrix[i][j] == 0) {

                    matrix[i][j] = 299;
                }
            }
            System.out.println("");
        }
        System.out.println("Minimum spanning tree :");
    prim(matrix);
    }

    //prim algorithm to find minimum spanning tree
    //params : adjacency matrix
    //effects : finds the miniumum spanning tree using prim algorithm
    //returns : none
    //output example (1,2),(2,3)
    private static void prim(int[][] matrix) {
        final long startTime = System.currentTimeMillis();
        int countSteps = 0;
        int visited[] = new int[matrix.length];
        visited[0] = 1;
        int total = 0;
        for(int counter = 0; counter < matrix.length - 1 ; counter++){
        int min = 999;
        int u = 0,v = 0;
            for(int i = 0; i < matrix.length; i++){
                countSteps++;
                if(visited[i]==1){
                    for(int j = 0; j < matrix.length; j++){
                        if(visited[j]==0){
                            if(min > matrix[i][j]){
                                min = matrix[i][j];
                                u = i;
                                v = j;
                            }
                        }
                    }
                }
            }
            visited[v] = 1;
            matrix[u][v] = matrix[u][v] = 299;
            System.out.print("("+u+","+v+")");
        }
        System.out.println("");
        final long duration = System.currentTimeMillis() - startTime;
        System.out.println("Time: " + duration);
        System.out.println("Steps: " + countSteps);
    }
}