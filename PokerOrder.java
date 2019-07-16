import java.util.Arrays;

/**
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王
 * (一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,
 * 看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....
 * LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,
 * 然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，
 * 否则就输出false。为了方便起见,你可以认为大小王是0。
 */
public class PokerOrder{
    //逻辑不是很清晰
    /* public boolean isContinuous(int[] numbers){
        if(numbers == null){
            return false;
        }
        Arrays.sort(numbers);
        int zeroNumbers = 0;
        int i = 0;
        //统计数组中0的个数
        for(; i < numbers.length && numbers[i] == 0; i++){
            zeroNumbers++;
        }
        for(; i < numbers.length - 1 && zeroNumbers >= 0; i++){
            //出现两个相邻的相等的数，表明并不是顺子
            if(numbers[i] == numbers[i+1]){
                return false;
            }
            if(numbers[i] + 1 + zeroNumbers >= numbers[i+1]){
                zeroNumbers -= numbers[i+1] - numbers[i+1] -1;
            }else{
                return false;
            }
        }
        if(i == numbers.length - 1){
            return true;
        }else{
            return false;
        }
    } */

    /**
     * 思路：
     * 记录最大值:max
     * 记录最小值:min
     * min,max都不记为0
     * 顺子需要满足的条件是：
     * 1.max - min < 5
     * 2.除0外没有重复的数字
     * 3.数组长度为5
     */
   /*  public boolean isContinuous(int[] numbers){
        int[] tempArray = new int[14];
        tempArray[0] = -5;
        int len = numbers.length;
        int max = -1;
        int min = 14;
        for(int i = 0; i < len; i++){
            tempArray[numbers[i]]++;
            if()
        }
    } */
}