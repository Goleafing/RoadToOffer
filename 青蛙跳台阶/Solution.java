/**
 * This program demonstrates 剑指offer：一只青蛙一次可以跳上1级台阶，
 * 也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法?
 * （先后次序不同算不同的结果）。
 * 
 * 还有一种情况是一只青蛙一次可以跳上1级台阶，也可以跳上2级......
 * 也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法?
 * （先后次序不同算不同的结果）
 * 
 * @version 1.0 2019-1-15
 * @author Jiang Ling
*/

//--一只青蛙一次可以跳上1级台阶，也可以跳上2级。
public class Solution {
    public int JumpFloor(int target) {
        return cal_2(target);
    }
    //--一只青蛙一次可以跳上1级台阶，也可以跳上2级。
    private static int cal_2(int target) {
        if(target <= 0) {
            return -1;
        }
        if(target == 1 || target == 2) {
            return target;
        }
        return cal(target -1) + cal(target - 2);
    }

    //--一只青蛙一次可以跳上1级台阶，也可以跳上2级......也可以跳上n级。
    private static int cal_n(int target) {
        if(target < 0) {
            return -1;
        }
        if(target == 0) {
            return 0;
        }
        if(target == 1) {
            return 1;
        }
        return 2 * cal(target - 1);
    }
}
