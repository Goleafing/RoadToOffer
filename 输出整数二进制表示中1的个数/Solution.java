/**
 * This program demonstrates 剑指offer：输入一个整数，
 * 输出该数二进制表示中1的个数。其中负数用补码表示。
 * @version 1.0 2019-1-15
 * @author Jiang Ling
*/
public class Solution {
    public int NumberOf1(int n) {
        /*
        //--该方法用时较长
        int counter = 0;
        int index = 1;
        while(index != 0){
            if((n & index) != 0) {
                counter++;
                index = index << 1;
            }
        }
        return counter;
        */

        int counter = 0;
        String str = Integer.toBinaryString(n);
        char[] ch = str.toCharArray();
        for(int i = 0; i < ch.length; i++) {
            if(ch[i] == '1') {
                counter++;
            }
        }
        return counter;
    }
}