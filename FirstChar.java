/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class FirstChar{
    private int[] count = new int[256];
    private int index;
    public FirstChar(){
        for(int i = 0; i < 256; i++){
            count[i] = -1;
        }
        index = 0;
    }

    public void Insert(char ch){
        if(count[ch] == -1){
            count[ch] = index;
        }else if(count[ch] >= 0){
            count[ch] = -2;
        }
        index++;
    }

    //Return the first apperance once char in current stringstream
    public char firstApperanceOnce(){
        char ch = '\0';
        int minIndex = Integer.MAX_VALUE;
        for(int i = 0; i < 256; i++){
            if(count[i] >= 0 && count[i] < minIndex){
                ch = (char)i;
                minIndex = count[i];
            }
        }
        if(ch == '\0'){
            return '#';
        }
        return ch;
    }
        
}