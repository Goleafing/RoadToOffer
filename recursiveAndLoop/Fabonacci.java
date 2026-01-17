package recursiveAndLoop;

import java.util.Scanner;
/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */

/**
 * @author leaf
 * @date 2019-9-5 9:54
 */
public class Fabonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(caculateFaboByRecursive(n));
    }

    private static long calculateFibo(int n){
        if(n < 0){
            return -1;
        }
        if(n > 92){
            return -1;
        }
        if(n <= 1){
            return n;
        }
        return calculateFiboLoop(n);
    }

    private static long calculateFiboLoop(int n){
        long a = 0, b = 1;
        for(int i = 2; i <= n; i++){
            long sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

}
