/**
 * Created by sw913 on 2017/5/30.
 */
import java.lang.*;
import java.util.Scanner;
public class LongestSubString {
    public static int lengthOfLongestSubstring(String s) {
        String ss = "";
        int maxlength = 0;
        int temp = 0;
        int currentposition = 0;

        for (int i = 0; i < s.length() ; i++) {
            //如果ss字符串中不存在刚刚扫描到的这个字符
            if(ss.indexOf(s.charAt(i)) == -1){
                temp+=1;
                ss+=s.charAt(i);
            }
            else {

                //这一个重复字符是已经匹配好的字符的第一位
                //要把第一次重复的位置的字母截取掉，否则会陷入死循环
                maxlength = Math.max(temp,maxlength);
                //如果重复，i就从重复的哪一位的下一位开始走
                i = currentposition;
                currentposition += 1;
                ss = "";
                temp = 0;
            }
        }
        maxlength = Math.max(temp,maxlength);
        return maxlength;
    }

}
