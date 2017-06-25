import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by sw913 on 2017/6/23.
 * 从左向右遍历，如果都比自己小或者等于自己，那么就加上
 * 如果是比自己大的话就给自己变号
 */
public class RomanToInteger {
    public static int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>(){
            {
                put('I',1);
                put('V',5);
                put('X',10);
                put('L',50);
                put('C',100);
                put('D',500);
                put('M',1000);
            }
        };
        int sum = 0;
        for(int i = 0;i < s.length();i++){
            if(i<s.length()-1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                sum-=map.get(s.charAt(i));
            }
            sum+= map.get(s.charAt(i));

        }
        return sum;
    }
}
