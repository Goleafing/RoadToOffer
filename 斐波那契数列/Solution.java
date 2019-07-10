/**
 * This program demonstrates 剑指offer：大家都知道斐波那契数列，
 * 现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39.
 * @version 1.0 2019-1-15
 * @author Jiang Ling
*/

public class Solution {
    public int Fibonacci(int n) {
        int[] fibonacciArrary = new int[40];
        fibonacciArrary[0] = 0;
        fibonacciArrary[1] = 1;
        for(int i = 0; i <= 37; i++) {
            fibonacciArrary[i + 2] = fibonacciArrary[i + 1] + fibonacciArrary[i];
        }
        return fibonacciArrary[n];
    }
}