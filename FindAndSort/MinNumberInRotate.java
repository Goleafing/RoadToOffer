package FindAndSort;

import java.awt.event.HierarchyBoundsAdapter;
import java.util.Scanner;

/**
 * @author leaf
 * @date 2019-9-1 9:21
 */
public class MinNumberInRotate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] inputArray = new int[num];
        for(int i = 0; i < num; i++){
            inputArray[i] = sc.nextInt();
        }
        MinNumberInRotate obj = new MinNumberInRotate();
        //System.out.println(obj.minNumberInRotateArray(inputArray));
        //System.out.println(obj.minNumberByBinarySearch(inputArray));
        //System.out.println(minNumberByBinarySearch(inputArray));
        System.out.println(obj.getMinIndex(inputArray,3));
        sc.close();
    }
    public int minNumberInRotateArray(int[] array){
        if(array.length == 0){
            return 0;
        }
        int min = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] < min){
                min = array[i];
            }
        }
        return min;
    }

    //这道题主要想考查的是二分查找的变形，那么对其进行二分查找可以降低时间复杂度
    private static int minNumberByBinarySearch(int[] array){
        int start = 0;
        int end = array.length - 1;
        while (end > start){
            int mid = start + (end - start) / 2;
            if(array[mid] > array[end]){
                start = mid + 1;
            }else if(array[mid] == array[end]){
                end = end - 1;
            }else{
                end = mid;
            }
        }
        return array[start];
    }

    //补充一个问题，猿辅导面试的问题：单调不递减的数组和一个target，找出来等于target的最小下标。
    //
    //{1, 2, 2, 3, 3, 5, 7}
    //
    //public int getMinIndex(int[] a, int target) {
    //
    //}
    //暴力求求解法可以进行直接解决，如何进行优化
    public int getMinIndex(int[] a, int target){
        if(a.length == 0 || a == null){
            return -1;
        }
        int low = 0;
        int high = a.length - 1;
        while (low < high){
            int mid = low + (high - low) >> 1;
            if(a[mid] < target){
                low = mid + 1;
            }else if(a[mid] > target){
                high = mid - 1;
            }else{
                if(mid == 0 || a[mid - 1] != target){
                    return mid;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

}
