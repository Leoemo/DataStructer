public class MazeRecursion {


    public static void main(String[] args) {

        int[][] maze = initializeMaze(7, 7);
        maze[2][1] = 1;
        maze[2][2] = 1;
        maze[2][5] = 1;

        crossMaze(maze, 1, 1);
        showMaze(maze);
    }


    public static boolean crossMaze(int[][] maze, int i, int j) {
        if (maze[5][1] == 2) {
            return true;
        }
        //按照从右->下->左->上路径,0未走,1墙壁,2可走,3已走过,但是是死路
        if (maze[i][j] == 0) {
            maze[i][j] = 2;
            if (crossMaze(maze, i, j + 1)) {
                return true;
            } else if (crossMaze(maze, i + 1, j)) {
                return true;
            } else if (crossMaze(maze, i, j - 1)) {
                return true;
            } else if (crossMaze(maze, i - 1, j)) {
                return true;
            } else {
                maze[i][j] = 3;
                return false;
            }
        }
        return false;
    }

    public static int[][] initializeMaze(int length, int width) {
        int maze[][] = new int[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || j == 0 || i == width - 1 || j == length - 1) {
                    maze[i][j] = 1;
                }
            }
        }
        return maze;
    }

    public static void showMaze(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }

    }
}

