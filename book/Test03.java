package book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Test03 {
    public static void main(String[] args) {
        int[] intputArray = {2,3,0,2,4,5,3};
        for(int i : methodCore2(intputArray)){
            System.out.println(i);
        }
    }

    private static ArrayList<Integer> methodCore(int[] inputArray){
        ArrayList<Integer> resultList = new ArrayList<>();
        Arrays.sort(inputArray);
        for(int i = 0; i < inputArray.length - 1; i++){
            for(int j = i + 1; j < inputArray.length; j++){
                if(inputArray[i] == inputArray[j]){
                    resultList.add(inputArray[i]);
                }
            }
        }
        return resultList;
    }

    /*private static ArrayList<Integer> methodCore2(int[] inputArray){
        ArrayList<Integer> resultList = new ArrayList<>();
        HashSet<Integer> tempSet = new HashSet<>();
        for(int i = 0; i < inputArray.length; i++){
            tempSet.add(inputArray[i]);
        }
    }*/

    /**
     * 利用hashmap特性，进行重复数字的查找
     * 思路是：将输入数组进行遍历，将数组的值作为key，如果存在当前值的话，将其value加一
     *          否则value的值为1，然后利用forEach进行value值大于1的进行查找返回
     * @param inputArray
     * @return ArrayList<Integer>
     */
    private static ArrayList<Integer> methodCore2(int[] inputArray){
        ArrayList<Integer> resultList = new ArrayList<>();
        HashMap<Integer,Integer> tempMap = new HashMap<>();
        for(int i = 0; i < inputArray.length; i++){
            if(tempMap.containsKey(inputArray[i])){
                tempMap.put(inputArray[i],tempMap.get(inputArray[i])+1);
            }else{
                tempMap.put(inputArray[i],1);
            }
        }
        tempMap.forEach((key,value)->{
            if(value>1){
                resultList.add(key);
                System.out.println(key+" : "+value);
            }
        });
        return resultList;
    }

    
}
