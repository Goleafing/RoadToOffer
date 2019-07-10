/**
 * This program demonstrates 剑指offer：我们可以用2*1的小矩形
 * 横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 画图更加清晰
 * @version 1.0 2019-1-15
 * @author Jiang Ling
*/

public class Solution {
    public int RectCover(int target) {
        return recover(target);
    }
    private static int recover(int target) {
        if(target == 0) {
            return 0;
        }
        if(target == 1 || target == 2) {
            return target;
        }
        return recover(target - 1) + recover(target - 2);
    }
}