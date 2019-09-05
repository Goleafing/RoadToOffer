package baseDataStructure;

import java.util.Scanner;


/**
 * @author leaf
 * @date 2019-8-29 21:17
 */

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

public class FindTargetInArray {
    public static void main(String[] args) {
        int[][] inputArray = {{1,2,3},{4,5,6}};
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        System.out.println(findMethodCore(inputArray, target));

        System.out.println(findMethodCoreByLeft(inputArray, target));

        sc.close();
    }

    private static boolean findMethodCore(int[][] inputArray, int target){
        boolean flag = false;
        if(inputArray == null || inputArray.length == 0){
            flag = false;
        }

        for(int i = 0; i < inputArray.length; i++){
            for(int j = 0; j < inputArray[i].length; j++){
                if(target == inputArray[i][j]){
                    flag = true;
                }
            }
        }
        return flag;
    }

    public static boolean findMethodCoreByLeft(int[][] inputArray, int target){
        int rows = inputArray.length;
        if(rows == 0){
            return false;
        }
        int cols = inputArray[0].length;
        if(cols == 0){
            return false;
        }
        int row = rows - 1;
        int col = 0;
        while ((row >= 0 && col < cols)){
            if(inputArray[row][col] < target){
                col++;
            }else if(inputArray[row][col] > target){
                row--;
            }else{
                return true;
            }
        }
        return false;
    }

    //从右上的思维和从左下的思维一样

}
