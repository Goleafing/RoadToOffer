package codeIntegrated;

import java.security.interfaces.DSAPublicKey;

/**
 * @author leaf
 * @date 2019-9-5 21:32
 */
public class Power {
    public static void main(String[] args) {

    }

    private static double Power(double base, int exponent){
        double result = 1;
        if(exponent == 0){
            return result;
        }else{
            for(int i = 0; i < Math.abs(exponent); i++){
                result = result * base;
            }
        }
        if(exponent > 0){
            result = result;
        }
        if(exponent < 0){
            result = 1 / result;
        }
        return result;
    }

    private static double power2(double base, int exponent){
        if(exponent == 0 && base != 0){
            return 1;
        }
        if(exponent == 1){
            return base;
        }
        if(base == 0 && exponent <= 0){
            throw new RuntimeException();
        }
        if(base == 0 && exponent > 0){
            return 0;
        }
        int n = exponent;
        if(exponent < 0){
            n = - exponent;
        }
        double result = power2(base, n>>1);
        result *= result;
        if((n & 1) == 1){
            result *= base;
        }
        if(exponent < 0){
            result = 1 / result;
        }
        return result;
    }
}
