import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： 
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， 
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxWindows{
    public ArrayList<Integer> maxWindows(int[] num, int size){
        ArrayList<Integer> resultList = new ArrayList<>();
        if(size <= 0){
            return resultList;
        }
        int begin = 0;
        ArrayDeque<Integer> tempDeque = new ArrayDeque<>();
        for(int i = 0; i < num.length; i++){
            begin = i - size + 1;
            if(tempDeque.isEmpty()){
                tempDeque.add(i);
            }else if(begin > tempDeque.peekFirst()){
                tempDeque.pollFirst();
            }
            while((!tempDeque.isEmpty()) && num[tempDeque.peekLast()] <= num[i]){
                tempDeque.pollLast();
            }
            tempDeque.add(i);
            if(begin >= 0){
                resultList.add(num[tempDeque.peekFirst()]);
            }
        }
        return resultList;
    }

    public ArrayList<Integer> maxWindowsByPlainLoop(int[] num, int size){
        ArrayList<Integer> resultList = new ArrayList<>();
        if(num == null || num.length < size || size <= 0){
            return resultList;
        }
        for(int i = 0; i <= num.length - size; i++){
            int max = num[i];
            for(int j = i + 1; j < i + size; j++){
                if(num[j] > max){
                    max = num[j];
                }
            }
            resultList.add(max);
        }
        return resultList;
    }
}