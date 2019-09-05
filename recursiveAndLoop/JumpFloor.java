package recursiveAndLoop;

import java.util.Scanner;
/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */

/**
 * @author leaf
 * @date 2019-9-5 10:01
 */
public class JumpFloor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(jumpFloor(n));
    }

    private static int jumpFloor(int target){
        if(target <= 0){
            return -1;
        }
        if(target == 1){
            return 1;
        }else if(target == 2){
            return 2;
        }else{
            return jumpFloor(target - 1) + jumpFloor(target - 2);
        }
    }
}
