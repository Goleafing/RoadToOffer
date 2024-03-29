/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，
 * 向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
/**
 * 回溯算法：
 * 1.根据给定数组，初始化一个标志位数组，初始化false，表示未走过，true表示已走过，不能走第二次
 * 2.根据行数和列数，遍历数组，先找到一个与str字符串第一元素匹配的矩阵元素，进入judge
 * 3.根据i和j先确定一维数组的位置，因为给定的matrix就是一个一维数组
 * 4.确定递归终止条件：越界，当前找到的矩阵值不等于数组对应位置的值，已经走过的，这三类情况，都是直接false，表示此路不通
 * 5.若k，就是待判定的字符串str的索引已经判断了最后一位，说明匹配是成功的
 * 6.对于本体来说，递归不断寻找周围的四个格子是否符合条件，只要有一个格子符合条件，就继续寻找该格子四周是否存在符合条件的格子
 * 直到k到达末尾或者不满足递归条件为止
 * 7.本次匹配不成功，还原标志位数组index处的标志位，进入下一轮判断
 */

public class HasPathInMatrix{
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        //标志位，初始化为false
        boolean[] flag = new boolean[matrix.length];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                //循环遍历二维数组，找到起点等于str的第一个元素的值，在递归判断四周是否有符合条件的---回溯法
                if(judge(matrix, i, j, rows, cols, flag, str, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    //judge(初始矩阵，索引行坐标i，索引列坐标j，矩阵行数，矩阵列数，待判断的字符串，字符串索引初始为0即先判断字符串的第一位)
    private boolean judge(char[] matrix, int i, int j, int rows, int cols, boolean[] flag, char[] str, int k){
        //先根据i和j计算匹配的第一个元素转为一维数组的位置
        int index = i * cols + j;
        //递归终止条件
        if(i < 0 || j < 0 || i >= rows || j >= cols || matrix[index] != str[k] || flag[index] == true){
            return false;
        }
        //若k已经到达str末尾，说明之前的匹配成功了，直接返回true
        if(k == str.length - 1){
            return true;
        }
        //要走的第一个位置为true，表示已将走过了
        flag[index] = true;

        //回溯，递归寻找，每次找到了就给k加一，找不到还原
        if(judge(matrix, i - 1, j, rows, cols, flag, str, k + 1) ||
           judge(matrix, i + 1, j, rows, cols, flag, str, k + 1) ||
           judge(matrix, i, j - 1, rows, cols, flag, str, k + 1) ||
           judge(matrix, i, j + 1, rows, cols, flag, str, k + 1)  ){

           return true;
        }
        //走到这一步说明这一条路不通，还原，尝试其他路径
        flag[index] = false;
        return false;
    }
}