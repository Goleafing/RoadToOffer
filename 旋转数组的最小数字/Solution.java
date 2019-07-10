import java.util.ArrayList;
/**
 * This program demonstrates 剑指offer：旋转数组的最小数字.
 * @version 1.0 2019-1-15
 * @author Jiang Ling
*/
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int index = 0;
        if(array.length == 0) {
            return 0;
        }
        else {
            for(int i = 0; i < array.length; i++) {
                if(array[index] > array[i]) {
                    index = i;
                }
            }
            return array[index];
        }    
    }
}