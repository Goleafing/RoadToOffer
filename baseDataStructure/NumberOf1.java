package baseDataStructure;

import java.util.Scanner;

/**
 * @author leaf
 * @date 2019-9-5 10:18
 */
public class NumberOf1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(numberOf1Method(n));
    }

    private static int numberOf1Method(int n){
        if(n == 0){
            return 0;
        }
        int count = 0;
        while (n != 0){
            count += 1;
            n = (n - 1) & n;
        }
        return count;
    }
}
