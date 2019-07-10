import java.util.ArrayList;

/**
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 对应每个测试案例，输出两个数，小的先输出。
 * 解题思路：
 * 数组是排列好的，可以利用左右夹逼
 * 因为当和相同，乘积最小的必然是两个数相差最大的，可以通过函数进行证明
 */
public class FindNumWithSum{
    public ArrayList<Integer> findNumWithSum(int[] array, int sum){
        ArrayList<Integer> list = new ArrayList<>();
        //首先判断array是否为空以及array的长度是否不小于2
        if(array == null || array.length < 2){
            return list;
        }
        //设置角标，i为0，j为array的最大角标
        int i = 0, j = array.length - 1;
        //判断左边的角标是否小于右边的角标
        while(i < j){
            //遇到的第一对等于sum的两个数就是要寻找的数
            if(array[i] + array[j] == sum){
                list.add(array[i]);
                list.add(array[j]);
                return list;
            }else if(array[i] + array[j] > sum){
                j--;
            }else{
                i++;
            }
        }
        return list;
    }
}