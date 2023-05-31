package mazebot2;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.*;


public class Maze {
    private static final int UNEXPLORED = 1;
    private static final int EXPLORED = 2;
    private static final int PATH = 3;

    private int startROW, startCOLUMN, endROW, endCOLUMN, n;
    private int[][] grid;
    private MazeView mazeView;

    private int pathCount;
    ArrayList <Integer> pathX;
    ArrayList <Integer> pathY;

    public Maze(int n, int[][] grid, int startROW, int startCOLUMN, int endROW, int endCOLUMN, MazeView mazeView) throws FileNotFoundException
    {
        this.n = n;
        this.grid = grid;
        this.startROW = startROW;
        this.startCOLUMN = startCOLUMN;
        this.endROW = endROW;
        this.endCOLUMN = endCOLUMN;
        this.mazeView = mazeView;

        pathX = new ArrayList<>();
        pathY = new ArrayList<>();
        printMaze();

    }

    public void printMaze(){
        for (int row1 = 0; row1 < n; row1++) {
            for (int column1 = 0; column1 < n; column1++) {
                System.out.print(grid[row1][column1]);
            }
            System.out.println();
        }
    }

    public void tryPosition(int row, int col)
    {
        if(!(row == startROW && col == startCOLUMN) && !(row == endROW && col == endCOLUMN))
            mazeView.setMazeTileBackground(row, col, Color.yellow);
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {}
        grid[row][col] = EXPLORED;


    }

    public boolean solved(int row, int col)
    {
        return (row == endROW && col == endCOLUMN);
    }

    public void markPath(int row, int col){
        if(!(row == endROW && col == endCOLUMN)){
            mazeView.setMazeTileBackground(row, col, Color.GREEN);
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {}

        }
        grid[row][col] = PATH;
        pathX.add(0, row);
        pathY.add(0, col);
    }

    public boolean validPosition(int row, int col)
    {
        boolean result = false;

        if (row >= 0 && row < n && col >= 0 && col < n)
            if (grid[row][col] == UNEXPLORED)
                result = true;

        return result;
    }

    public String toString()
    {
        String result = "\n";
        int pathCOUNT = 0;
        int exploredCOUNT = 0;
        for (int x = 0; x < n; x++)
        {
            for (int y = 0; y < n; y++) {
                result += grid[x][y] + "";
                if (grid[x][y]==3 && !(x==endROW && y==endCOLUMN)){
                    pathCOUNT++;
                    exploredCOUNT++;
                }
                if (grid[x][y]==2 && !(x==endROW && y==endCOLUMN)){
                    exploredCOUNT++;
                }
            }
            result += "\n";
        }
        System.out.println();
        System.out.println("Total Nodes Explored: "+exploredCOUNT);
        System.out.println("Total Nodes Explored in Final Path: "+pathCOUNT);
        mazeView.setSummaryStats("Total Nodes Explored: "+exploredCOUNT);
        mazeView.setSummaryStats2("Total Nodes Explored in Final Path: "+pathCOUNT);
        return result;
    }

    public void traverseBot(){

        for(int i=0; i<pathX.size()-1; i++){
            mazeView.removeMazeTileIcon(pathX.get(i), pathY.get(i));
            mazeView.setMazeBot(pathX.get(i+1), pathY.get(i+1));
            try {
                Thread.sleep(400);
            } catch (InterruptedException ex) {}
        }
    }


}