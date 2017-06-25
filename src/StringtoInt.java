import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by sw913 on 2017/6/16.
 */
public class StringtoInt {
     private static final Map<Character,Integer> map;
     static{
         map = new HashMap<Character,Integer>();
         map.put('+',1);
         map.put('-',1);
         for (int i = 0; i < 10; i++) {
             String s = "" + i;
             Character cc = s.charAt(0);
             map.put(cc,1);
         }
     }
     private static final Map<Character,Integer> map2 = new HashMap<Character,Integer>(){
         {
             put('+',1);
             put('-',1);
             for (int i = 0; i < 10; i++) {
                 String s2 = ""+i;
                 Character c2 = s2.charAt(0);
                 put(c2,1);
             }
         }
     };

    public static int myAtoi(String str){
        //判断Stirng是否空
        str = str.replace("+","");
        int len = str.length();
        int result = 0;
        if(len == 0){
            return 0;
        }else{
            if(str.charAt(0)=='-'){
                for (int i = len-1,j=0; i > 0 ; i--) {
                    if(!map.containsKey(str.charAt(i))){
                        result = 0;
                        break;
                    }else{
                        result += ((int)str.charAt(i)-48) * Math.pow(10,j);
                        j++;
                    }
                }
                result *= -1;
            }else{
                for (int i = len-1,j=0; i >= 0 ; i--) {
                    if(!map.containsKey(str.charAt(i))){
                        result = 0;
                        break;
                    }else{
                        result += ((int)str.charAt(i)-48) * Math.pow(10,j);
                        j++;
                    }
                }
            }
        }
        return result;
    }


}
