import java.util.ArrayList;

/**
 * 的很好，叫做双指针技术，就是相当于有一个窗口，窗口的左右两边就是两个指针，
 * 我们根据窗口内值之和来确定窗口的位置和宽度。非常牛逼的思路，
 * 虽然双指针或者所谓的滑动窗口技巧还是蛮常见的，但是这一题还真想不到这个思路。
 */
public class FindContinuousSequence{
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum){
        //存放结果
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int plow = 1, phigh = 2;
        while(phigh > plow){
            //由于是连续的，差为1的一个序列，那么求和公式为(a0+a1)/2
            int currentSum = (phigh + plow) * (phigh - plow + 1) / 2;
            //相等，那么就将窗口内的所有值添加进结果集
            if(currentSum == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i = plow; i <= phigh; i++){
                    list.add(i);
                }
                result.add(list);
                plow++;
                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            }else if(currentSum < sum){
                phigh++;
            }else{
                //如果当前窗口内的和大于sum，那么左边窗口右移以下
                plow++;
            }   
        }
        return result;
    }
    
}