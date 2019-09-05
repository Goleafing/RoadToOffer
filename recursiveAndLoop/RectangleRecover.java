package recursiveAndLoop;

import java.util.Scanner;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */

/**
 * @author leaf
 * @date 2019-9-5 10:13
 */
public class RectangleRecover {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(recover(n));
    }

    private static int recover(int target){
        if(target <= 0){
            return 0;
        }
        if(target == 1 || target == 2){
            return target;
        }else{
            return recover(target - 1) + recover(target - 2);
        }
    }
}
