/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 */
public class FindNumber {
    public int MoreThanHalfNum_Solution(int [] array) {
        int length = array.length;
        if(array == null || length <= 0){
            return 0;
        }
        int result = array[0];
        int times = 1;
        for(int  i = 0; i < length; i++){
            if(times == 0){
                result = array[i];
                times = 1;
            }else{
                if(array[i] == result){
                    times += 1;
                }else{
                    times -= 1;
                }
            }
        }

        times = 0;
        for(int i = 0; i < length; i++){
            if(result == array[i]){
                times++;
            }
        }

        if(times * 2 < length){
            result = 0;
        }
        return result;
    }
}