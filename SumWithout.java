/**
 * 求1+2+3+...+n，要求不能使用乘除法、
 * for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class SumWithout{
    public int sumSolution(int n){
        //sum = n * (n+1) / 2
        int sum = (int)(Math.pow(n, 2) + n);
        return sum >> 1;
    }
    
    //采用二维数组下标,用到了乘法，并不行
    public int sumSolutionByArray(int n){
        int[][] tempArray = new int[n][n+1];
        int count  = tempArray.length * tempArray[0].length;
        return count >> 1;
    }

    /**
     * 采用递归的方法，但是要解决一个问题就是递归的终止条件
     * 解题思路：
     * 1.如何终止递归？可以采用逻辑与的短路特性进行终止，且没有用到条件判断符
     * 2.如何进行递归？sum = sum + sum_Solution(n - 1)
     */
    public int sumSolutionByRecursive(int n){
        int sum = n;
        boolean ans;
        ans = (n > 0) && ((sum += sumSolutionByRecursive(n - 1)) > 0);
        return sum;
    }
    
    
}