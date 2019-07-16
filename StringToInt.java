/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 
 * 数值为0或者字符串不是一个合法的数值则返回0。
 * 输入一个字符串,包括数字字母符号,可以为空
 * 如果是合法的数值表达则返回该数字，否则返回0
 */
public class StringToInt{
    public static boolean flag;
    public static int stringToInt(String str) {
        flag = false;
        if(str == null || str.trim().equals("")){
            flag = true;
            return 0;
        }
        // symbol=0,说明该数为正数;symbol=1，该数为负数;start用来区分第一位是否为符号位
        int symbol = 0;
        int start = 0;
        char[] charsArray = str.trim().toCharArray();
        if(charsArray[0] == '+'){
            start = 1;
        }else if(charsArray[0] == '-'){
            start = 0;
        }
        int result = 0;
        for(int i = start; i < charsArray.length; i++){
            if(charsArray[i] > '9' || charsArray[i] < '0'){
                flag = true;
                return 0;
            }
            int sum = result * 10 + (int)(charsArray[i] - '0');
            if((sum - (int)(charsArray[i] - '0')) / 10 != result){
                flag = true;
                return 0;
            }
            result = result * 10 + (int)(charsArray[i] - '0');
        }
        result = (int)Math.pow(-1, symbol) * result;
        return result;
    }
    Integer i1 = new Integer(Integer.valueOf(str));
    
}