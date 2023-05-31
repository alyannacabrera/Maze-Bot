package mazebot2;

import java.awt.Color;
import java.io.*;
import java.util.*;

public class MazeTEST {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        int startROW = 0, startCOLUMN = 0, endROW = 0, endCOLUMN = 0;

        Scanner sc = new Scanner(new File("maze.txt"));
        int n = sc.nextInt();
        sc.nextLine();

        int[][] grid = new int[n][n];
        MazeView mazeView = new MazeView(n);
        for (int row = 0; row < n; row++) {
            char[] chars = sc.nextLine().toCharArray();
            for (int column = 0; column < n; column++) {
                if (chars[column] == '#'){
                    grid[row][column] = 0;
                    mazeView.setMazeTileBackground(row, column, Color.BLACK);
                }
                else if (chars[column] == '.'){
                    grid[row][column] = 1;
                    mazeView.setMazeTileBackground(row, column, Color.WHITE);

                }
                else if (chars[column] == 'S'){
                    grid[row][column] = 1;
                    startROW = row;
                    startCOLUMN = column;
                    mazeView.setMazeTileBackground(row, column, Color.BLUE);
                    mazeView.setMazeBot(row, column);

                }
                else if (chars[column] == 'G')
                {
                    grid[row][column] = 1;
                    endROW = row;
                    endCOLUMN = column;
                    mazeView.setMazeTileBackground(row, column, Color.RED);

                }

            }
        }
        Maze maze = new Maze(n, grid, startROW, startCOLUMN, endROW, endCOLUMN, mazeView);
        MazeSOLVE solve = new MazeSOLVE(maze);


        System.out.println();
        if (solve.traverse(startROW, startCOLUMN)){
            maze.traverseBot();

            System.out.println("The maze was successfully traversed!");
            mazeView.setSummaryVisibility(true);
            mazeView.setSummaryResult("The maze was successfully traversed!");
        }
        else{
            System.out.println("There is no possible path.");
            mazeView.setSummaryVisibility(true);
            mazeView.setSummaryResult("There is no possible path.");
        }


        System.out.println(maze);
    }
}