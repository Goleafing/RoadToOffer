import java.util.LinkedHashMap;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)
 * 中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class FindFirstChar{
    public int FirstNotRepeatingChar(String str){
        char[] c = str.toCharArray();
        int[] a = new int['z' + 1];
        for(char d : c){
            a[(int)d]++;
        }
        for(int i = 0; i < c.length; i++){
            if(a[(int)c[i]] == 1){
                return i;
            }
        }
        return -1;
    }

    public int FirstNotRepeatingChar_1(String str){
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < str.length(); i++){
            if(map.containsKey(str.charAt(i))){
                int time = map.get(str.charAt(i));
                map.put(str.charAt(i),++time);
            }else{
                map.put(str.charAt(i), 1);
            }  
        }
        int pos = -1;
        int i = 0;
        for(;i < str.length(); i++){
            char c = str.charAt(i);
            if(map.get(c) == 1){
                return i;
            }
        }
        return pos;
    }
}