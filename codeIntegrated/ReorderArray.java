package codeIntegrated;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author leaf
 * @date 2019-9-5 21:53
 */
public class ReorderArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] inputArray = new int[num];
        for(int i = 0; i < num; i++){
            inputArray[i] = sc.nextInt();
        }
        for(int e : reorderArrayMethod(inputArray)){
            System.out.print(e);
        }

    }

    private static int[] reorderArrayMethod(int[] inputArray) {
        if(inputArray == null || inputArray.length == 0){
            return null;
        }
        Queue<Integer> oddQueue = new ArrayDeque<>();
        Queue<Integer> evenQueue = new ArrayDeque<>();
        for(int i = 0; i < inputArray.length; i++){
            if(inputArray[i] % 2 == 0){
                evenQueue.add(inputArray[i]);
            }
            if(inputArray[i] % 2 == 1){
                oddQueue.add(inputArray[i]);
            }
        }
        /*for(int e : oddQueue){
            System.out.print(e);
        }
        System.out.println("-------------------");
        for(int e : evenQueue){
            System.out.print(e);
        }*/
//        System.out.println("------------------------");
//        System.out.println(oddQueue.poll());
//        System.out.println(oddQueue.size());
        int oddNumber = oddQueue.size();
        for(int i = 0; i < oddNumber; i++){
            inputArray[i] = oddQueue.poll();
        }
        for(int i = oddNumber; i < inputArray.length; i++){
            inputArray[i] = evenQueue.poll();
        }
        return inputArray;
    }
}
