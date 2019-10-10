package book;

import java.util.ArrayList;
import java.util.Arrays;

public class Test03 {
    public static void main(String[] args) {
        int[] intputArray = {2,3,0,2,4,5,3};
        for(int i : methodCore(intputArray)){
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
}
