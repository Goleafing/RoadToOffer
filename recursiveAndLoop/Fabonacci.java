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

    private static int caculateFaboByRecursive(int n){
        if(n < 0){
            return -1;
        }
        if(n > 39){
            return -1;
        }
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else{
            return caculateFaboByRecursive(n - 1) + caculateFaboByRecursive(n - 2);
        }
    }

}
