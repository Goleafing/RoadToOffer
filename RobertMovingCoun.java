/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class RobertMovingCount{
    public int movingCount(int threshold, int rows, int cols){
        boolean[] visited = new boolean[rows *cols];
        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }

    private int movingCountCore(int threshold, int rows, int cols, 
                                int startRow, int startCol, boolean[] visited){
        if(startRow < 0 || startRow >= rows || startCol < 0 || startCol >= cols){
            return 0;
        }
        int i = startRow * cols + startCol;
        if(visited[i] || !checkSum(threshold, startRow, startCol)){
            return 0;
        }
        visited[i] = true;
        return 1 + movingCountCore(threshold, rows, cols, startRow + 1, startCol, visited)
                 + movingCountCore(threshold, rows, cols, startRow - 1, startCol, visited)
                 + movingCountCore(threshold, rows, cols, startRow, startCol + 1, visited)
                 + movingCountCore(threshold, rows, cols, startRow, startCol - 1, visited);
    }

    private boolean checkSum(int threshold, int startRow, int startCol){
        int sum = 0;
        while(startRow != 0){
            sum += startRow % 10;
            startRow = startRow / 10;
        }

        while(startCol != 0){
            sum += startCol % 10;
            startCol = startCol / 10;
        }
        if(sum > threshold){
            return false;
        }
        return true;
    }
}