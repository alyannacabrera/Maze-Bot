package mazebot2;

public class MazeSOLVE {
    private Maze maze;

    public MazeSOLVE(Maze maze)
    {
        this.maze = maze;
    }

    public boolean traverse(int row, int column)
    {
        boolean done = false;

        if (maze.validPosition(row, column))
        {
            maze.tryPosition(row, column);

            if (maze.solved(row, column))
                done = true;

            else
            {
                if (!done)
                    done = traverse(row, column+1);
                if (!done)
                    done = traverse(row+1, column);
                if (!done)
                    done = traverse(row, column-1);
                if (!done)
                    done = traverse(row-1, column);
            }

            if (done){
                maze.markPath(row, column);

            }
        }
        return done;
    }

}