public class Solution {
    public double Power(double base, int exponent) {
        double result = 0;
        double temp = 1;
        //--以零为底的指数幂没有意义
        if (base == 0) {
            System.out.println("以零为底没有意义");
        }
        
        //--exponent 是int类型的整数，其可以取正，负，零三种情况
        if(exponent == 0) {
            result = 1;
        }
        if(exponent > 0) {
            for(int i = 0; i < exponent; i++) {
                temp = temp * base; 
            }
            result = temp;
            if(temp > 1.7976931348623157E308) {
                System.out.println("已经超出double类型的取值范围");
                result = -1;
            }
        }
        if(exponent < 0) {
            exponent = -exponent;
            for(int i = 0; i < exponent; i++) {
                temp = temp * base; 
            }
            if(temp > 1.7976931348623157E308) {
                System.out.println("已经超出double类型的取值范围");
                result = -1;
            }
            result = 1.0 / temp; 
        }
        return result;
    }
}